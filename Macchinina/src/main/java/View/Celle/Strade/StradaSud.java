package View.Celle.Strade;

import View.Celle.Strada;
import View.Coordinate;
import View.Direzioni;
import View.GrigliaPane;
import View.MainGUI;

public class StradaSud extends Strada {
    public StradaSud(MainGUI mg, GrigliaPane gp, Coordinate c) {
        super(Direzioni.SUD, mg, gp, c);
    }
}
