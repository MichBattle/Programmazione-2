package main;

public class AtletaStudente extends Persona {
    private String universita;
    private boolean triennale;
    private String disciplina;
    private boolean rilevanzaInternazionale;

    public AtletaStudente(String cognome, String nome, String annoNascita, String codiceFiscale, String universita, boolean triennale, String disciplina, boolean rilevanzaInternazionale) {
        super(cognome, nome, annoNascita, codiceFiscale);
        this.universita = universita;
        this.triennale = triennale;
        this.disciplina = disciplina;
        this.rilevanzaInternazionale = rilevanzaInternazionale;
        double sconto = this.trovaSconto();
        this.setPrezzoAbbonamento(this.scontaPrezzo(this.getPrezzoAbbonamento(), sconto));
    }

    private double trovaSconto() {
        double sconto = 0.0;
        if (super.getPrezzoAbbonamento() < 1000.0) {
            if (this.rilevanzaInternazionale) {
                this.setPrezzoAbbonamento(1000.0);
                sconto = 0.5;
            } else if (this.triennale) {
                this.setPrezzoAbbonamento(1000.0);
                sconto = 0.4;
            }
        } else {
            double scontoStudente;
            if (this.triennale) {
                scontoStudente = 0.4;
            } else {
                scontoStudente = 0.2;
            }

            double scontoAtleta;
            if (this.rilevanzaInternazionale) {
                scontoAtleta = 0.5;
            } else {
                scontoAtleta = 0.3;
            }

            if (scontoStudente > scontoAtleta) {
                sconto = scontoStudente;
            } else {
                sconto = scontoAtleta;
            }
        }

        return sconto;
    }

    private String codificaInternazionale(){
        if(rilevanzaInternazionale)
            return "internazionale";
        else
            return "nazionale";
    }

    private String codificaTriennale(){
        if(triennale)
            return "LT";
        else
            return "LM";
    }

    @Override
    public String addString() {
        return universita + " " + codificaTriennale() + " " + disciplina + " " + codificaInternazionale();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}