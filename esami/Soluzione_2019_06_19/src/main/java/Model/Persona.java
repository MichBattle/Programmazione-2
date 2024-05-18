package Model;

public abstract class Persona {
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private String annoNascita;
    private double prezzoAbbonamento;
    private double sconto;

    public Persona(String nome, String cognome, String codiceFiscale, String annoNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.annoNascita = annoNascita;
        prezzoAbbonamento = 1000;
        trovaSconto();
        prezzoAbbonamento -= prezzoAbbonamento*sconto;
    }

    public double getSconto() {
        return sconto;
    }

    public void setSconto(double sconto) {
        this.sconto = sconto;
    }

    public void trovaSconto(){
        //sconto senior
        if(Integer.parseInt(annoNascita) < 1968){
            sconto = 0.35;
        }
    }

    //@Override
    public String toString(){
        return cognome + " " + nome + " " + codiceFiscale + " " + annoNascita;
    }
}
