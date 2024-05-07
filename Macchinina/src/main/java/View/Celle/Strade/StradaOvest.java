package View.Celle.Strade;

import View.Auto;
import View.Celle.Prato;
import View.Celle.Strada;
import Main.Coordinate;
import Main.Direzioni;
import View.GrigliaPane;
import com.macchinina.MainGUI;
import javafx.scene.Node;

public class StradaOvest extends Strada {
    public StradaOvest(MainGUI mg, GrigliaPane gp, Coordinate c) {
        super(Direzioni.OVEST, mg, gp, c);
    }

    /**
     * aggiunge un auto orizzontale
     */
    @Override
    public void addAuto() {
        super.getChildren().add(new Auto(false));
    }

    /**
     * muove l'auto nella cella a ovest
     */
    @Override
    public void muoviAuto() {
        Coordinate c = super.getC();
        Node s = super.getGp().getElementAt(c.getY()-1, (c.getX()));
        if(s instanceof Prato || (c.getY()-1) < 0){
            super.displayAlert();
        }else{
            super.getMg().setCoordinateAuto(new Coordinate(c.getX(), c.getY()-1));
            ((Strada)s).addAuto();
        }
    }
}
