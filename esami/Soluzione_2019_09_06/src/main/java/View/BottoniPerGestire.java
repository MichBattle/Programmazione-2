package View;

import javafx.scene.layout.HBox;

public class BottoniPerGestire extends HBox {
    public BottoniPerGestire(Bottoni b) {
        super();
        super.getChildren().addAll(b.getClearAll(), b.getCheck());
    }
}
