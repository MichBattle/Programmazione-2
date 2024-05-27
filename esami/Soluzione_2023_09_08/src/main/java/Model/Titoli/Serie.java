package Model.Titoli;

import Model.Titolo;

public class Serie extends Titolo {
    private int nStagioni;
    private int nStagioniSelezionate;

    public Serie(String titolo, String anno, String lingua, double prezzoBase, int nStagioni) {
        super(titolo, anno, lingua, prezzoBase);
        this.nStagioni = nStagioni;
        nStagioniSelezionate = 0;
    }

    public int getnStagioni() {
        return nStagioni;
    }

    public void incrementaStagioniSelezionate() {
        nStagioniSelezionate++;
    }

    public void scontoStagioni(){
        double nuovoPrezzo = calcolaSconto();
        if(nStagioniSelezionate > 1 && nStagioniSelezionate < nStagioni){
            setPrezzoScontato(nuovoPrezzo - nuovoPrezzo*0.25);
        } else if(nStagioniSelezionate == nStagioni)
            setPrezzoScontato(nuovoPrezzo/2);
    }

    @Override
    public void resetPrezzo() {
        super.resetPrezzo();
        nStagioniSelezionate = 0;
    }
}
