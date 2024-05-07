package View.Celle;

import View.Celle.Strade.StradaEst;
import View.Celle.Strade.StradaNord;
import View.Celle.Strade.StradaOvest;
import View.Celle.Strade.StradaSud;
import Main.Coordinate;
import View.GrigliaPane;
import com.macchinina.MainGUI;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Prato extends Cella{
    private Coordinate c;
    private MainGUI mg;

    /**
     * imposta il colore dello stackpane a verde
     * crea una lista con i bottoni di indicazioni e il bottone aggiungi auto
     * imposta l'azione della cella
     */
    public Prato(MainGUI mg, GrigliaPane gp, Coordinate c) {
        super(Color.GREEN);
        this.c = c;
        this.mg = mg;

        ArrayList<Button> bottoni = new ArrayList<>(mg.getIndicationButtons().getButtons());
        bottoni.add(mg.getSettingsButtons().getAggiungiAuto());

        setCellaClicked(gp, bottoni);
    }

    /**
     * imposta l'azione della cella
     * se viene cliccato nord fa replace del nodo con una strada nord
     * fa la stessa cosa per tutti i bottoni
     * se viene cliccato add mostra l'alert
     */
    protected void setCellaClicked(GrigliaPane gp, ArrayList<Button> bottoni) {
        this.setOnMouseClicked(event -> {
            Button b = super.getBottoneDisabilitato(bottoni);

            if(b != null){
                if(b.getText().equals("Nord")){
                    gp.replaceNode(new StradaNord(mg, gp, c), c.getX(), c.getY());
                }else if(b.getText().equals("Sud")) {
                    gp.replaceNode(new StradaSud(mg, gp, c), c.getX(), c.getY());
                }else if(b.getText().equals("Est")) {
                    gp.replaceNode(new StradaEst(mg, gp, c), c.getX(), c.getY());
                }else if(b.getText().equals("Ovest")) {
                    gp.replaceNode(new StradaOvest(mg, gp, c), c.getX(), c.getY());
                }else if(b.getText().equals("Add")){
                    displayAlert();
                }
            }
        });
    }

    /**
     * crea l'alert per dire che la macchina non può essere aggiunta nel prato
     */
    protected void displayAlert(){
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("ERRORE");
        a.setContentText("La macchina non può essere aggiunta su un prato!");
        a.showAndWait();
    }
}
