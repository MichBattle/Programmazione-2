package model;

import model.enums.Motore;

import java.util.Calendar;

public class Berlina extends Auto{
    public Berlina(String modello, int cilindrata, Motore m, String anno, double prezzoBase, int meseEsposizione) {
        super(modello, cilindrata, m, anno, prezzoBase, meseEsposizione);
        this.setPrezzoVendita(calcolaPrezzoVendita());
        super.scontaIbrido();
    }

    @Override
    public double calcolaPrezzoVendita() {
        double sconto = 0.01;
        int meseCorrente = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int mesiEsposizione = meseCorrente - super.getMeseEsposizione();

        if(mesiEsposizione >= 5)
            sconto *= 5;
        else if(mesiEsposizione > 0)
            sconto *= mesiEsposizione;

        return getPrezzoBase()-getPrezzoBase()*sconto;
    }
}
