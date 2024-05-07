package View;

import View.Celle.Cella;
import View.Celle.Prato;
import javafx.scene.layout.GridPane;

public class GrigliaPane extends GridPane {
    private MainGUI mg;

    public GrigliaPane(MainGUI mg) {
        super();
        this.mg = mg;
        creaGriglia();
    }

    private void creaGriglia(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                super.add(new Prato(mg,this, new Coordinate(i, j)), j, i);
            }
        }
    }

    public void setGridCell(Cella c, int x, int y){
        super.add(c, y, x);
    }
}
