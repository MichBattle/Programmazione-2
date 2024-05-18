package Model.Persone;

public class Atleta extends SpecificPerson {
    public Atleta(String nome, String cognome, String codiceFiscale, String annoNascita, String disciplina, boolean isNazionale) {
        super(nome, cognome, codiceFiscale, annoNascita, disciplina, isNazionale);
    }

    @Override
    public void trovaSconto() {
        super.trovaSconto();
        //sconto atleti

        double nuovoSconto;
        if(isAttributo2())
            nuovoSconto = 0.3;
        else
            nuovoSconto = 0.5;

        //prendo sconto maggiore
        if(nuovoSconto > getSconto()){
            setSconto(nuovoSconto);
        }
    }

    @Override
    public String decodificaAttributo2() {
        return (isAttributo2())? "nazionale" : "internazionale";
    }
}
