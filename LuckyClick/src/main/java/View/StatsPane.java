package View;

import Model.Gioco;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class StatsPane extends VBox {
    private Gioco g;
    private HBox punteggio_label;
    private HBox tentativi_label;

    public StatsPane(Gioco g) {
        super();

        this.g = g;

        updateLabels();
    }

    private Text createPunteggio(){
        Text punteggioText = new Text("Punteggio = " + g.getPunteggioTotale());
        punteggioText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        return punteggioText;
    }

    private Text createTentativi(){
        Text tentativiText;

        if (g.getTentativi() == 0)
            tentativiText = new Text("GAME OVER!");
        else
            tentativiText = new Text("Tentativi: " + g.getTentativi());

        tentativiText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        return tentativiText;
    }

    public void updateLabels(){
        super.getChildren().clear();

        punteggio_label = new HBox(createPunteggio());
        tentativi_label = new HBox(createTentativi());

        super.getChildren().addAll(punteggio_label, tentativi_label);
    }
}