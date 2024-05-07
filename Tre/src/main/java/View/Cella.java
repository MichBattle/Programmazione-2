package View;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Shape;

public class Cella extends VBox {
    private Shape forma;
    private HBox hb;
    private Buttons b;

    public Cella() {
        b = new Buttons(this);
        hb = b.creaBottoni();

        forma = b.getCasualForm();
        forma.setOnMouseClicked(event -> {
            this.forma = getB().getEmpty();
            super.getChildren().clear();
            super.getChildren().addAll(forma, hb);
        });

        super.getChildren().addAll(forma, hb);
    }

    public Shape getForma() {
        return forma;
    }

    public void setForma(Shape forma) {
        this.forma = forma;
        super.getChildren().clear();
        super.getChildren().addAll(forma, hb);
    }

    public Buttons getB() {
        return b;
    }
}
