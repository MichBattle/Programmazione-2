package View.Celle.Laterali;

import View.Celle.CellaLaterale;
import View.GrigliaPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class CellaVerde extends CellaLaterale {
    public CellaVerde(GrigliaPane gp, int row) {
        super(gp, row, Color.GREEN);
    }

    @Override
    public void impostaNumero() {
        if(super.getChildren().getLast() instanceof Text)
            super.getChildren().removeLast();
        int n = super.getGp().getColumnValue(getVal());
        super.setValore(n);
        super.getChildren().add(new Text(String.valueOf(n)));
    }
}
