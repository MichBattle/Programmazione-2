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

    public TitoliPane(MainGUI mg, ArchivioTitoli archivio) {
        super();
        titoli = archivio.getArchivio();
        this.mg = mg;
        indexBasso = 0;
        indexAlto = 3;

        for(int i = 0; i < 3; i++){
            super.getChildren().add(creaStackPane(titoli.get(i)));
        }
    }

    public void scorri(boolean avanti){
        if(avanti)
            scorriAvanti();
        else
            scorriDietro();
    }

    /**
     * trova il colore del rettangolo in base alla classe
     * @param t
     * @return
     */
    private Color trovaColore(Titolo t){
        if(t instanceof Anime)
            return Color.SALMON;
        else if(t instanceof Film)
            return Color.CYAN;
        else if(t instanceof Serie)
            return Color.MAGENTA;
        return null;
    }

    /**
     * aggiorna gli indici per scorrere l'array in avanti e indietro
     * controlla che non siano < 0 maggionri di 6 in caso lancia un alert
     * @param avanti
     * @return
     */
    private boolean aggiornaIndici(boolean avanti){
        if(avanti){
            if(indexAlto < 7){
                indexBasso ++;
                indexAlto++;
                return true;
            }else{
                displayBoundAlert("non puoi andare avanti");
                return false;
            }
        }else{
            if(indexBasso > 0){
                indexAlto--;
                indexBasso--;
                return true;
            }else {
                displayBoundAlert("non puoi andare indietro");
                return false;
            }
        }
    }

    /**
     * crea lo stackPane che contiene rettangolo e bottone
     * @param t
     * @return
     */
    private StackPane creaStackPane(Titolo t){
        String ultimeDueCifre = t.getAnno().substring(2);

        Rectangle r = new Rectangle(130, 40);
        r.setFill(trovaColore(t));

        Text text = new Text(t.getNome() + " ('" + ultimeDueCifre + ")");

        StackPane sp = new StackPane(r, text);

        setAction(sp, t);
        return sp;
    }

    private void setAction(StackPane sp, Titolo titolo){
        sp.setOnMouseClicked(actionEvent -> {
            VBox v = new VBox();
            Text t = new Text(titolo.toString());
            v.getChildren().add(t);

            if(titolo instanceof Serie){
                HBox buttons = new HBox();
                for(int i = 0; i < ((Serie) titolo).getNumStagioni(); i++){
                    Button bu = new Button("S" + (i+1));
                    setSeasonButtonAction(bu);
                    buttons.getChildren().add(bu);
                }
                v.getChildren().add(buttons);
            }

            Button b = new Button("Acquista: " + titolo.getPrezzoScontato() + "€");
            b.setOnAction(actionEvent1 -> displayAcquistaAlert());

            v.getChildren().add(b);

            mg.setGridCenter(v);
        });
    }

    private void setSeasonButtonAction(Button b){
        b.setOnAction(actionEvent -> {

        });
    }

    private void displayAcquistaAlert(){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("ATTENZAIONE!");
        a.setHeaderText("ERRORE");
        a.setContentText("connessione non presente");
        a.showAndWait();
    }

    private void scorriAvanti(){
        if(aggiornaIndici(true)){
            super.getChildren().clear();
            for(int i = indexBasso; i < indexAlto; i++){
                super.getChildren().add(creaStackPane(titoli.get(i)));
            }
        }
    }

    private void scorriDietro(){
        if(aggiornaIndici(false)){
            super.getChildren().clear();
            for(int i = indexBasso; i < indexAlto; i++){
                super.getChildren().add(creaStackPane(titoli.get(i)));
            }
        }
    }

    private void displayBoundAlert(String s){
        Alert win = new Alert(Alert.AlertType.INFORMATION);
        win.setTitle("ATTENZIONE!");
        win.setHeaderText("ERRORE");
        win.setContentText(s);
        win.showAndWait();
    }
}