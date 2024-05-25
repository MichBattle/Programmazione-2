package Model;

import javafx.scene.shape.Shape;

public abstract class PiastrellaParticolare extends Piastrella{
    private Shape formaContenuta;
    private int indiceColoreInterno;

    public PiastrellaParticolare(String codice, String materiale, double prezzo, double lunghezzaLato, boolean sceltaColore) {
        super(codice, materiale, prezzo, lunghezzaLato, sceltaColore);
        impostaFormaContenuta();
        if(getSceltaColore()) {
            indiceColoreInterno = 1;
            setFormaInternaAction();
        }
        formaContenuta.setFill(getColoriDisponibili().get(1));
        super.getChildren().add(formaContenuta);
    }

    public void setFormaContenuta(Shape formaContenuta) {
        this.formaContenuta = formaContenuta;
    }

    public double getLatoFiguraInterna(){
        return getLunghezzaLato()/2;
    }

    public abstract void impostaFormaContenuta();

    private void setFormaInternaAction(){
        formaContenuta.setOnMouseClicked(event -> {
            indiceColoreInterno = incrementaIndice(indiceColoreInterno);
            formaContenuta.setFill(getColoriDisponibili().get(indiceColoreInterno));
        });
    }
}
