package Model;

import View.CellePane;
import javafx.scene.paint.Color;

public abstract class CellaLaterale extends Cella{
    private int coordinata;
    private CellePane cp;

    public CellaLaterale(CellePane cp, Color colore, int coordinata) {
        super(colore);
        this.cp = cp;
        this.coordinata = coordinata;
    }

    public CellePane getCp() {
        return cp;
    }

    public int getCoordinata() {
        return coordinata;
    }
}
