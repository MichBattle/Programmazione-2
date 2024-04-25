package view;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class StatsPane extends HBox {
    private Text punteggioLabel;
    private Text viteLabel;
    private int punteggio;
    private int vite;

    public StatsPane() {
        super();
        this.punteggio = 0;
        this.vite = 3;

        punteggioLabel = new Text("punteggio: " + punteggio);
        viteLabel = new Text("vite: " + vite);

        super.getChildren().addAll(punteggioLabel, viteLabel);
    }

    /**
     * aggiorna la label del punteggio
     * @param toAdd
     */
    public void setPunteggioLabel(int toAdd) {
        punteggio += toAdd;
        punteggioLabel.setText("punteggio: " + punteggio);
    }

    /**
     * aggionra la lable delle vite
     * @param rem
     */
    public void setViteLabel(boolean rem) {
        if (rem) {
            vite--;
        }
        viteLabel.setText("vite: " + vite);
    }

    public int getPunteggio() {
        return punteggio;
    }

    public int getVite() {
        return vite;
    }
}
