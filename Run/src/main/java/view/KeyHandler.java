package view;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class KeyHandler {
    private Scene scene;
    private MainGUI mg;

    public KeyHandler(Scene s, MainGUI mg) {
        this.scene = s;
        this.mg = mg;
    }

    /**
     * gestisce gli input:
     * se la partita non è gia finita (o per win o per loose)
     * gestisce UP, DOWN, SPACE muovendo il giocatore
     */
    public void handle_keys_pressed(){
        scene.setOnKeyPressed(event -> {
            if(!mg.checkWin() && !mg.isEnd()){
                if (event.getCode() == KeyCode.UP) {
                    mg.movePlayerUp();
                }else if(event.getCode() == KeyCode.DOWN){
                    mg.movePlayerDown();
                }else if(event.getCode() == KeyCode.SPACE){
                    mg.movePlayerForward();
                }
            }
        });
    }
}
