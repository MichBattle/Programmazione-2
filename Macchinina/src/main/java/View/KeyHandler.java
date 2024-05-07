package View;

import View.Celle.Strade.StradaNord;
import com.macchinina.MainGUI;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class KeyHandler {
    private Scene scene;
    private MainGUI mg;

    public KeyHandler(Scene scene, MainGUI mg) {
        this.scene = scene;
        this.mg = mg;
    }

    public void handleKeysPressed(){
        scene.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.W){
                mg.getIndicationButtons().disableButton(mg.getIndicationButtons().getNord());
            }else if(event.getCode() == KeyCode.A){
                mg.getIndicationButtons().disableButton(mg.getIndicationButtons().getOvest());
            }else if(event.getCode() == KeyCode.S){
                mg.getIndicationButtons().disableButton(mg.getIndicationButtons().getSud());
            }else if(event.getCode() == KeyCode.D){
                mg.getIndicationButtons().disableButton(mg.getIndicationButtons().getEst());
            }else if(event.getCode() == KeyCode.P){
                mg.getIndicationButtons().disableButton(mg.getIndicationButtons().getPrato());
            }
        });
    }
}
