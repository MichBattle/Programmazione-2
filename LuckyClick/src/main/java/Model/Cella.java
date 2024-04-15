package Model;

import javafx.scene.Node;
import javafx.scene.paint.Color;

public abstract class Cella extends Node {
    private boolean coperta;
    private Color colore;

    public Cella() {
        this.setCoperta(true);
    }

    public boolean isCoperta() {
        return coperta;
    }

    public Color getColore() {
        return colore;
    }

    public void setCoperta(boolean coperta) {
        this.coperta = coperta;
    }

    public void setColore(Color colore) {
        this.colore = colore;
    }

    public abstract void azione();

    public abstract String content();
}
