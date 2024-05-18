package Model.Persone;

import Model.Persona;

public class AtletaStudente extends Persona {
    private Atleta atleta;
    private Studente studente;

    public AtletaStudente(String nome, String cognome, String codiceFiscale, String annoNascita, String attrStudente1, boolean attrStudente2, String attrAtleta1, boolean attrAtleta2) {
        super(nome, cognome, codiceFiscale, annoNascita);
        atleta = new Atleta(nome, cognome, codiceFiscale, annoNascita, attrAtleta1, attrAtleta2);
        studente = new Studente(nome, cognome, codiceFiscale, annoNascita, attrStudente1, attrStudente2);
    }

    @Override
    public void trovaSconto() {
        super.trovaSconto();
        studente.trovaSconto();
        atleta.trovaSconto();
    }

    @Override
    public String toString() {
        return super.toString() + studente.getAttributo1() + " " + studente.decodificaAttributo2() + " " + atleta.getAttributo1() + " " + atleta.decodificaAttributo2();
    }
}
