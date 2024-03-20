package data;

public class Mappa {
    private AirBlock[][] map;
    private int x;
    private int y;

    /**
     * inizializza la mappa a default
     * @param x
     * @param y
     */
    public Mappa(int x, int y) {
        this.x = x;
        this.y = y;
        map = new AirBlock[x][y];
        for(int i = 0; i < x; i++){
            for(int k = 0; k < y; k++){
                map[i][k] = new AirBlock();
            }
        }
    }

    /**
     * stampa la mappa
     */
    public void display_on_out() {
        for(int i = 0; i < x; i++){
            for(int k = 0; k < y; k++){
                System.out.print(map[i][k].display() + "    ");
            }
            System.out.println("\n");
        }
        System.out.println("\n");
    }

    /**
     * cambia il valore di un blocco nelle coordinate inserite
     * @param x
     * @param y
     * @throws Exception
     */
    public void change_cell(int x, int y) throws Exception {
        checkCoords(x, y);
        map[x][y].setContenuto('A');
    }

    /**
     * scambia il valore del blocco nelle coordinate inserite con quello del blocco sotto
     * @param x
     * @param y
     * @throws Exception
     */
    public void swap(int x, int y) throws Exception {
        checkCoords(x, y);
        if(checkOnGround(x, y)){ //controlla se il blocco da swappare è gia in terra
            char temp = map[x][y].display();
            map[x][y].setContenuto(map[x+1][y].display());
            map[x+1][y].setContenuto(temp);
        }
    }

    /**
     * inserisce un blocco nelle coordinate
     * se il blocco cade con la gravita allora lo fa cadere
     * @param b
     * @param x
     * @param y
     * @throws Exception
     */
    public void insert_at_coords(AirBlock b, int x, int y) throws Exception {
        checkCoords(x, y);
        map[x][y] = b;
        if(b.isFalls_with_gravity())
            cadi(x, y);
    }

    /**
     * fa cadere il blocco fino a quando arriva in terra o fino a quando sotto ha un blocco che non cade
     * @param x
     * @param y
     * @throws Exception
     */
    private void cadi(int x, int y) throws Exception {
        checkCoords(x, y);
        while(checkOnGround(x, y) && map[x+1][y].isFall_through()){ //il blocco cade se sotto ha un blocco che cade
            swap(x, y);
            x++;
        }
    }

    /**
     * controlla che le coordinate inserite non vadano fuori dai bounds
     * @param x
     * @param y
     * @throws Exception
     */
    private void checkCoords(int x, int y) throws Exception {
        if(x > this.x-1 || y > this.y-1 || y < 0 || x < 0)
            throw new Exception("Errore nelle coordinate inserite");
    }

    /**
     * controlla se il blocco è a terra
     * @param x
     * @param y
     * @return
     */
    private boolean checkOnGround(int x, int y){
        boolean onGround = false;

        if(x + 1 != this.x)
            onGround = true;

        return onGround;
    }

}
