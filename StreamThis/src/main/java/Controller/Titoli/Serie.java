package Controller.Titoli;

import Controller.Titolo;

public class Serie extends Titolo {
    private int numStagioni;

    public Serie(String nome, String anno, String lingua, double prezzo, int numStagioni) {
        super(nome, anno, lingua, prezzo);
        this.numStagioni = numStagioni;
    }

    public int getNumStagioni() {
        return numStagioni;
    }

    public void calcolaScontoSerie(int nStagioniAcquistate) throws Exception {
        double prezzo = super.getPrezzoScontato();
        if(nStagioniAcquistate < numStagioni && nStagioniAcquistate > 1)
            prezzo -= prezzo*0.25;
        else if(nStagioniAcquistate == numStagioni)
            prezzo -= prezzo*0.5;
        else
            throw new Exception("numero stagioni inserite non valido");

        super.setPrezzoScontato(prezzo);
    }
}
