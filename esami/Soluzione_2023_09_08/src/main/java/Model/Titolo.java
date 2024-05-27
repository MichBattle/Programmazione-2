package Model;

public abstract class Titolo {
    private String titolo;
    private String anno;
    private String lingua;
    private double prezzoBase;

    private double prezzoScontato;

    public Titolo(String titolo, String anno, String lingua, double prezzoBase) {
        this.titolo = titolo;
        this.anno = anno;
        this.lingua = lingua;
        this.prezzoBase = prezzoBase;
        prezzoScontato = prezzoBase;
        prezzoScontato = calcolaSconto();
    }

    public String getAnno() {
        return anno;
    }

    public String getTitolo() {
        return titolo;
    }

    public double calcolaSconto(){
        double sconto = 0;
        if(Integer.parseInt(anno) < 2015)
            sconto = 0.1;
        return prezzoBase - prezzoBase*sconto;
    }

    public double getPrezzoScontato() {
        return prezzoScontato;
    }

    public void setPrezzoScontato(double prezzoScontato) {
        this.prezzoScontato = prezzoScontato;
    }

    public void resetPrezzo(){
        prezzoScontato = calcolaSconto();
    }

    @Override
    public String toString() {
        return  "     Titolo: " + titolo + "\n" +
                "    Anno: " + anno + "\n" +
                "   Lingua: " + lingua + "\n" +
                "Prezzo base: " + prezzoBase + "€";
    }
}
