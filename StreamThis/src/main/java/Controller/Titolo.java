package Controller;

public abstract class Titolo {
    private String nome;
    private String anno;
    private String lingua;
    private double prezzo;
    private double prezzoScontato;

    public Titolo(String nome, String anno, String lingua, double prezzo) {
        this.nome = nome;
        this.anno = anno;
        this.lingua = lingua;
        this.prezzo = prezzo;
        prezzoScontato = calcolaPrezzoScontato();
    }

    public double getPrezzoScontato() {
        return prezzoScontato;
    }

    public void setPrezzoScontato(double prezzoScontato) {
        this.prezzoScontato = prezzoScontato;
    }

    public double calcolaPrezzoScontato(){
        double ps;
        if(Integer.parseInt(anno) < 2015){
            ps = prezzo - prezzo*0.1;
        }else
            ps = prezzo;
        return ps;
    }

    public String getNome() {
        return nome;
    }

    public String getAnno() {
        return anno;
    }

    public String toString(){
        return "Titolo: " + nome + "\n" +
                "Anno: " + anno + "\n" +
                "Lingua: " + lingua + "\n" +
                "Prezzo base: " + prezzo + "€";
    }
}
