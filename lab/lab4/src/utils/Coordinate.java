package utils;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Controlla che le coordinate inserite non vadano fuori dai bounds
     * @param x
     * @param y
     */
    public void checkCoords(int x, int y) throws WrongCoordinatesException {
        if(x > this.x-1 || y > this.y-1 || y < 0 || x < 0)
            throw new WrongCoordinatesException("MY ERROR: coordinates not valid\n");
    }
}
