package Controller.Ventilators;

import Controller.Alimentazione;

public abstract class Ventilatore {
    private String marca;
    private int costo;
    private Alimentazione alim;
    private int aumento;
    private boolean abbonato;

    public Ventilatore(String marca, Alimentazione alim, int aumento) {
        this.marca = marca;
        this.alim = alim;
        this.aumento = aumento;
        abbonato = false;
        calcolaCosto();
    }

    public boolean isAbbonato() {
        return abbonato;
    }

    public void setAbbonato(boolean abbonato) {
        this.abbonato = abbonato;
    }

    public String getMarca() {
        return marca;
    }

    public Alimentazione getAlim() {
        return alim;
    }

    public int getCosto() {
        return costo;
    }

    public int calcolaMoltiplicatore(){
        int mult = 0;
        if(alim.equals(Alimentazione.Meccanico))
            mult = 1;
        else if(alim.equals(Alimentazione.Presa))
            mult = 2;
        else if(alim.equals(Alimentazione.Batteria))
            mult = 3;
        return mult;
    }

    public void calcolaCosto(){
        costo = (10 + aumento)*calcolaMoltiplicatore();
    }

    @Override
    public String toString() {
        return marca + "\n";
    }
}
