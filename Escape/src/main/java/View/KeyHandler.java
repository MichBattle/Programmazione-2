package View;

import Control.MainGUI;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class KeyHandler {
    private Scene scene;
    private MainGUI mg;

    public KeyHandler(Scene scene, MainGUI mg) {
        this.scene = scene;
        this.mg = mg;
    }

    public void handleKeyPressed(){
        scene.setOnKeyPressed(event -> {
            double posX = mg.getU().getCenterX();
            double posY = mg.getU().getCenterY();

            MainGUI.ITERATION_INDEX++;

            if(MainGUI.ITERATION_INDEX%10 == 0)
                mg.spawnNewEnemy();

            if(event.getCode() == KeyCode.UP){
                mg.getU().setCenterY(posY-10);
            }else if(event.getCode() == KeyCode.DOWN){
                mg.getU().setCenterY(posY+10);
            }else if(event.getCode() == KeyCode.RIGHT){
                mg.getU().setCenterX(posX+10);
            }else if(event.getCode() == KeyCode.LEFT){
                mg.getU().setCenterX(posX-10);
            }

            mg.moveStrikers();
            mg.moveWanderers();
            mg.moveBubblers();
        });
    }
}
