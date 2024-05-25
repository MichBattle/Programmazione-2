package View;

import Controller.MainGUI;
import Model.*;
import Model.CelleCentrali.CellaBlu;
import Model.CelleCentrali.CellaGrigia;
import Model.CelleLaterali.CellaRossa;
import Model.CelleLaterali.CellaVerde;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Random;

public class CellePane extends GridPane {
    private MainGUI mg;

    public CellePane(MainGUI mg) {
        super();
        this.mg = mg;
        creaGriglia();
    }

    private void creaGriglia(){
        ArrayList<CellaLaterale> celleLaterali = new ArrayList<>(8);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Cella cella;
                if(i == 4 && j == 4){
                    cella = new CellaVuota();
                } else if(j < 4 && i < 4){
                    Random r = new Random();
                    if(r.nextBoolean())
                        cella = new CellaGrigia();
                    else
                        cella = new CellaBlu();
                }else if(j == 4){
                    cella = new CellaVerde(this, i);
                    celleLaterali.add((CellaLaterale) cella);
                }else {
                    cella = new CellaRossa(this, j);
                    celleLaterali.add((CellaLaterale) cella);
                }
                super.add(cella, j ,i);
            }
        }

        impostaContenutoLaterali(celleLaterali);
    }

    private Node getElementAt(int x, int y) {
        for (Node node : super.getChildren()) {
            Integer rowIndex = GridPane.getRowIndex(node);
            Integer colIndex = GridPane.getColumnIndex(node);

            if (rowIndex != null && colIndex != null && rowIndex == y && colIndex == x) {
                return node;
            }
        }
        return null;
    }
    
    public int getValoreRiga(int row){
        int valoreRiga = 0;
        for (int i = 0; i < 4; i++)
            valoreRiga += ((Cella)getElementAt(i, row)).getContenuto();
        return valoreRiga;
    }

    public int getValoreColonna(int col){
        int valoreColonna = 0;
        for (int i = 0; i < 4; i++)
            valoreColonna += ((Cella)getElementAt(col, i)).getContenuto();
        return valoreColonna;
    }

    //non posso farlo nel costruttore come per le centrali perche mi serve l'istanza di cellePane che non si è ancora creata e mi da nullptrexc
    private void impostaContenutoLaterali(ArrayList<CellaLaterale> celleLaterali){
        for(CellaLaterale c : celleLaterali)
            c.impostaContenuto();
    }

    public void aggiornaColonna(){
        for (int i = 0; i < 4; i++) {
            ((CellaCentrale)getElementAt(MainGUI.getVal()-1, i)).aggiornaValore();
        }
        aggiornaLaterali();
    }

    public void aggiornaRiga(){
        for (int i = 0; i < 4; i++) {
            ((CellaCentrale)getElementAt(i, MainGUI.getVal()-1)).aggiornaValore();
        }
        aggiornaLaterali();
    }
    
    private void aggiornaLaterali(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if((i == 4 || j == 4) && !(getElementAt(i, j) instanceof CellaVuota)){
                    ((CellaLaterale)getElementAt(i, j)).impostaContenuto();
                }
            }
        }

        if(checkWin() && checkLoose()){
            AlertDisplayer.displayAlertDraw();
            mg.getBottoni().disabilitaBottoni();
        }else if(checkWin()){
            AlertDisplayer.displayAlertWin();
            mg.getBottoni().disabilitaBottoni();
        }else if(checkLoose()){
            AlertDisplayer.displayAlertLoose();
            mg.getBottoni().disabilitaBottoni();
        }
    }

    private boolean checkWin(){
        for (int i = 0; i < 4; i++) {
            if(((CellaVerde)getElementAt(4, i)).getContenuto() == 10)
                return true;
        }
        return false;
    }

    private boolean checkLoose(){
        for (int i = 0; i < 4; i++) {
            if(((CellaRossa)getElementAt(i, 4)).getContenuto() == 10)
                return true;
        }
        return false;
    }
}
