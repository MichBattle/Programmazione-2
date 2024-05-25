package Model;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class Piastrella extends StackPane {
    private final int LATO_PIASTRELLA = 130;
    private String codice;
    private String materiale;
    private double prezzo;
    private double lunghezzaLato;
    private Boolean sceltaColore;

    private Colori coloriDisponibili;
    private int indiceColoreBase;

    public Piastrella(String codice, String materiale, double prezzo, double lunghezzaLato, boolean sceltaColore) {
        super();
        coloriDisponibili = new Colori();
        this.codice = codice;
        this.materiale = materiale;
        this.prezzo = prezzo;
        this.lunghezzaLato = lunghezzaLato;
        this.sceltaColore = sceltaColore;

        if(sceltaColore) {
            indiceColoreBase = 0;
            impostaEventoSuper();
        }

        Rectangle r = new Rectangle(LATO_PIASTRELLA, LATO_PIASTRELLA);
        r.setFill(coloriDisponibili.get(0));
        super.getChildren().add(r);
    }

    public Colori getColoriDisponibili() {
        return coloriDisponibili;
    }

    public Boolean getSceltaColore() {
        return sceltaColore;
    }

    public double getLunghezzaLato() {
        return lunghezzaLato;
    }

    public int incrementaIndice(int indice){
        indice++;
        if(indice == 6)
            indice = 0;
        return indice;
    }

    private void impostaEventoSuper(){
        super.setOnMouseClicked(event -> {
            Rectangle r = (Rectangle) (super.getChildren().get(super.getChildren().size() - 1)); //getLast
            indiceColoreBase = incrementaIndice(indiceColoreBase);
            r.setFill(coloriDisponibili.get(indiceColoreBase));
        });
    }

    private String sceltaColore(){
        return (sceltaColore)? "SI" : "NO";
    }

    @Override
    public String toString() {
        return  "Codice: " + codice + "\n" +
                "materiale: " + materiale + "\n" +
                "costo: " + prezzo + " EUR" + "\n" +
                "dimensione: " + lunghezzaLato + " cm" + "\n" +
                "scelta colore: " + sceltaColore();
    }
}
