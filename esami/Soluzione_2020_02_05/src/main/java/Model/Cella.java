package Model;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public abstract class Cella extends StackPane {
    private int contenuto;

    public Cella(Color colore) {
        super();
        Rectangle r = new Rectangle(50, 50);
        r.setFill(colore);
        r.setStroke(Color.TRANSPARENT);
        super.getChildren().addAll(r);
    }

    public void aggiungiContenuto(){
        if(super.getChildren().getLast() instanceof Text)
            super.getChildren().removeLast();
        Text t = new Text(String.valueOf(contenuto));
        t.setFill(Color.YELLOW);
        super.getChildren().add(t);
    }

    public int getContenuto() {
        return contenuto;
    }

    public abstract void impostaContenuto();

    public void setContenuto(int contenuto) {
        this.contenuto = contenuto;
    }
}
