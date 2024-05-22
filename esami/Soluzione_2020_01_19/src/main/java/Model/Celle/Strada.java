package Model.Celle;

import Model.Cella;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public abstract class Strada extends Cella {
    public Strada() {
        super(Color.GRAY);
        aggiungiDirezione();
    }

    @Override
    public void setCellaAction() {

    }

    public Circle getCerchio(){
        Circle circle = new Circle(5);
        circle.setFill(Color.BLACK);
        circle.setStroke(Color.YELLOW) ;
        return circle;
    }

    public abstract void aggiungiDirezione();
}
