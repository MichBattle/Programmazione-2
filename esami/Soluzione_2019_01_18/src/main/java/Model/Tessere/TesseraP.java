package Model.Tessere;

import Controller.MainGUI;
import Model.AlertDisplayer;
import Model.Tessera;

public class TesseraP extends Tessera {

    public TesseraP(MainGUI mg) {
        super(mg);
    }

    @Override
    public void impostaContenuto() {
        setContenuto("P");
    }

    public void scopri(){
        super.scopri();
        AlertDisplayer.display_LOOSE_Alert();
    }
}
