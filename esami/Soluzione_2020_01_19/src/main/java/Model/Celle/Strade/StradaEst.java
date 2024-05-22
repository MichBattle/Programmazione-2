package Model.Celle.Strade;

import Model.Celle.Strada;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;

public class StradaEst extends Strada {
    public StradaEst() {
        super();
    }

    @Override
    public void aggiungiDirezione() {
        BorderPane bp = new BorderPane();
        Circle circle = getCerchio();
        BorderPane.setAlignment(circle, Pos.CENTER);
        bp.setRight(circle);
        super.getChildren().add(bp);
    }
}
