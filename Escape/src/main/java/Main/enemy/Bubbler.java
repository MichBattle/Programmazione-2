package Main.enemy;

import javafx.scene.paint.Color;

import java.util.Random;

public class Bubbler extends Wanderer {
    public Bubbler() {
        super(Color.LIGHTBLUE);
    }

    public void aumentaRaggio() {
        Random r = new Random();
        if(r.nextInt(10) == 0){
            double rad = this.getRadius() + 0.2*this.getRadius();
            this.setRadius(rad);
        }
    }

}
