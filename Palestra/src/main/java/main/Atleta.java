package main;

public class Atleta extends Persona {
    private String disciplina;
    private boolean rilevanzaInternazionale;

    public Atleta(String cognome, String nome, String annoNascita, String codiceFiscale, String disciplina, boolean rilevanzaInternazionale) {
        super(cognome, nome, annoNascita, codiceFiscale);
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
            }
        } else if (this.rilevanzaInternazionale) {
            sconto = 0.5;
        } else {
            sconto = 0.3;
        }

        return sconto;
    }

    private String codificaInternazionale(){
        if(rilevanzaInternazionale)
            return "internazionale";
        else
            return "nazionale";
    }

    @Override
    public String addString() {
        return disciplina + " " + codificaInternazionale();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}