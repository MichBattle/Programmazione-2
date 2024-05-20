package View;

import Model.EmptyFigure;
import com.soluzione_2019_09_06.MainFX;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Shape;

public abstract class Casella extends VBox {
    private Shape forma;
    private HBox bottoni;

    public Casella(Bottoni b) {
        super();
        forma = new EmptyFigure(MainFX.getLATO_EMPTY_FIGURE());

        StackPane sp = new StackPane(forma);
        sp.setOnMouseClicked(event -> setForma(new EmptyFigure(MainFX.getLATO_EMPTY_FIGURE())));
        bottoni = aggiungiBottoni(b);

        super.getChildren().addAll(sp, bottoni);
        super.setSpacing(5);
    }

    public abstract HBox aggiungiBottoni(Bottoni b);

    public void setForma(Shape forma) {
        this.forma = forma;
    }
}
