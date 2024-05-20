package View;

import Model.Figure.EmptyFigure;
import View.Bottoni.Bottoni;
import com.soluzione_2019_09_06.MainFX;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Shape;

public abstract class Casella extends VBox {
    private Shape forma;
    private HBox bottoni;
    private StackPane sp;

    public Casella() {
        super();
        forma = new EmptyFigure(MainFX.getLATO_EMPTY_FIGURE());

        sp = new StackPane(forma);
        sp.setOnMouseClicked(event -> setForma(new EmptyFigure(MainFX.getLATO_EMPTY_FIGURE())));
        bottoni = aggiungiBottoni(new Bottoni(this));
        bottoni.setAlignment(Pos.CENTER);

        super.getChildren().addAll(sp, bottoni);
        super.setSpacing(10);
    }

    public abstract HBox aggiungiBottoni(Bottoni b);

    public void setForma(Shape forma) {
        this.forma = forma;
        sp.getChildren().clear();
        sp.getChildren().add(forma);
    }

    public Shape getForma() {
        return forma;
    }
}
