package View.Celle.Laterali;

import View.Celle.CellaLaterale;
import View.GrigliaPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class CellaRossa extends CellaLaterale {
    public CellaRossa(GrigliaPane gp, int column) {
        super(gp, column, Color.RED);
    }

    @Override
    public void impostaNumero() {
        int n = super.getGp().getRowValue(getVal());
        super.getChildren().add(new Text(String.valueOf(n)));
    }
}
