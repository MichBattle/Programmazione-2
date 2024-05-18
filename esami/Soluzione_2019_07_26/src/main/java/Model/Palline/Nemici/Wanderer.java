package Model.Palline.Nemici;

import Model.Direzione;
import Model.Palline.Enemy;
import javafx.scene.paint.Color;

public class Wanderer extends Enemy {
    public Wanderer() {
        super(Color.DARKBLUE);
    }

    public Wanderer(Color colore) {
        super(colore);
    }

    public void cambiaDirezione(){
        Direzione direzioneIniziale = getDirezione();
        do{
            creaDirezione();
        }while(direzioneIniziale == getDirezione());
    }
}
