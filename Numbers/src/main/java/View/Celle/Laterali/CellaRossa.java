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
        if(super.getChildren().getLast() instanceof Text)
            super.getChildren().removeLast();
        int n = super.getGp().getRowValue(getVal());
        super.setValore(n);
        super.getChildren().add(new Text(String.valueOf(n)));
    }
}
