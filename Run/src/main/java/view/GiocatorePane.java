package view;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

public class GiocatorePane extends Group {

    public GiocatorePane() {
        super();
        Polygon t = triangolo();
        Circle c = new Circle(5.0);
        super.getChildren().addAll(t, c);
    }

    /**
     * crea un triangolo verde
     * @return
     */
    private Polygon triangolo(){
        Polygon triangolo = new Polygon();
        triangolo.getPoints().addAll(0.0, 0.0,
                10.0, 30.0,
                -10.0, 30.0);
        triangolo.setFill(Color.GREEN);
        triangolo.setStroke(Color.BLACK);
        return triangolo;
    }
}
