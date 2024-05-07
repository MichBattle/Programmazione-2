package View.Celle;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Cella extends StackPane {
    private Color c;

    public Cella(Color c) {
        super();
        Rectangle r = new Rectangle(30, 30);
        r.setFill(c);
        r.setStroke(Color.GRAY);
        this.c = c;

        super.getChildren().add(r);
    }
}
