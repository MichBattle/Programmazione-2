package Model;

import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Triangolo extends Polygon {
    public Triangolo(double sideLength) {
        super();
        double height = sideLength * Math.sqrt(3) / 2;
        double[] points = {
                0, height,
                sideLength / 2, 0,
                sideLength, height
        };

        ObservableList<Double> trianglePoints = super.getPoints();
        for (double point : points) {
            trianglePoints.add(point);
        }

        super.setFill(Color.YELLOW);
        super.setStroke(Color.BLACK);
    }
}
