package Model.celle;

import Model.Cella;
import Model.Gioco;
import javafx.scene.paint.Color;

public class CellaMolt extends Cella {
    private Gioco g;

    public CellaMolt(Gioco g) {
        super();
        this.g = g;
        this.setColore(Color.GREEN);
    }

    @Override
    public void azione() {
        if(this.isCoperta()){
            g.setPunteggioTotale(g.getPunteggioTotale()*2);
            this.setCoperta(false);
        }
        else
            System.out.println("Cell is discovered\n");
    }

    @Override
    public String content() {
        return "x2";
    }
}
