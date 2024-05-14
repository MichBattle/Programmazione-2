package main;

public class Persona {
    private double prezzoAbbonamento = 1000.0;
    private String nome;
    private String cognome;
    private String annoNascita;
    private String codiceFiscale;

    public Persona(String cognome, String nome, String annoNascita, String codiceFiscale) {
        this.nome = nome;
        this.cognome = cognome;
        this.annoNascita = annoNascita;
        this.codiceFiscale = codiceFiscale;
        if (this.checkAnziano(Integer.parseInt(annoNascita))) {
            this.setPrezzoAbbonamento(this.scontaPrezzo(this.prezzoAbbonamento, 0.35));
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getAnnoNascita() {
        return annoNascita;
    }

    public double getPrezzoAbbonamento() {
        return this.prezzoAbbonamento;
    }

    public void setPrezzoAbbonamento(double prezzoAbbonamento) {
        this.prezzoAbbonamento = prezzoAbbonamento;
    }

    public double scontaPrezzo(double prezzo, double sconto) {
        return prezzo * (1.0 - sconto);
    }

    private boolean checkAnziano(int dataNascita) {
        return dataNascita < 1968;
    }

    public String addString(){
        return "";
    }

    public String toString() {
        return cognome + " " + nome + " " + codiceFiscale + " " + annoNascita + " " + addString() + " | tariffa: " + getPrezzoAbbonamento() ;
    }
}