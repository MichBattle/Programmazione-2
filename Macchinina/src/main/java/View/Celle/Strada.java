package View.Celle;

import View.Celle.Strade.StradaEst;
import View.Celle.Strade.StradaNord;
import View.Celle.Strade.StradaOvest;
import View.Celle.Strade.StradaSud;
import View.Coordinate;
import View.Direzioni;
import View.GrigliaPane;
import View.MainGUI;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public abstract class Strada extends Cella{
    private Coordinate c;
    private MainGUI mg;

    public Strada(Direzioni dir, MainGUI mg, GrigliaPane gp, Coordinate c) {
        super(Color.GRAY);
        this.c = c;
        this.mg = mg;
        addDirectionCircle(dir);
        setCellaClicked(gp, mg.getIndicationButtons().getButtons());
    }

    private void addDirectionCircle(Direzioni dir){
        BorderPane bp = new BorderPane();
        Circle circle = new Circle();
        int radius = 5;
        bp.setStyle("-fx-background-color: #666666;");
        circle.setRadius (radius);
        circle.setStroke (Color.YELLOW);
        BorderPane.setAlignment(circle, Pos.CENTER);

        switch (dir){
            case NORD -> bp.setTop(circle);
            case SUD -> bp.setBottom(circle);
            case EST -> bp.setRight(circle);
            case OVEST -> bp.setLeft(circle);
        }

        super.getChildren().add(bp);
    }


    protected void setCellaClicked(GrigliaPane gp, ArrayList<Button> bottoni){
        this.setOnMouseClicked(event -> {
            Button b = getBottoneDisabilitato(bottoni);

            if(b != null){
                if(b.getText().equals("Prato")){
                    gp.setGridCell(new Prato(mg, gp, c), c.getX(), c.getY());
                }
                b.setDisable(true);
            }
        });
    }

    private Button getBottoneDisabilitato(ArrayList<Button> bottoni){
        for(Button b : bottoni){
            if(b.isDisabled())
                return b;
        }
        return null;
    }
}
