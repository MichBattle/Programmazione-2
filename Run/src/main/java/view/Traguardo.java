package view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Traguardo extends Rectangle {
    public final static int LARGHEZZA = 10;
    public final static int ALTEZZA = 200;

    public Traguardo() {
        super(LARGHEZZA, ALTEZZA);
        super.setFill(Color.LIGHTBLUE);
        super.setStroke(Color.BLACK);
    }
}
