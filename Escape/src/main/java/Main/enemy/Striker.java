package Main.enemy;

import Main.Direzioni;
import Main.Enemy;
import javafx.scene.paint.Color;

import java.util.Random;

public class Striker extends Enemy {
    public Striker() {
        super(Color.BLUE);
    }

    public Striker(Color c) {
        super(c);
    }

    @Override
    public void move() {
        switch (super.getDirezione()){
            case UP:
                moveUP();
            break;
            case DOWN:
                moveDOWN();
                break;
            case RIGHT:
                moveRIGHT();
                break;
            case LEFT:
                moveLEFT();
                break;
            case TOPRIGHT:
                moveTOPRIGHT();
                break;
            case TOPLEFT:
                moveTOPLEFT();
                break;
            case BOTTOMLEFT:
                moveBOTTOMLEFT();
                break;
            case BOTTOMRIGHT:
                moveBOTTOMRIGHT();
                break;
        }
    }

    @Override
    public void cambiaDirezione() {
        super.cambiaDirezione();
    }
}
