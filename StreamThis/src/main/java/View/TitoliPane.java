package View;

import Controller.ArchivioTitoli;
import Controller.Titoli.Anime;
import Controller.Titoli.Film;
import Controller.Titoli.Serie;
import Controller.Titolo;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class TitoliPane extends HBox {
    private ArrayList<Titolo> titoli;
    private int indexBasso;
    private int indexAlto;
    private MainGUI mg;
    private boolean isScontato;
    private double keepPrice;

    public TitoliPane(MainGUI mg, ArchivioTitoli archivio) {
        super();
        titoli = archivio.getArchivio();
        this.mg = mg;

        resetAll();
    }

    //ARRAYLIST INDEX METHODS-------------------------------------------------------------------------------------------

    /*scorro in avanti o indietro l'arraylist*/
    public void scorri(boolean avanti){
        if(avanti)
            scorriAvanti();
        else
            scorriDietro();
    }

    /*scorro in avanti l'indice dell'arrayList*/
    private void scorriAvanti(){
        if(aggiornaIndici(true)){
            super.getChildren().clear();
            for(int i = indexBasso; i < indexAlto; i++){
                super.getChildren().add(creaStackPane(titoli.get(i)));
            }
        }
    }

    /*scorro in dietro l'indice dell'arrayList*/
    private void scorriDietro(){
        if(aggiornaIndici(false)){
            super.getChildren().clear();
            for(int i = indexBasso; i < indexAlto; i++){
                super.getChildren().add(creaStackPane(titoli.get(i)));
            }
        }
    }

    //CREATE STACKPANE METHODS------------------------------------------------------------------------------------------

    /*trovo il colore in base al tipo di ventilatore*/
    private Color trovaColore(Titolo t){
        if(t instanceof Anime)
            return Color.SALMON;
        else if(t instanceof Film)
            return Color.CYAN;
        else if(t instanceof Serie)
            return Color.MAGENTA;
        return null;
    }

    /*aggiorno l'indice per scorrere l'arrayList*/
    private boolean aggiornaIndici(boolean avanti){
        if(avanti){
            if(indexAlto < 7){
                indexBasso ++;
                indexAlto++;
                return true;
            }else{
                displayAlert("non puoi andare avanti");
                return false;
            }
        }else{
            if(indexBasso > 0){
                indexAlto--;
                indexBasso--;
                return true;
            }else {
                displayAlert("non puoi andare indietro");
                return false;
            }
        }
    }

    /*creo stackpane*/
    private StackPane creaStackPane(Titolo t){
        String ultimeDueCifre = t.getAnno().substring(2);

        Rectangle r = new Rectangle(130, 40);
        r.setFill(trovaColore(t));

        Text text = new Text(t.getNome() + " ('" + ultimeDueCifre + ")");

        StackPane sp = new StackPane(r, text);

        setAction(sp, t);
        return sp;
    }

    //BUTTON ACTIONS METHODS--------------------------------------------------------------------------------------------

    /*imposto l'azione dello StackPane (del rettangolo che contiene il film)*/
    private void setAction(StackPane sp, Titolo titolo){
        sp.setOnMouseClicked(actionEvent -> {
            VBox v = new VBox();
            Button b = new Button("Acquista: " + titolo.getPrezzoScontato() + "€");
            Text t = new Text(titolo.toString());
            v.getChildren().add(t);

            if(titolo instanceof Serie){
                HBox buttons = new HBox();
                int numeroStagioni = ((Serie) titolo).getNumStagioni();
                for(int i = 0; i < numeroStagioni; i++){
                    Button bu = new Button("S" + (i+1));
                    setSeasonButtonAction(bu, (Serie)titolo, i+1, b, buttons);
                    buttons.getChildren().add(bu);
                }
                v.getChildren().add(buttons);
            }

            b.setOnAction(actionEvent1 -> displayAlert("connessione non presente"));
            v.getChildren().add(b);

            mg.setGridCenter(v);
        });
    }

    /*imposto l'azione dei bottoni per selezionare le stagioni della serie*/
    private void setSeasonButtonAction(Button b, Serie s, int numeroStagioni, Button bottoneAcquista, HBox hb){
        b.setOnAction(actionEvent -> {
            if(!isScontato){
                keepPrice = s.getPrezzoScontato();
                s.calcolaScontoSerie(numeroStagioni);
                isScontato = true;
                disattivaBottoniPrecedenti(numeroStagioni, hb);
            }else{
                s.setPrezzoScontato(keepPrice);
                isScontato = false;
                attivaBottoniPrecedenti(numeroStagioni, hb);
            }
            bottoneAcquista.setText("Acquista: " + s.getPrezzoScontato() + "€");
        });
    }

    //OTHER METHODS-----------------------------------------------------------------------------------------------------

    /*mostro l'alert quando arrivo in fondo o sono all'inizio con le freccette*/
    private void displayAlert(String s){
        Alert win = new Alert(Alert.AlertType.INFORMATION);
        win.setTitle("ATTENZIONE!");
        win.setHeaderText("ERRORE");
        win.setContentText(s);
        win.showAndWait();
    }

    public void resetAll(){
        indexBasso = 0;
        indexAlto = 3;
        isScontato = false;

        super.getChildren().clear();
        mg.setGridCenter(null);
        for(int i = 0; i < 3; i++){
            super.getChildren().add(creaStackPane(titoli.get(i)));
        }
    }

    private void disattivaBottoniPrecedenti(int numeroStagioni, HBox hb){
        for(int i = 0; i < numeroStagioni - 1; i++){
            if(hb.getChildren().get(i) instanceof Button b)
                b.setDisable(true);
        }
    }

    private void attivaBottoniPrecedenti(int numeroStagioni, HBox hb){
        for(int i = 0; i < numeroStagioni - 1; i++){
            if(hb.getChildren().get(i) instanceof Button b)
                b.setDisable(false);
        }
    }
}