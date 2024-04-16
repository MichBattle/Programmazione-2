package model;

import model.enums.Motore;

public abstract class Auto {
    private final static int SCONTO_IBRIDE = 5000;

    private static int identificatore = 1;
    private int id;
    private String modello;
    private int cilindrata;
    private Motore m;
    private String anno;
    private double prezzoBase;
    private int meseEsposizione;
    private double prezzoVendita;

    public Auto(String modello, int cilindrata, Motore m, String anno, double prezzoBase, int meseEsposizione) {
        this.modello = modello;
        this.cilindrata = cilindrata;
        this.m = m;
        this.anno = anno;
        this.prezzoBase = prezzoBase;
        this.meseEsposizione = meseEsposizione;
        this.id = identificatore;
        identificatore++;
    }

    public double getPrezzoBase() {
        return prezzoBase;
    }

    public void setPrezzoVendita(double prezzoVendita) {
        this.prezzoVendita = prezzoVendita;
    }

    public int getMeseEsposizione() {
        return meseEsposizione;
    }

    public int getId() {
        return id;
    }

    public String getAnno() {
        return anno;
    }

    public double scontaIbrido(){
        if(m.equals(Motore.Ibrido))
            return prezzoVendita - SCONTO_IBRIDE;
        else
            return prezzoVendita;
    }

    @Override
    public String toString() {
        return "id= " + id + "\n" +
                "tipologia= " + this.getClass().getSimpleName() + "\n" +
                "modello= " + modello + "\n" +
                "cilindrata= " + cilindrata + "\n" +
                "motore= " + m + "\n" +
                "anno= " + anno + "\n" +
                "prezzo base= " + prezzoBase + "\n" +
                "prezzo vendita= " + prezzoVendita + "\n" +
                "esposto= " + meseEsposizione + "\n";
    }

    public abstract double calcolaPrezzoVendita();
}
