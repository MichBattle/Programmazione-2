package Model;

public class Carta {
    private int valore;
    private Semi seme;

    public Carta(int valore, Semi seme) {
        this.valore = valore;
        this.seme = seme;
    }

    public int getValore() {
        return valore;
    }

    public Semi getSeme() {
        return seme;
    }

    @Override
    public String toString() {
        return valore + "-" + seme;
    }
}
