package View;

import Controller.MainGUI;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StatsStage {
    private int punteggio;
    private Text punteggioText;
    private Text gameOverText;
    private VBox vBox;

    public StatsStage() {
        punteggio = 0;
        punteggioText = new Text("Points: " + punteggio);
        gameOverText = new Text("GAME OVER");

        vBox = new VBox(punteggioText);
        AnchorPane ap = new AnchorPane(vBox);

        AnchorPane.setTopAnchor(vBox, 20.0);
        AnchorPane.setLeftAnchor(vBox, 20.0);

        Scene scene = new Scene(ap, 200, 100);
        Stage s = new Stage();
        s.setScene(scene);
        s.show();
    }

    public void aggiornaPunteggio(){
        punteggio += 100;
        punteggioText.setText("Points: " + punteggio);
    }

    public void aggiornaWin(){
        if(MainGUI.isLoose())
            vBox.getChildren().add(gameOverText);
    }
}
