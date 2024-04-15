package Model.celle;

import Model.Cella;
import Model.Gioco;
import javafx.scene.paint.Color;

public class CellaBoom extends Cella {

    public CellaBoom(Gioco g) {
        super();
        this.setColore(Color.CYAN);
    }

    @Override
    public void azione() {
        if(isCoperta()){
            this.setCoperta(false);
        }else
            System.out.println("Cell is discovered\n");
    }

    @Override
    public String content() {
        return "BOOM";
    }
}
