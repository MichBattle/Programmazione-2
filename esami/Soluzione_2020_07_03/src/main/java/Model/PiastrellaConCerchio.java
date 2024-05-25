package Model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PiastrellaConCerchio extends PiastrellaParticolare{
    public PiastrellaConCerchio(String codice, String materiale, double prezzo, double lunghezzaLato, boolean sceltaColore) {
        super(codice, materiale, prezzo, lunghezzaLato, sceltaColore);
    }

    @Override
    public void impostaFormaContenuta() {
        Circle c = new Circle(getLatoFiguraInterna());
        setFormaContenuta(c);
    }
}
