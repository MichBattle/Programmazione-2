package View;

import Controller.MainGUI;
import View.Celle.CellaCentrale;
import View.Celle.Centrale.CellaBlu;
import View.Celle.Centrale.CellaGrigia;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ButtonPane extends HBox {
    private int num;
    private MainGUI mg;

    private Button number;
    private Button cambiaRiga;
    private Button cambiaColonna;

    public ButtonPane(MainGUI mg) {
        this.mg = mg;
        num = 1;

        number = new Button("1");
        cambiaRiga = new Button("Cambia Riga");
        cambiaColonna = new Button("Cambia Colonna");

        setNumberAction();
        setCambiaColonnaAction();
        setCambiaRigaAction();

        super.getChildren().addAll(number, cambiaRiga, cambiaColonna);
    }

    public void setButtonText(int n){
        num = n;
        number.setText(String.valueOf(n));
    }

    private void setNumberAction(){
        number.setOnAction(actionEvent -> {
            num ++;
            if(num == 5)
                num = 1;
            setButtonText(num);
        });
    }

    private void setCambiaColonnaAction(){
        cambiaColonna.setOnAction(actionEvent -> {
            GrigliaPane gp = mg.getGp();

            for (int i = 0; i < 4; i++) {
                CellaCentrale c = (CellaCentrale) gp.getElementAt(num-1, i);
                if(c instanceof CellaBlu){
                    int newValore = c.getValore()-1;
                    if(newValore < 0)
                        c.setValore(3);
                    else
                        c.setValore(newValore);
                }else if(c instanceof CellaGrigia){
                    int newValore = c.getValore()+1;
                    if(newValore > 3)
                        c.setValore(0);
                    else
                        c.setValore(newValore);
                }
                c.impostaNumero();
            }

            gp.setCelleLateraliNumbers();
            gp.displayAlert();
        });
    }

    private void setCambiaRigaAction(){
        cambiaRiga.setOnAction(actionEvent -> {
            GrigliaPane gp = mg.getGp();

            for (int i = 0; i < 4; i++) {
                CellaCentrale c = (CellaCentrale) gp.getElementAt(i,num-1);
                if(c instanceof CellaBlu){
                    int newValore = c.getValore()-1;
                    if(newValore < 0)
                        c.setValore(3);
                    else
                        c.setValore(newValore);
                }else if(c instanceof CellaGrigia){
                    int newValore = c.getValore()+1;
                    if(newValore > 3)
                        c.setValore(0);
                    else
                        c.setValore(newValore);
                }
                c.impostaNumero();
            }

            gp.setCelleLateraliNumbers();
            gp.displayAlert();
        });
    }

}
