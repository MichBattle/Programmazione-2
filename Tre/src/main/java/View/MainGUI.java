package View;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class MainGUI extends VBox {
    private GridPane gridPane;
    private BottomButtons bottomButtons;
    private ArrayList<Cella> cells;

    public MainGUI() {
        gridPane = new GridPane();
        bottomButtons = new BottomButtons(this);
        cells = new ArrayList<>();

        creaCelle();
        super.getChildren().addAll(gridPane, bottomButtons);
        super.setSpacing(10);
    }

    public ArrayList<Cella> getCells() {
        return cells;
    }

    private void creaCelle(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Cella c = new Cella();
                gridPane.add(c, j, i);
                gridPane.setVgap(10);
                gridPane.setHgap(10);
                cells.add(c);
            }
        }
    }

    public Coordinate getCoords() {
        int counterTriangolo = 0;
        int counterCerchio = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(((Cella)getElementAt(i, j)).getForma() instanceof Polygon)
                    counterTriangolo++;
                else if(((Cella)getElementAt(i, j)).getForma() instanceof Circle){
                    counterCerchio++;
                }
            }
            if(counterTriangolo == 3 || counterCerchio ==3)
                return new Coordinate(i+1, false);
            counterTriangolo = 0;
            counterCerchio = 0;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(((Cella)getElementAt(j, i)).getForma() instanceof Polygon)
                    counterTriangolo++;
                else if(((Cella)getElementAt(j, i)).getForma() instanceof Circle)
                    counterCerchio++;
            }
            if(counterTriangolo == 3 || counterCerchio ==3)
                return new Coordinate(i+1, true);
            counterTriangolo = 0;
            counterCerchio = 0;
        }

        return null;
    }

    public Node getElementAt(int x, int y) {
        for (Node node : gridPane.getChildren()) {
            Integer rowIndex = GridPane.getRowIndex(node);
            Integer colIndex = GridPane.getColumnIndex(node);

            if (rowIndex != null && colIndex != null && rowIndex == y && colIndex == x) {
                return node;
            }
        }
        return null;
    }
}
