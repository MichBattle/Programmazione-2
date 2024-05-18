package Model.Persone;

public class Studente extends SpecificPerson{
    public Studente(String nome, String cognome, String codiceFiscale, String annoNascita, String universita, boolean isTriennale) {
        super(nome, cognome, codiceFiscale, annoNascita, universita, isTriennale);
    }

    @Override
    public void trovaSconto() {
        super.trovaSconto();
        //sconto studenti

        double nuovoSconto;
        if(isAttributo2())
            nuovoSconto = 0.4;
        else
            nuovoSconto = 0.2;

        //prendo sconto maggiore
        if(nuovoSconto > getSconto()){
            setSconto(nuovoSconto);
        }
    }

    @Override
    public String decodificaAttributo2() {
        return (isAttributo2())? "LT" : "LM";
    }
}
