package View;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public abstract class PiastrellaDettagliata extends Piastrella{
    private Color coloreInterno;
    private Shape s;

    public PiastrellaDettagliata(String codiceModello, String materiale, double prezzo, boolean sceltaColore, Shape s, double lato) {
        super(codiceModello, materiale, prezzo, sceltaColore, lato);
        this.s = s;
        coloreInterno = Color.WHEAT;
        s.setFill(coloreInterno);
        super.getChildren().add(s);
    }

    @Override
    public void cambiaColore() {
        super.cambiaColore();
        Color[] colori = super.getColori();
        int i = 0;
        for (int j = 0; j < 5; j++) {
            if(coloreInterno.equals(colori[i]))
                break;
            i++;
        }
        if(i+1 == 6)
            i = 0;
        else
            i++;
        coloreInterno = colori[i];
        s.setFill(coloreInterno);
    }
}
