package View;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.Random;

public class Buttons {
    private Cella c;

    private Button clear;
    private Button random;
    private Button circle;
    private Button triangle;

    public Buttons(Cella c) {
        this.c = c;

        clear = new Button("C");
        random = new Button("R");
        circle = new Button("O");
        triangle = new Button("T");

        setClearAction();
        setRandomAction();
        setCircleAction();
        setTriangleAction();
    }

    public HBox creaBottoni(){
        Random r = new Random();
        if(r.nextBoolean())
            return creaDueBottoni();
        else
            return creaTreBottoni();
    }

    private HBox creaTreBottoni(){
        return new HBox(clear, circle, triangle);
    }

    private HBox creaDueBottoni(){
        return new HBox(clear, random);
    }

    private void setClearAction(){
        clear.setOnAction(actionEvent -> {
            c.setForma(getEmpty());
        });
    }

    private void setRandomAction(){
        random.setOnAction(actionEvent -> {
            Random rand = new Random();
            int r = rand.nextInt(2);

            Shape forma = switch (r) {
                case 0 -> getTriangle();
                case 1 -> getCircle();
                default -> null;
            };

            c.setForma(forma);
        });
    }

    private void setCircleAction(){
        circle.setOnAction(actionEvent -> {
            c.setForma(getCircle());
        });
    }

    private void setTriangleAction(){
        triangle.setOnAction(actionEvent -> {
            c.setForma(getTriangle());
        });
    }

    private Polygon getTriangle() {
        Polygon triangle = new Polygon();

        // Calcolo delle coordinate dei vertici del triangolo equilatero
        double sideLength = 100;
        double height = sideLength * Math.sqrt(3) / 2;
        double[] points = {
                0, height,
                sideLength / 2, 0,
                sideLength, height
        };

        ObservableList<Double> trianglePoints = triangle.getPoints();
        for (double point : points) {
            trianglePoints.add(point);
        }

        // Impostazione del colore di riempimento e del bordo del triangolo
        triangle.setFill(Color.YELLOW);
        triangle.setStroke(Color.BLACK);
        return triangle;
    }

    private Circle getCircle(){
        Circle c = new Circle(50);
        c.setFill(Color.YELLOW);
        c.setStroke(Color.BLACK);
        return c;
    }

    public Rectangle getEmpty(){
        Rectangle r = new Rectangle(100, 100);
        r.setFill(Color.GRAY);
        r.setStroke(Color.LIGHTBLUE);
        return r;
    }

    public Shape getCasualForm(){
        Random r = new Random();
        return switch (r.nextInt(3)) {
            case 0 -> getTriangle();
            case 1 -> getCircle();
            default -> getEmpty();
        };
    }
}
