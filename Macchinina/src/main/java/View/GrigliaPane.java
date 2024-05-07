package View;

import Main.Coordinate;
import View.Celle.Cella;
import View.Celle.Prato;
import com.macchinina.MainGUI;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class GrigliaPane extends GridPane {
    private MainGUI mg;

    public GrigliaPane(MainGUI mg) {
        super();
        this.mg = mg;
        creaGriglia();
    }

    public void creaGriglia(){
        super.getChildren().clear();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                super.add(new Prato(mg,this, new Coordinate(i, j)), j, i);
            }
        }
    }

    public void setGridCell(Cella c, int x, int y){
        super.add(c, y, x);
    }

    public Node getElementAt(int x, int y) {
        for (Node node : super.getChildren()) {
            Integer rowIndex = GridPane.getRowIndex(node);
            Integer colIndex = GridPane.getColumnIndex(node);

            if (rowIndex != null && colIndex != null && rowIndex == y && colIndex == x) {
                return node;
            }
        }
        return null;
    }

    public void replaceNode(Node newNode, int row, int col) {
        for (Node node : super.getChildren()) {
            if(GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                super.getChildren().remove(node);
                break;
            }
        }

        super.add(newNode, col, row);
    }

}
