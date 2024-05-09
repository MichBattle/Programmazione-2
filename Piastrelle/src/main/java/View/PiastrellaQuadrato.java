package View;

import javafx.scene.shape.Rectangle;

public class PiastrellaQuadrato extends PiastrellaDettagliata {
    public PiastrellaQuadrato(String codiceModello, String materiale, double prezzo, boolean sceltaColore, double lato) {
        super(codiceModello, materiale, prezzo, sceltaColore, new Rectangle(65, 65), lato);
    }
}
