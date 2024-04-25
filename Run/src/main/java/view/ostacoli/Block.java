package view.ostacoli;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import view.MainGUI;
import view.StatsPane;

public class Block extends Ostacolo {
    private StatsPane sp;
    private boolean action;

    public Block(StatsPane sp) {
        super(Color.RED, new Rectangle(20, 20));
        this.sp = sp;
        this.action = false;
    }

    /**
     * se non è gia stato attivato:
     * aggiorna la label delle vite diminuendo di 1
     * svuota il Fill della forma
     */
    @Override
    public void azione() {
        if(!action){
            sp.setViteLabel(true);
            super.getForma().setFill(Color.WHITE);
            super.getForma().setStroke(Color.RED);
            action = true;
        }
    }
}
