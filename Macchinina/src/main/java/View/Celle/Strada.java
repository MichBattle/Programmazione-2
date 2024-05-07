package View.Celle;

import Main.Coordinate;
import Main.Direzioni;
import View.GrigliaPane;
import com.macchinina.MainGUI;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public abstract class Strada extends Cella{
    private Coordinate c;
    private MainGUI mg;
    private GrigliaPane gp;

    /**
     * imposta il colore a grigio
     * aggiunge il cerchio nella direzione impostata
     * crea una lista con i bottoni delle indicazioni e quelli per muovere e aggiungere l'auto
     * imposta l'azione della cella
     */
    public Strada(Direzioni dir, MainGUI mg, GrigliaPane gp, Coordinate c) {
        super(Color.GRAY);
        this.c = c;
        this.mg = mg;
        this.gp = gp;

        addDirectionCircle(dir);

        ArrayList<Button> bottoni = new ArrayList<>(mg.getIndicationButtons().getButtons());
        bottoni.add(mg.getSettingsButtons().getAggiungiAuto());
        bottoni.add(mg.getSettingsButtons().getMuoviAuto());

        setCellaClicked(gp, bottoni);
    }

    public MainGUI getMg() {
        return mg;
    }

    public GrigliaPane getGp() {
        return gp;
    }

    public Coordinate getC() {
        return c;
    }

    /**
     * aggiunge il cerchio allo stackpane nella direzione impostata
     */
    private void addDirectionCircle(Direzioni dir){
        BorderPane bp = new BorderPane();
        Circle circle = new Circle();
        int radius = 5;
        bp.setStyle("-fx-background-color: #666666;");
        circle.setRadius (radius);
        circle.setStroke (Color.YELLOW);
        BorderPane.setAlignment(circle, Pos.CENTER);

        switch (dir){
            case NORD -> bp.setTop(circle);
            case SUD -> bp.setBottom(circle);
            case EST -> bp.setRight(circle);
            case OVEST -> bp.setLeft(circle);
        }

        super.getChildren().add(bp);
    }

    /**
     * se il bottone cliccato è prato imposta la cella a prato
     * se il bottone cliccato è add aggiunge l'auto, disabilita il bottone muovi e imposta le coordinate della macchina
     */
    protected void setCellaClicked(GrigliaPane gp, ArrayList<Button> bottoni){
        this.setOnMouseClicked(event -> {
            Button b = super.getBottoneDisabilitato(bottoni);

            if(b != null){
                if(b.getText().equals("Prato")){
                    gp.setGridCell(new Prato(mg, gp, c), c.getX(), c.getY());
                }else if(b.getText().equals("Add")){
                    addAuto();
                    bottoni.getLast().setDisable(false);
                    mg.setCoordinateAuto(c);
                }
            }
        });
    }

    /**
     * aggiunge l'auto
     */
    public abstract void addAuto();

    /**
     * muove l'auto
     */
    public abstract void muoviAuto();

    /**
     * rimuove l'auto dallo stackpane
     */
    public void removeAuto(){
        super.getChildren().removeLast();
    }

    /**
     * mostra l'alert in caso di CRASH
     * resetta tutto
     */
    protected void displayAlert(){
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("CRASH");
        a.setContentText("Ti sei schiantato!");
        a.setOnCloseRequest(event -> mg.getSettingsButtons().resetAction());
        a.showAndWait();
    }
}
