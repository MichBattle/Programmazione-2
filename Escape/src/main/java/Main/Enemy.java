package Main;

import javafx.scene.paint.Color;

import java.util.Random;

public abstract class Enemy extends Palla {
    private Direzioni direzione;

    public Enemy(Color c) {
        super(c);
        direzione = Direzioni.EMPTY;
        cambiaDirezione();
    }

    public Direzioni getDirezione() {
        return direzione;
    }

    public void setDirezione(Direzioni direzione) {
        this.direzione = direzione;
    }

    public void cambiaDirezione(){
        Random random = new Random();
        int direz;

        do{
            direz = random.nextInt(8);
        }while (getDirezione().toString().equals(getEnumString(direz)));

        switch (direz){
            case 0:
                setDirezione(Direzioni.UP);
                break;
            case 1:
                setDirezione(Direzioni.DOWN);
                break;
            case 2:
                setDirezione(Direzioni.RIGHT);
                break;
            case 3:
                setDirezione(Direzioni.LEFT);
                break;
            case 4:
                setDirezione(Direzioni.TOPRIGHT);
                break;
            case 5:
                setDirezione(Direzioni.TOPLEFT);
                break;
            case 6:
                setDirezione(Direzioni.BOTTOMLEFT);
                break;
            case 7:
                setDirezione(Direzioni.BOTTOMRIGHT);
                break;
        }
    }

    private String getEnumString(int index){
        Direzioni[] values = Direzioni.values();
        if (index >= 0 && index < values.length - 1) {
            return values[index].name();
        } else {
            return null;
        }
    }

    public abstract void move();

    public void moveUP(){
        this.setCenterY(this.getCenterY()-10);
    }

    public void moveDOWN(){
        this.setCenterY(this.getCenterY()+10);
    }

    public void moveLEFT(){
        this.setCenterX(this.getCenterX()-10);
    }

    public void moveRIGHT(){
        this.setCenterX(this.getCenterX()+10);
    }

    public void moveTOPRIGHT(){
        this.setCenterY(this.getCenterY()-10);
        this.setCenterX(this.getCenterX()+10);
    }

    public void moveTOPLEFT(){
        this.setCenterY(this.getCenterY()-10);
        this.setCenterX(this.getCenterX()-10);
    }

    public void moveBOTTOMRIGHT(){
        this.setCenterY(this.getCenterY()+10);
        this.setCenterX(this.getCenterX()+10);
    }

    public void moveBOTTOMLEFT(){
        this.setCenterY(this.getCenterY()+10);
        this.setCenterX(this.getCenterX()-10);
    }
}
