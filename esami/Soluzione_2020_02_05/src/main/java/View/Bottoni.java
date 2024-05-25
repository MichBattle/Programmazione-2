package View;

import Controller.MainGUI;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class Bottoni extends HBox {
    private Button valore;
    private Button cambiaRiga;
    private Button cambiaColonna;

    public Bottoni(MainGUI mg) {
        super();
        valore = new Button("1");
        cambiaRiga = new Button("Cambia Riga");
        cambiaColonna = new Button("Cambia Colonna");

        setValoreAction();
        setCambiaRigaAction(mg);
        setCambiaColonnaAction(mg);

        super.getChildren().addAll(valore, cambiaRiga, cambiaColonna);
    }

    public void disabilitaBottoni(){
        for (Node node : getChildren()){
            if(node instanceof Button button)
                button.setDisable(true);
        }
    }

    private void setValoreAction(){
        valore.setOnAction(event -> {
            if(MainGUI.getVal()+1 == 5)
                setValoreText(1);
            else
                setValoreText(MainGUI.getVal()+1);
        });
    }

    public void setValoreText(int nuovoValore){
        MainGUI.setVal(nuovoValore);
        valore.setText(String.valueOf(MainGUI.getVal()));
    }

    private void setCambiaRigaAction(MainGUI mg){
        cambiaRiga.setOnAction(event -> mg.getCellePane().aggiornaRiga());
    }

    private void setCambiaColonnaAction(MainGUI mg){
        cambiaColonna.setOnAction(event -> mg.getCellePane().aggiornaColonna());
    }
}
