package view;

import controller.MainGUI;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TopPane extends StackPane {

    private SortButtons sortButtons;
    private DisplayButtons displayButtons;

    public TopPane(MainGUI mg) {
        super();
        sortButtons = new SortButtons(mg);
        displayButtons = new DisplayButtons(mg);

        Rectangle r = new Rectangle(500, 50);
        r.setFill(Color.LIGHTBLUE);
        r.setStroke(Color.BLACK);
        AnchorPane ap = new AnchorPane(sortButtons, displayButtons);

        AnchorPane.setTopAnchor(sortButtons, 10.0);
        AnchorPane.setLeftAnchor(sortButtons, 5.0);
        AnchorPane.setTopAnchor(displayButtons, 10.0);
        AnchorPane.setRightAnchor(displayButtons, 5.0);

        super.getChildren().addAll(r, ap);
    }

    public SortButtons getSortButtons() {
        return sortButtons;
    }
}
