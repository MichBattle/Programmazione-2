package Model.Tessere;

import Model.Gioco;
import Model.Tessera;

import java.util.Random;

public class TesseraS extends Tessera{
    private Gioco g;

    public TesseraS(Gioco g) {
        super("");
        super.setValore(creaValore());
        this.g = g;
    }

    private String creaValore(){
        Random r = new Random();
        return String.valueOf(r.nextInt(9)+1);
    }

    @Override
    public void scopri() {
        g.setPunteggio(g.getPunteggio() + Integer.parseInt(super.getValore()));
        System.out.println("Valore tessera: " + super.getValore());
        System.out.println("Punteggio attuale: " + g.getPunteggio());
    }

    @Override
    public void nascondi() {
        g.setPunteggio(g.getPunteggio() - Integer.parseInt(super.getValore()));
        System.out.println("copro la cella");
        System.out.println("Punteggio attuale: " + g.getPunteggio());
    }
}
