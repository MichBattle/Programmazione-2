package view;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import model.Concessionario;

public class ButtonPane extends HBox {
    private MainGUI mg;
    private Concessionario c;

    private Button changeMod;
    private Button back;
    private Button forward;

    private int index;


    public ButtonPane(MainGUI mg, Concessionario c) {
        super();

        this.index = 0;

        this.mg = mg;
        this.c = c;

        changeMod = new Button("id");
        back = new Button("<");
        forward = new Button(">");

        backAction(back);
        forwardAction(forward);
        changeModAction(changeMod);

        super.getChildren().addAll(changeMod, back, forward);
    }

    private void backAction(Button b){
        b.setOnAction(actionEvent -> {
            if(index > 0){
                index--;
                mg.updateStatsPane(index);
            }
        });
    }

    private void forwardAction(Button b){
        b.setOnAction(actionEvent -> {
            if(index < 8){
                index++;
                mg.updateStatsPane(index);
            }
        });
    }


    private void changeModAction(Button b){
        b.setOnAction(actionEvent -> {
            c.changeSort();
            mg.updateStatsPane(0);
            changeButtonText(b);
            index = 0;
        });
    }

    private void changeButtonText(Button b){
        if(b.getText().equals("id")){
            b.setText("me");
        }else
            b.setText("id");
    }
}
