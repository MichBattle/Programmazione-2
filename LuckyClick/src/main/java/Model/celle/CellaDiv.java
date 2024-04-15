package Model.celle;

import Model.Cella;
import Model.Gioco;
import javafx.scene.paint.Color;

public class CellaDiv extends Cella {
    private Gioco g;

    public CellaDiv(Gioco g) {
        super();
        this.g = g;
        this.setColore(Color.RED);
    }

    @Override
    public void azione() {
        if(this.isCoperta()){
            g.setPunteggioTotale(g.getPunteggioTotale()/2);
            this.setCoperta(false);
        }else
            System.out.println("Cell is discovered\n");
    }

    @Override
    public String content() {
        return "/2";
    }
}
