package Controller.Ventilators;

import Controller.Alimentazione;

public class Parete extends Ventilatore {
    public Parete(String marca, Alimentazione alim) {
        super(marca, alim, 20);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Tipo: " + this.getClass().getSimpleName() + " Alimentazione: " + super.getAlim() + "\n" +
                "Costo: " + super.getCosto();
    }
}
