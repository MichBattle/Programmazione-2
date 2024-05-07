package View.Celle.Strade;

import View.Celle.Strada;
import View.Coordinate;
import View.Direzioni;
import View.GrigliaPane;
import View.MainGUI;

public class StradaOvest extends Strada {
    public StradaOvest(MainGUI mg, GrigliaPane gp, Coordinate c) {
        super(Direzioni.OVEST, mg, gp, c);
    }
}
