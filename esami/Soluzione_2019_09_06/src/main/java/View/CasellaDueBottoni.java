package View;

import javafx.scene.layout.HBox;

public class CasellaDueBottoni extends Casella {
    public CasellaDueBottoni(Bottoni b) {
        super(b);
    }

    @Override
    public HBox aggiungiBottoni(Bottoni b) {
        return new HBox(b.getCancella(), b.getRandom());
    }
}
