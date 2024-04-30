package Controller.Ventilators;

import Controller.Alimentazione;

public class Piantana extends Ventilatore {
    public Piantana(String marca, Alimentazione alim) {
        super(marca, alim, 10);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Tipo: " + this.getClass().getSimpleName() + " Alimentazione: " + super.getAlim() + "\n" +
                "Costo: " + super.getCosto();
    }
}
