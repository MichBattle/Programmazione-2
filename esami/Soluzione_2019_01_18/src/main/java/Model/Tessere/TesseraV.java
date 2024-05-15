package Model.Tessere;

import Controller.MainGUI;
import Model.AlertDisplayer;
import Model.Tessera;

public class TesseraV extends Tessera {

    public TesseraV(MainGUI mg) {
        super(mg);
    }

    @Override
    public void impostaContenuto() {
        setContenuto("V");
    }

    public void scopri(){
        super.scopri();
        getMg().getStatsPane().aggiornaPartiteVinteText();
        AlertDisplayer.display_WIN_Alert();
        //resetto tutto il resto
    }
}
