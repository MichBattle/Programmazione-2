package Model;

import java.util.Date;

public abstract class Medicina {
    private String name;
    private int price;
    private Date dataScadenza;
    private int prezzoScontato;

    public Medicina(String name, int price, Date dataScadenza) {
        this.name = name;
        this.price = price;
        this.dataScadenza = dataScadenza;
        this.prezzoScontato = price;
    }

    public int getPrezzoScontato() {
        return prezzoScontato;
    }

    public String getName() {
        return name;
    }

    public void calcolaPrezzoScontato(int sconto){
        this.prezzoScontato = price - sconto;
    }

    public boolean isScaduto() {
        Date oggi = new Date();
        return oggi.after(dataScadenza);
    }

    private String scad(){
        if(isScaduto())
            return "scaduto";
        else
            return "scadenza: " + dataScadenza;
    }

    public String toString(){
        return name + "\n" +
                "costo base: " + price + ", Scontato: " + prezzoScontato + "\n" +
                scad() + "\n";
    }
}