package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class StatsPane extends StackPane {
    private int punteggio;
    private boolean loose;

    private Text punteggioText;
    private Text gameOverText;

    public StatsPane() {
        super();
        punteggio = 0;
        loose = false;

        punteggioText = new Text("Points: " + punteggio);
        gameOverText = new Text("");

        punteggioText.setFont(Font.font("Arial", 20));

        VBox vbox = new VBox(punteggioText, gameOverText);
        vbox.setAlignment(Pos.CENTER);

        super.getChildren().addAll(vbox);
    }

    public int getPunteggio() {
        return punteggio;
    }

    public boolean isLoose() {
        return loose;
    }

    public void aumentaPunteggio() {
        punteggio += 100;
    }

    public void abbassaPunteggio() {
        punteggio -= 100;
    }

    public void setLoose(boolean loose) {
        this.loose = loose;
    }

    public void addGameOverText(){
        gameOverText.setText("GAME OVER");
    }
}
