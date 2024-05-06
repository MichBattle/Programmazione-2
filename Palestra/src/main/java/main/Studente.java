package main;

public class Studente extends Persona {
    private String universita;
    private boolean triennale;

    public Studente(String cognome, String nome, String annoNascita, String codiceFiscale, String universita, boolean triennale) {
        super(cognome, nome, annoNascita, codiceFiscale);
        this.universita = universita;
        this.triennale = triennale;
        double sconto = this.trovaSconto();
        this.setPrezzoAbbonamento(this.scontaPrezzo(this.getPrezzoAbbonamento(), sconto));
    }

    private double trovaSconto() {
        double sconto = 0.0;
        if (super.getPrezzoAbbonamento() < 1000.0) {
            if (this.triennale) {
                this.setPrezzoAbbonamento(1000.0);
                sconto = 0.4;
            }
        } else if (this.triennale) {
            sconto = 0.4;
        } else {
            sconto = 0.2;
        }

        return sconto;
    }

    private String codificaTriennale(){
        if(triennale)
            return "LT";
        else
            return "LM";
    }

    @Override
    public String addString() {
        return universita + " " + codificaTriennale();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}