package Model.Tessere;

import Controller.MainGUI;
import Model.Tessera;

import java.util.Random;

public class TesseraS extends Tessera {

    public TesseraS(MainGUI mg) {
        super(mg);
    }

    @Override
    public void impostaContenuto() {
        Random r = new Random();
        int val = r.nextInt(8)+1;
        super.setContenuto(String.valueOf(val));
    }

    public void scopri(){
        super.scopri();
        int nuovoPunteggio = getMg().getStatsPane().getPunteggio() + Integer.parseInt(getContenuto());
        getMg().getStatsPane().aggiornaPunteggioText(nuovoPunteggio);
        System.out.println("punteggio tessera scoperta: " + getContenuto());
        //stampo punteggio totale
    }

    @Override
    public void nascondi() {
        super.nascondi();
        super.getChildren().clear();
        super.getChildren().add(creaRettangolo());
        int nuovoPunteggio = getMg().getStatsPane().getPunteggio() - Integer.parseInt(getContenuto());
        getMg().getStatsPane().aggiornaPunteggioText(nuovoPunteggio);
        //stampo punteggio totale
    }
}
