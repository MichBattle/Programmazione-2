package Model.CelleCentrali;

import Model.CellaCentrale;
import javafx.scene.paint.Color;

public class CellaBlu extends CellaCentrale {
    public CellaBlu() {
        super(Color.BLUE);
    }

    @Override
    public void aggiornaValore() {
        if(getContenuto()-1 < 0)
            setContenuto(3);
        else
            setContenuto(getContenuto()-1);
        aggiungiContenuto();
    }
}
