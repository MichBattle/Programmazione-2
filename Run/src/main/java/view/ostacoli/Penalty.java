package view.ostacoli;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import view.MainGUI;
import view.StatsPane;

public class Penalty extends Ostacolo {
    private StatsPane sp;
    private boolean action;

    public Penalty(StatsPane sp) {
        super(Color.BLUE, new Circle(10));
        this.sp = sp;
        this.action = false;
    }

    /**
     * se non è gia stato attivato:
     * diminuisce di 500 il punteggio e aggiorna la label
     * svuota il Fill della forma
     */
    @Override
    public void azione() {
        if(!action){
            sp.setPunteggioLabel(-500);
            super.getForma().setFill(Color.WHITE);
            super.getForma().setStroke(Color.BLUE);
            action = true;
        }
    }
}
