package model;

import model.enums.Motore;

public class Utilitaria extends Auto{

    public Utilitaria(String modello, int cilindrata, Motore m, String anno, double prezzoBase, int meseEsposizione) {
        super(modello, cilindrata, m, anno, prezzoBase, meseEsposizione);
        this.setPrezzoVendita(calcolaPrezzoVendita());
        super.scontaIbrido();
    }

    @Override
    public double calcolaPrezzoVendita() {
        return getPrezzoBase()-getPrezzoBase()*0.05;
    }
}
