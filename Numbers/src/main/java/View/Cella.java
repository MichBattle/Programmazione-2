package View;

import Controller.MainGUI;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Cella extends StackPane {
    private int valore;

    public Cella(Color color) {
        super();
        Rectangle r = new Rectangle(50, 50);
        r.setFill(color);
        r.setStroke(Color.WHITE);
        super.getChildren().add(r);
    }

    public int getValore() {
        return valore;
    }

    public void setValore(int valore) {
        this.valore = valore;
    }

    public abstract void impostaNumero();
}
