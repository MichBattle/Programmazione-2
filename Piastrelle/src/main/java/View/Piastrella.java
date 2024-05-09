package View;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Piastrella extends StackPane {
    private String codiceModello;
    private String materiale;
    private double prezzo;
    private boolean sceltaColore;
    private double lato;
    private Color coloreEsterno;
    private Color[] colori;
    private Rectangle r;

    public Piastrella(String codiceModello, String materiale, double prezzo, boolean sceltaColore, double lato) {
        super();
        r = new Rectangle(130, 130);
        colori = new Color[]{Color.BROWN, Color.WHEAT, Color.TEAL, Color.DARKBLUE, Color.OLIVE, Color.GOLD};

        this.codiceModello = codiceModello;
        this.materiale = materiale;
        this.prezzo = prezzo;
        this.coloreEsterno = Color.BROWN;
        this.sceltaColore = sceltaColore;
        this.lato = lato;

        r.setFill(coloreEsterno);

        setStackPaneAction();

        super.getChildren().add(r);
    }

    public Color[] getColori() {
        return colori;
    }

    private void setStackPaneAction(){
        super.setOnMouseClicked(event ->{
            if(sceltaColore){
                cambiaColore();
            }
        });
    }

    public void cambiaColore(){
        int i = 0;
        for (int j = 0; j < 5; j++) {
            if(coloreEsterno.equals(colori[i]))
                break;
            i++;
        }
        if(i+1 == 6)
            i = 0;
        else
            i++;
        coloreEsterno = colori[i];
        r.setFill(coloreEsterno);
    }

    @Override
    public String toString() {
        return "Codice: " + codiceModello + "\n" +
                "materiale: " + materiale + "\n" +
                "costo: " + prezzo + "\n" +
                "dimensione: " + lato + "cm" + "\n" +
                "scelta colore: " + ((sceltaColore)? "SI" : "NO");
    }
}
