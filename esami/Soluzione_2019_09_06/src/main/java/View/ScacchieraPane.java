package View;

import View.Caselle.CasellaDueBottoni;
import View.Caselle.CasellaTreBottoni;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import java.util.Random;

public class ScacchieraPane extends GridPane {
    public ScacchieraPane() {
        super();
        creaGriglia();
        super.setHgap(10);
        super.setVgap(10);
    }

    public void creaGriglia(){
        super.getChildren().clear();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Random r = new Random();
                Casella c;
                if(r.nextBoolean())
                    c = new CasellaDueBottoni();
                else
                    c = new CasellaTreBottoni();
                super.add(c, j, i);
            }
        }
    }

    public Node getElementAt(int x, int y) {
        for (Node node : super.getChildren()) {
            Integer columnIndex = GridPane.getColumnIndex(node);
            Integer rowIndex = GridPane.getRowIndex(node);

            columnIndex = (columnIndex == null) ? 0 : columnIndex;
            rowIndex = (rowIndex == null) ? 0 : rowIndex;

            if (columnIndex == x && rowIndex == y) {
                return node;
            }
        }
        return null;
    }
}
