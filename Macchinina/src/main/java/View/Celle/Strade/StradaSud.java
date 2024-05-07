package View.Celle.Strade;

import View.Auto;
import View.Celle.Prato;
import View.Celle.Strada;
import Main.Coordinate;
import Main.Direzioni;
import View.GrigliaPane;
import com.macchinina.MainGUI;
import javafx.scene.Node;

public class StradaSud extends Strada {
    public StradaSud(MainGUI mg, GrigliaPane gp, Coordinate c) {
        super(Direzioni.SUD, mg, gp, c);
    }

    /**
     * aggiunge un auto verticale
     */
    @Override
    public void addAuto() {
        super.getChildren().add(new Auto(true));
    }

    /**
     * muove l'auto nella cella a sud
     */
    @Override
    public void muoviAuto() {
        Coordinate c = super.getC();
        Node s = super.getGp().getElementAt(c.getY(), (c.getX()+1));
        if(s instanceof Prato || (c.getX()+1) == 10){
            super.displayAlert();
        }else{
            super.getMg().setCoordinateAuto(new Coordinate(c.getX()+1, c.getY()));
            ((Strada)s).addAuto();
        }
    }
}
