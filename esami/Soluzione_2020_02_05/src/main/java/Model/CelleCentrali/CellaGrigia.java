package Model.CelleCentrali;

import Model.CellaCentrale;
import javafx.scene.paint.Color;

public class CellaGrigia extends CellaCentrale {
    public CellaGrigia() {
        super(Color.GRAY);
    }

    @Override
    public void aggiornaValore() {
        if(getContenuto()+1 > 3)
            setContenuto(0);
        else
            setContenuto(getContenuto()+1);
        aggiungiContenuto();
    }
}
