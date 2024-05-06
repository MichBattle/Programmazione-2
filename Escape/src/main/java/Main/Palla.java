package Main;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public abstract class Palla extends Circle {

    public Palla(Color c) {
        super(20);
        super.setFill(c);
    }
}
