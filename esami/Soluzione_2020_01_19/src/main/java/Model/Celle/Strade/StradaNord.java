package Model.Celle.Strade;

import Model.Celle.Strada;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;

public class StradaNord extends Strada {
    public StradaNord() {
        super();
    }

    @Override
    public void aggiungiDirezione() {
        BorderPane bp = new BorderPane();
        Circle circle = getCerchio();
        BorderPane.setAlignment(circle, Pos.CENTER);
        bp.setStyle("-fx-background-color: #666666;");
        bp.setTop(circle);
        super.getChildren().add(bp);
    }
}
