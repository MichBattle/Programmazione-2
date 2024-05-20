package Model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class EmptyFigure extends Rectangle {
    public EmptyFigure(double lato) {
        super(lato, lato);
        super.setFill(Color.LIGHTGRAY);
        super.setStroke(Color.SEAGREEN);
    }
}
