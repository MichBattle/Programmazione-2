package Model.CelleLaterali;

import Model.CellaLaterale;
import View.CellePane;
import javafx.scene.paint.Color;

public class CellaRossa extends CellaLaterale {
    public CellaRossa(CellePane cp, int col) {
        super(cp, Color.RED, col);
    }

    @Override
    public void impostaContenuto() {
        setContenuto(getCp().getValoreColonna(getCoordinata()));
        aggiungiContenuto();
    }
}
