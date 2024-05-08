package View;

import Controller.MainGUI;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

import java.security.Key;

public class KeyHandler {
    private Scene s;
    private MainGUI mg;

    public KeyHandler(Scene s, MainGUI mg) {
        this.s = s;
        this.mg = mg;
    }

    public void handleKeysEvent(){
        s.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.DIGIT1)
                mg.getBp().setButtonText(1);
            else if(event.getCode() == KeyCode.DIGIT2)
                mg.getBp().setButtonText(2);
            else if(event.getCode() == KeyCode.DIGIT3)
                mg.getBp().setButtonText(3);
            else if(event.getCode() == KeyCode.DIGIT4)
                mg.getBp().setButtonText(4);
        });
    }
}
