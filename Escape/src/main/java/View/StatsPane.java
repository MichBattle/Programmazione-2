package View;

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

    /**
     * serve per il controllo vittoria
     */
    public boolean isLoose() {
        return loose;
    }

    /**
     * aumenta il punteggio di 100
     */
    public void aumentaPunteggio() {
        punteggio += 100;
        punteggioText.setText("Points: " + punteggio);
    }

    public void setLoose(boolean loose) {
        this.loose = loose;
    }

    /**
     * aggiunge al VBox il testo GAME OVER
     */
    public void addGameOverText(){
        gameOverText.setText("GAME OVER");
    }
}
