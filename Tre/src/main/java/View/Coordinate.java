package View;

public class Coordinate {
    private int x;
    private boolean isRiga;

    public Coordinate(int x, boolean isRiga) {
        this.x = x;
        this.isRiga = isRiga;
    }

    public int getX() {
        return x;
    }

    public boolean isRiga() {
        return isRiga;
    }
}
