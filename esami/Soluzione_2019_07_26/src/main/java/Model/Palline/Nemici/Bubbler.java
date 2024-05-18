package Model.Palline.Nemici;

import javafx.scene.paint.Color;

import java.util.Random;

public class Bubbler extends Wanderer{
    public Bubbler() {
        super(Color.LIGHTBLUE);
    }

    @Override
    public void muovi() {
        super.muovi();
        aumentaRaggio();
    }

    private void aumentaRaggio(){
        Random r = new Random();
        if(r.nextInt(10) == 0)
            setRadius(getRadius() + getRadius()*0.2);
    }
}
