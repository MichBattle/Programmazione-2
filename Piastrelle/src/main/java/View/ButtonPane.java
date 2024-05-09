package View;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ButtonPane extends HBox {
    private Button prev;
    private Button next;

    public ButtonPane(MainGUI mg) {
        super();
        prev = new Button("prev");
        next = new Button("next");
        prev.setDisable(true);

        setPrevAction(mg);
        setNextAction(mg);

        super.getChildren().addAll(prev, next);
        super.setSpacing(10);
    }

    private void setPrevAction(MainGUI mg){
        prev.setOnAction(event -> {
            MainGUI.setINDEX(MainGUI.getINDEX()-1);
            mg.getTextPane().updateText();
            mg.getPiastrellaPane().updatePiastrellaMostrata();

            if(MainGUI.getINDEX() == 0)
                prev.setDisable(true);
            if(MainGUI.getINDEX() == 4)
                next.setDisable(false);
        });
    }

    private void setNextAction(MainGUI mg){
        next.setOnAction(event -> {
            MainGUI.setINDEX(MainGUI.getINDEX()+1);
            mg.getTextPane().updateText();
            mg.getPiastrellaPane().updatePiastrellaMostrata();

            if(MainGUI.getINDEX() == 5)
                next.setDisable(true);
            if(MainGUI.getINDEX() == 1)
                prev.setDisable(false);
        });
    }
}
