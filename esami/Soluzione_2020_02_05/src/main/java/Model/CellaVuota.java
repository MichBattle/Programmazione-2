package Model;

import javafx.scene.paint.Color;

public class CellaVuota extends Cella{
    public CellaVuota() {
        super(Color.TRANSPARENT);
        getChildren().removeLast();
    }

    @Override
    public void impostaContenuto() {
    }
}
