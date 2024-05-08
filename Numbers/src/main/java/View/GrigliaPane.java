package View;

import Controller.MainGUI;
import View.Celle.CellaEmpty;
import View.Celle.CellaLaterale;
import View.Celle.Centrale.CellaBlu;
import View.Celle.Centrale.CellaGrigia;
import View.Celle.Laterali.CellaRossa;
import View.Celle.Laterali.CellaVerde;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Random;

public class GrigliaPane extends GridPane {
    public GrigliaPane(MainGUI mg) {
        super();
        creaGriglia(mg);
    }

    private void creaGriglia(MainGUI mg){
        Cella c;
        ArrayList<CellaLaterale> a = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(i == 4 && j != 4) {
                    c = new CellaRossa(this, j);
                    a.add((CellaLaterale) c);
                } else if(j == 4 && i != 4){
                    c = new CellaVerde(this, i);
                    a.add((CellaLaterale) c);
                } else if(j == 4)
                    c = new CellaEmpty();
                else {
                    Random r = new Random();
                    if(r.nextBoolean())
                        c = new CellaGrigia(mg);
                    else
                        c = new CellaBlu(mg);
                }
                super.add(c, j, i);
            }
        }

        for(CellaLaterale cella : a){
            cella.impostaNumero();
        }
    }

    public int getRowValue(int row){
        int val = 0;
        for (int i = 0; i < 4; i++) {
            val += ((Cella)getElementAt(row, i)).getValore();
        }
        return val;
    }

    public int getColumnValue(int column){
        int val = 0;
        for (int i = 0; i < 4; i++) {
            val += ((Cella)getElementAt(i, column)).getValore();
        }
        return val;
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
}
