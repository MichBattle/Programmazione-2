package View;

import javafx.scene.layout.HBox;

public class CasellaTreBottoni extends Casella{
    public CasellaTreBottoni(Bottoni b) {
        super(b);
    }

    @Override
    public HBox aggiungiBottoni(Bottoni b) {
        return new HBox(b.getCancella(), b.getCerchio(), b.getTriangolo());
    }
}
