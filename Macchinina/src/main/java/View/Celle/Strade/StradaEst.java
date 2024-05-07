package View.Celle.Strade;

import View.Celle.Strada;
import View.Coordinate;
import View.Direzioni;
import View.GrigliaPane;
import View.MainGUI;

public class StradaEst extends Strada {

    public StradaEst(MainGUI mg, GrigliaPane gp, Coordinate c) {
        super(Direzioni.EST, mg, gp, c);
    }
}
