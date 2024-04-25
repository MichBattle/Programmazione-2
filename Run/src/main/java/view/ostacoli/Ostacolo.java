package view.ostacoli;

import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public abstract class Ostacolo extends HBox {
    private Color colore;
    private Shape forma;

    /**
     * crea un ostacolo della forma e con il colore selezionati
     * @param colore
     * @param forma
     */
    public Ostacolo(Color colore, Shape forma) {
        super();
        this.colore = colore;
        this.forma = forma;
        this.forma.setFill(colore);
        super.getChildren().add(forma);
    }

    abstract void azione();

    public Shape getForma() {
        return forma;
    }
}
