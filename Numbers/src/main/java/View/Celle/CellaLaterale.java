package View.Celle;

import Controller.MainGUI;
import View.Cella;
import View.GrigliaPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public abstract class CellaLaterale extends Cella {
    private int val;
    private GrigliaPane gp;

    public CellaLaterale(GrigliaPane gp, int val, Color r) {
        super(r);
        this.val = val;
        this.gp = gp;
    }

    public int getVal() {
        return val;
    }

    public GrigliaPane getGp() {
        return gp;
    }

    public abstract void impostaNumero();
}
