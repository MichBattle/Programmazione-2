package View;

import Controller.Fans;
import Controller.Ventilators.Ventilatore;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class CenterPane extends VBox {
    private ArrayList<Ventilatore> fans;
    private MainGUI mg;

    private int spesaNextMonth; //tiene traccia dei costi che verranno applicati il mese prossimo

    public CenterPane(MainGUI mg, Fans f) {
        super();
        this.mg = mg;
        spesaNextMonth = 0;
        fans = new ArrayList<>();
        fans = f.getVentilatori();

        update_center();
    }

    /**
     * aggiorna tutto il VBox
     * crea i cerchi e i testi affianco e li aggiunge al VBox
     * reimposta tutti i colori ad originali (perche viene chiamato da altri metodi)
     */
    public void update_center(){
        super.getChildren().clear();
        for(Ventilatore v : fans){
            HBox hb = crea_cerchio_testo(crea_cerchio(v), crea_testo(v.toString()));
            super.getChildren().add(hb);
        }
        resetAll();
    }

    /**
     * crea il cerchio con dentro il bottone
     * imposto l'azione del bottone
     * @param v
     * @return
     */
    private StackPane crea_cerchio(Ventilatore v){
        Button b = new Button();
        b.setOpacity(0);
        Circle c = new Circle(25.0);
        c.setFill(Color.BLUE);
        c.setStroke(Color.BLACK);
        c.setStrokeWidth(4);

        // Imposta le proprietà personalizzate
        b.setUserData(v);
        c.setUserData(v);

        setAction(b, c, v);

        //faccio il bottone grande come il cerchio
        b.setMinSize(c.getRadius() * 2, c.getRadius() * 2);
        b.setMaxSize(c.getRadius() * 2, c.getRadius() * 2);

        return new StackPane(c, b);
    }

    /**
     * creo il testo da mettere affianco al cerchio
     * @param s
     * @return
     */
    private Text crea_testo(String s){
        return new Text(s);
    }

    /**
     * creo l'HBox che contiene cerchio e testo
     * @param cerchio
     * @param testo
     * @return
     */
    private HBox crea_cerchio_testo(StackPane cerchio, Text testo){
        HBox hb = new HBox();
        hb.getChildren().addAll(cerchio, testo);
        return hb;
    }

    /**
     * imposta l'azione del bottone
     * se non sono abbonato al ventilatore e (posso permettermi la spesa aumento il costo per il mese prossimo, metto il colore rosso e attivo l'abbonamento altrimenti attivo un alert)
     * altrimenti imposto il colore a blu e disattivo l'abbonamento e tolgo i soldi dal costo per il mese prossimo
     * imposto i ventilatori che non posso permettermi a contorno grigio e quelli che posso a nero
     * aggiorno lo StatsPane con la spesa per il mese prossimo aggiornata
     * @param b
     * @param c
     * @param v
     */
    private void setAction(Button b, Circle c, Ventilatore v){
        b.setOnAction(actionEvent -> {
            if(!v.isAbbonato()){ //se non è abbonato
                int spesa = spesaNextMonth + v.getCosto(); //calcolo la spesa che ci sarebbe
                if(spesa <= mg.getSoldi()){ //se la spesa è minore del capitale
                    spesaNextMonth = spesa;
                    c.setFill(Color.RED); //imposto il colore rosso
                    v.setAbbonato(true); //imposto abbonamento attivo
                }else{
                    displayAlert();
                }
            }else{
                c.setFill(Color.BLUE);
                v.setAbbonato(false);
                spesaNextMonth -= v.getCosto();
            }
            impostaCostosi(); //imposto gli abbonamenti non affordable a contorno grigio
            mg.update_statsPane(0, spesaNextMonth, 0);
        });
    }

    /**
     * crea e displaya l'alert
     */
    private void displayAlert(){
        Alert win = new Alert(Alert.AlertType.INFORMATION);
        win.setTitle("ATTENZIONE!");
        win.setHeaderText("$$$");
        win.setContentText("non hai abbastanza soldi per abbonarti");
        win.showAndWait();
    }

    /**
     * imposta i ventilatori che non posso permettermi a contorno grigio
     * imposta i ventilatori che posso permettermi a contorno nero
     */
    public void impostaCostosi(){
        for(Node n : super.getChildren()){
            if(n instanceof HBox hb){ //scorro tra gli HBox
                for(Node hbNode : hb.getChildren()){
                    if(hbNode instanceof StackPane sp){ //scorro tra gli StackPane
                        Circle c = (Circle) sp.getChildren().get(0); // prendo il cerchio
                        Button b = (Button) sp.getChildren().get(1); // prendo il pulsante
                        Ventilatore v = (Ventilatore) b.getUserData();
                        //se non me lo posso permettere e se non è gia stato selezionato lo imposto a GRIGIO
                        if((spesaNextMonth + v.getCosto()) > mg.getSoldi() && !c.getFill().equals(Color.RED))
                            c.setStroke(Color.GREY);
                        else
                            c.setStroke(Color.BLACK);
                    }
                }
            }
        }
    }

    /**
     * reimposta tutti i cerchi ai colori di default
     * resetta la spesa del prossimo mese a 0
     */
    public void resetAll() {
        for(Node n : super.getChildren()){
            if(n instanceof HBox hb){
                for(Node hbChild : hb.getChildren()){
                    if(hbChild instanceof StackPane sp){
                        Circle c = (Circle) sp.getChildren().get(0);
                        Button b = (Button) sp.getChildren().get(1);
                        Ventilatore v = (Ventilatore) b.getUserData();
                        c.setStroke(Color.BLACK);
                        c.setFill(Color.BLUE);
                        v.setAbbonato(false);
                        spesaNextMonth = 0;
                    }
                }
            }
        }
    }
}