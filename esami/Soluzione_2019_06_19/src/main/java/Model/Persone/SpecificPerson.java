package Model.Persone;

import Model.Persona;

public abstract class SpecificPerson extends Persona {
    private String attributo1;
    private boolean attributo2;

    public SpecificPerson(String nome, String cognome, String codiceFiscale, String annoNascita, String attributo1, boolean attributo2) {
        super(nome, cognome, codiceFiscale, annoNascita);
        this.attributo1 = attributo1;
        this.attributo2 = attributo2;
    }

    public String getAttributo1() {
        return attributo1;
    }

    public boolean isAttributo2() {
        return attributo2;
    }

    public abstract String decodificaAttributo2();

    //@Override
    public String toString() {
        return super.toString() + " " + attributo1 + " " + decodificaAttributo2();
    }
}
