package Controller.Ventilators;

import Controller.Alimentazione;

public class Soffitto extends Ventilatore {
    public Soffitto(String marca, Alimentazione alim) throws Exception {
        super(marca, alim, 2);
        checkAlim(alim);
    }

    private void checkAlim(Alimentazione alim) throws Exception {
        if(alim.equals(Alimentazione.Meccanico)){
            throw new Exception("alimentatore a soffitto non può essere ad alimentazione meccanica\n");
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "Tipo: " + this.getClass().getSimpleName() + " Alimentazione: " + super.getAlim() + "\n" +
                "Costo: " + super.getCosto();
    }
}
