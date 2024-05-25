package Model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class PiastrellaConQuadrato extends PiastrellaParticolare{
    public PiastrellaConQuadrato(String codice, String materiale, double prezzo, double lunghezzaLato, boolean sceltaColore) {
        super(codice, materiale, prezzo, lunghezzaLato, sceltaColore);
    }

    @Override
    public void impostaFormaContenuta() {
        Rectangle r = new Rectangle(getLatoFiguraInterna(), getLatoFiguraInterna());
        r.setFill(Color.WHITE);
        setFormaContenuta(r);
    }
}
