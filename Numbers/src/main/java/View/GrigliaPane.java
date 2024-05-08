package View;

import View.Celle.CellaEmpty;
import View.Celle.CellaLaterale;
import View.Celle.Centrale.CellaBlu;
import View.Celle.Centrale.CellaGrigia;
import View.Celle.Laterali.CellaRossa;
import View.Celle.Laterali.CellaVerde;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Random;

public class GrigliaPane extends GridPane {
    private ArrayList<CellaLaterale> celleLaterali;

    public GrigliaPane() {
        super();
        celleLaterali = new ArrayList<>();
        creaGriglia();
        displayAlert();
    }

    private void creaGriglia(){
        Cella c;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(i == 4 && j != 4) {
                    c = new CellaRossa(this, j);
                    celleLaterali.add((CellaLaterale) c);
                } else if(j == 4 && i != 4){
                    c = new CellaVerde(this, i);
                    celleLaterali.add((CellaLaterale) c);
                } else if(j == 4)
                    c = new CellaEmpty();
                else {
                    Random r = new Random();
                    if(r.nextBoolean())
                        c = new CellaGrigia();
                    else
                        c = new CellaBlu();
                }
                super.add(c, j, i);
            }
        }

        setCelleLateraliNumbers();
    }

    public void setCelleLateraliNumbers(){
        for(CellaLaterale cella : celleLaterali){
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

    public boolean checkDraw(){
        return checkWin() && checkLoose();
    }

    public boolean checkWin(){
        for (int i = 0; i < 3; i++) {
            if(((Cella)getElementAt(4, i)).getValore() == 10)
                return true;
        }
        return false;
    }

    public boolean checkLoose(){
        for (int i = 0; i < 3; i++) {
            if(((Cella)getElementAt(i, 4)).getValore() == 10)
                return true;
        }
        return false;
    }

    public void displayAlert(){
        if(checkDraw())
            creaAlert("PAREGGIO");
        else if(checkWin())
            creaAlert("VITTORIA");
        else if(checkLoose())
            creaAlert("SCONFITTA");
    }

    private void creaAlert(String s){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("ATTENZIONE");
        a.setContentText(s);
        a.setOnCloseRequest(event -> Platform.exit());
        a.show();
    }
}
