package Model.Figure;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Cerchio extends Circle {
    public Cerchio(double raggio) {
        super(raggio);
        setFill(Color.YELLOW);
        setStroke(Color.RED);
    }
}
