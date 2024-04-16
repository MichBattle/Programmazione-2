package model;

import model.enums.Accessorio;
import model.enums.Motore;

import java.util.HashSet;

public class Sportiva extends Auto{
    private HashSet<Accessorio> accessori;

    public Sportiva(String modello, int cilindrata, Motore m, String anno, double prezzoBase, int meseEsposizione) {
        super(modello, cilindrata, m, anno, prezzoBase, meseEsposizione);
        this.setPrezzoVendita(calcolaPrezzoVendita());
        super.scontaIbrido();
        accessori = new HashSet<>();
    }

    public void addAccessorio(Accessorio a){
        accessori.add(a);
    }

    @Override
    public double calcolaPrezzoVendita() {
        return super.getPrezzoBase();
    }

    @Override
    public String toString() {
        return super.toString() + "accessori in offerta: " + accessori.toString() + "\n";
    }
}
