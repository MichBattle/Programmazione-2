package Controller;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class KeyHandler {
    private MainGUI mg;
    private Scene scene;

    public KeyHandler(MainGUI mg, Scene scene) {
        this.mg = mg;
        this.scene = scene;
    }

    public void handleKeys(){
        scene.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.A)
                mg.getBottoniPerGestire().clearAllAction(mg.getScacchieraPane());
            else if(event.getCode() == KeyCode.C)
                mg.getBottoniPerGestire().checkAction(mg.getScacchieraPane());
        });
    }
}
