package Model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public abstract class Pallina extends Circle {
    private Color colore;

    public Pallina(Color colore) {
        super(20);
        super.setFill(colore);
    }
}
