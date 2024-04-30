package Controller;

public class Stats {
    private int capitale;
    private int spesaMensile;
    private int mesiTrascorsi;

    public Stats() {
        this.capitale = 100;
        this.spesaMensile = 0;
        this.mesiTrascorsi = 0;
    }

    public int getCapitale() {
        return capitale;
    }

    public int getSpesaMensile() {
        return spesaMensile;
    }

    public int getMesiTrascorsi() {
        return mesiTrascorsi;
    }

    public void setCapitale(int capitale) {
        this.capitale = capitale;
    }

    public void setSpesaMensile(int spesaMensile) {
        this.spesaMensile = spesaMensile;
    }

    public void setMesiTrascorsi(int mesiTrascorsi) {
        this.mesiTrascorsi = mesiTrascorsi;
    }
}
