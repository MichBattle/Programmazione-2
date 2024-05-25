package Model.CelleLaterali;

import Model.CellaLaterale;
import View.CellePane;
import javafx.scene.paint.Color;

public class CellaVerde extends CellaLaterale {
    public CellaVerde(CellePane cp, int row) {
        super(cp, Color.GREEN, row);
    }

    @Override
    public void impostaContenuto() {
        setContenuto(getCp().getValoreRiga(getCoordinata()));
        aggiungiContenuto();
    }
}
