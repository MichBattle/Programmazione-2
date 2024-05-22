package Model;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Cella extends StackPane {
    public Cella(Color colore) {
        super();
        Rectangle rectangle = new Rectangle(40, 40);
        rectangle.setFill(colore);
        rectangle.setStroke(Color.DARKGRAY);
        super.getChildren().addAll(rectangle);
    }

    public abstract void setCellaAction();
}
