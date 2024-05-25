package Controller;

import View.Bottoni;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class KeyHandler {
    private Scene scene;
    private MainGUI mg;

    public KeyHandler(Scene scene, MainGUI mg) {
        this.scene = scene;
        this.mg = mg;
    }

    public void handleKeys(){
        scene.setOnKeyPressed(event -> {
            Bottoni bottoni = mg.getBottoni();
            if(event.getCode() == KeyCode.DIGIT1)
                bottoni.setValoreText(1);
            else if (event.getCode() == KeyCode.DIGIT2)
                bottoni.setValoreText(2);
            else if (event.getCode() == KeyCode.DIGIT3)
                bottoni.setValoreText(3);
            else if ((event.getCode() == KeyCode.DIGIT4))
                bottoni.setValoreText(4);
        });
    }
}
