package Model;

public class Carta {
    private int valore;
    private Seme seme;

    public Carta(int valore, Seme seme) {
        checkValore(valore);
        this.valore = valore;
        this.seme = seme;
    }

    public int getValore() {
        return valore;
    }

    public Seme getSeme() {
        return seme;
    }

    private void checkValore(int val){
        if(val < 0 || val > 4)
            System.err.println("error on inserted value\n");
    }

    @Override
    public String toString() {
        return valore + "-" + seme;
    }
}