package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RicettaUtente {
    private Medicina m;
    private Date dataScadenza;

    public RicettaUtente(Medicina m, Date dataScadenza) {
        this.m = m;
        this.dataScadenza = dataScadenza;
    }

    public boolean isScaduto() {
        Date oggi = new Date();
        return oggi.after(dataScadenza);
    }

    public Medicina getMedicina() {
        return m;
    }

    private String scad(){
        if(isScaduto())
            return "scaduto";
        else
            return "valida fino al " + dataScadenza;
    }

    public String toString(){
        return "Ricetta per: " + m.getName() + "\n" +
                scad() + "\n";
    }
}
