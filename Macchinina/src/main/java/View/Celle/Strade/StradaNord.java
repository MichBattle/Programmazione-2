package View.Celle.Strade;

import View.Auto;
import View.Celle.Prato;
import View.Celle.Strada;
import Main.Coordinate;
import Main.Direzioni;
import View.GrigliaPane;
import com.macchinina.MainGUI;
import javafx.scene.Node;

public class StradaNord extends Strada {
    public StradaNord(MainGUI mg, GrigliaPane gp, Coordinate c) {
        super(Direzioni.NORD, mg, gp, c);
    }

    /**
     * aggiunge un auto verticale
     */
    @Override
    public void addAuto() {
        super.getChildren().add(new Auto(true));
    }

    /**
     * muove l'auto nella cella a nord
     */
    @Override
    public void muoviAuto() {
        Coordinate c = super.getC();
        Node s = super.getGp().getElementAt(c.getY(), (c.getX()-1));
        if(s instanceof Prato || (c.getX()-1) < 0){
            super.displayAlert();
        }else{
            super.getMg().setCoordinateAuto(new Coordinate(c.getX()-1, c.getY()));
            ((Strada)s).addAuto();
        }
    }
}
