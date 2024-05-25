package Model;

import javafx.scene.paint.Color;
import java.util.Random;

public abstract class CellaCentrale extends Cella{
    public CellaCentrale(Color colore) {
        super(colore);
        impostaContenuto();
    }

    @Override
    public void impostaContenuto() {
        Random r = new Random();
        setContenuto(r.nextInt(4));
        aggiungiContenuto();
    }

    public abstract void aggiornaValore();
}
