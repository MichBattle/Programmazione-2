package View;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ButtonPane extends HBox {
    private int num;

    private Button number;
    private Button cambiaRiga;
    private Button cambiaColonna;

    public ButtonPane() {
        num = 1;

        number = new Button("1");
        cambiaRiga = new Button("Cambia Riga");
        cambiaColonna = new Button("Cambia Colonna");

        setNumberAction();

        super.getChildren().addAll(number, cambiaRiga, cambiaColonna);
    }

    private void setNumberAction(){
        number.setOnAction(actionEvent -> {
            num ++;
            if(num == 5)
                num = 1;
            setButtonText(num);
        });
    }

    public void setButtonText(int n){
        num = n;
        number.setText(String.valueOf(n));
    }
}//https://github.com/unitn-drive/programmazione-2/blob/master/Esami/INF/Pratica/Testi/Esame%20Pratico%202020-02-05.pdf
