package Model;

public class Coordinate {
    private boolean isRiga;
    private int coordinata;

    public Coordinate(boolean isRiga, int coordinata) {
        this.isRiga = isRiga;
        this.coordinata = coordinata;
    }

    public boolean isRiga() {
        return isRiga;
    }

    public int getCoordinata() {
        return coordinata;
    }
}
