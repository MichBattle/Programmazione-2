package View.Caselle;

import View.Bottoni.Bottoni;
import View.Casella;
import javafx.scene.layout.HBox;

public class CasellaTreBottoni extends Casella {
    public CasellaTreBottoni() {
        super();
    }

    @Override
    public HBox aggiungiBottoni(Bottoni b) {
        return new HBox(b.getCancella(), b.getCerchio(), b.getTriangolo());
    }
}
