package View;

import Model.AlertDisplayer;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class StatsPane extends HBox {
    private int punteggio;
    private int partiteVinte;

    private Text punteggioText;
    private Text numeroText;
    private static Text partiteVinteText;

    public StatsPane() {
        super();
        punteggio = 0;
        partiteVinte = 0;

        punteggioText = new Text("Punteggio");
        partiteVinteText = new Text("Partite vinte 0");
        numeroText = new Text();

        aggiornaPunteggioText(0);

        super.getChildren().addAll(punteggioText, numeroText, partiteVinteText);
        super.setSpacing(5);
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void aggiornaPunteggioText(int nuovoPunteggio){
        punteggio = nuovoPunteggio;
        numeroText.setText(String.valueOf(punteggio));

        if(punteggio < 10)
            numeroText.setStroke(Color.BLUE);
        else if(punteggio > 10)
            numeroText.setStroke(Color.RED);
        else {
            numeroText.setStroke(Color.GREEN);
            aggiornaPartiteVinteText();
            AlertDisplayer.display_WIN_Alert();
            //resetto tutto
        }
    }

    public void aggiornaPartiteVinteText(){
        partiteVinte++;
        partiteVinteText.setText("Partite vinte " + partiteVinte);
    }
}
