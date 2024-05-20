package View.Caselle;

import View.Bottoni.Bottoni;
import View.Casella;
import javafx.scene.layout.HBox;

public class CasellaDueBottoni extends Casella {
    public CasellaDueBottoni() {
        super();
    }

    @Override
    public HBox aggiungiBottoni(Bottoni b) {
        return new HBox(b.getCancella(), b.getRandom());
    }
}
