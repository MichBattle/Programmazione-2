package View;

import javafx.scene.shape.Circle;

public class PiastrellaCerchio extends PiastrellaDettagliata{
    public PiastrellaCerchio(String codiceModello, String materiale, double prezzo, boolean sceltaColore, double lato) {
        super(codiceModello, materiale, prezzo, sceltaColore, new Circle(65), lato);
    }
}
