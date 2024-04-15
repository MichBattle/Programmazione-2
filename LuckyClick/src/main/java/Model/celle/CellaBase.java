package Model.celle;
import Model.Cella;
import Model.Gioco;
import javafx.scene.paint.Color;

public class CellaBase extends Cella {
    private int punteggio;
    private Gioco g;

    public CellaBase(Gioco g) {
        super();
        this.setColore(Color.WHITE);
        this.g = g;
        this.punteggio = creaPunteggio();
    }

    private int creaPunteggio(){
        int r = (int) (Math.random() * 10) + 1;
        return r * 100;
    }

    @Override
    public void azione() {
        if(this.isCoperta()) {
            g.setPunteggioTotale(g.getPunteggioTotale() + punteggio);
            this.setCoperta(false);
        }else
            System.out.println("Cell is discovered\n");
    }

    @Override
    public String content() {
        return String.valueOf(punteggio);
    }
}
