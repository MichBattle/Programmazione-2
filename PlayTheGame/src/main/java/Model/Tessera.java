package Model;

public abstract class Tessera {
    private boolean scoperta;
    private String valore;

    public Tessera(String valore) {
        this.scoperta = false;
        this.valore = valore;
    }

    public void setValore(String valore) {
        this.valore = valore;
    }

    public String getValore() {
        return valore;
    }

    public boolean isScoperta() {
        return scoperta;
    }

    public void setScoperta(boolean scoperta) {
        this.scoperta = scoperta;
    }

    public abstract void scopri();

    public abstract void nascondi();

    @Override
    public String toString() {
        return valore;
    }
}
