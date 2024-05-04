package View;

import Model.Gioco;
import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class StatsPane extends HBox {
    private Gioco g;
    private MainGUI mg;

    private Text punteggio;
    private Text partiteVinte;

    public StatsPane(MainGUI mg) {
        super();
        this.mg = mg;
        g = mg.getGioco();
        punteggio = new Text("Punteggio: " + 0);
        partiteVinte = new Text("Partite vinte: " + 0);

        punteggio.setStroke(Color.BLUE);

        super.getChildren().addAll(punteggio, partiteVinte);
        super.setSpacing(5);
    }

    public void updatePunteggio(){
        punteggio.setText("Punteggio: " + g.getPunteggio());
        if(g.getPunteggio() > 10)
            punteggio.setStroke(Color.RED);
        else if(g.getPunteggio() == 10){
            punteggio.setStroke(Color.GREEN);
            showAlert();
            mg.resetAll();
        }else if(g.getPunteggio() < 10)
            punteggio.setStroke(Color.BLUE);
    }

    public void updatePartiteVinte(){
        partiteVinte.setText("Partite vinte: " + g.getPartiteVinte());
    }

    private void showAlert(){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Game Over");
        a.setContentText("Complimenti hai vinto");
        System.out.println("Complimenti hai vinto");
        a.setOnCloseRequest(event -> {
            g.setPartiteVinte(g.getPartiteVinte() + 1);
            g.setPunteggio(0);
        });
        a.showAndWait();
    }
}