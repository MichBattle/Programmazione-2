package View.Celle.Strade;

import View.Celle.Strada;
import View.Coordinate;
import View.Direzioni;
import View.GrigliaPane;
import View.MainGUI;

public class StradaNord extends Strada {
    public StradaNord(MainGUI mg, GrigliaPane gp, Coordinate c) {
        super(Direzioni.NORD, mg, gp, c);
    }
}
