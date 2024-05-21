package visual;

import data.blocks.*;
import data.blocks.interfaces.Block;
import data.blocks.solids.RawIronBlock;
import utils.Coordinate;

import java.util.Random;

public class Mappa {
    private Block[][] map;
    private int x;
    private int y;

    /**
     * Inizializza la mappa con il fiume e blocchi di aria
     * @param x, y
     */
    public Mappa(int x, int y) {
        this.x = x;
        this.y = y;
        map = new AbstractBlock[x][y];
        for(int i = 0; i < x; i++){
            for(int k = 0; k < y; k++){
                map[i][k] = new AirBlock();
            }
        }
        try {
            addSea();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Random rand = new Random();
        for (int i = 0 ; i < 5; i++){

            Block b;
            if(i%2==0)
                b = new SandBlock();
            else
                b = new RawIronBlock();

            int row = rand.nextInt(x);
            int col = rand.nextInt(y);
            insert_at_coords(b, row, col);
        }
    }

    /**
     * Cambia il valore di un blocco nelle coordinate inserite
     * @param x
     * @param y
     */
    public void change_cell(int x, int y) {
        checkCoords(x, y);
        map[x][y].setContenuto('A');
    }

    /**
     * Scambia il valore del blocco nelle coordinate inserite con quello del blocco sotto
     * @param x
     * @param y
     */
    public void swap(int x, int y) {
        checkCoords(x, y);
        if(checkOnGround(x, y)){ //controlla se il blocco da swappare è gia in terra
            char temp = map[x][y].display();
            map[x][y].setContenuto(map[x+1][y].display());
            map[x+1][y].setContenuto(temp);
        }
    }

    /**
     * Inserisce un blocco nelle coordinate
     * se il blocco cade con la gravita allora lo fa cadere
     * @param b
     * @param x
     * @param y
     */
    public void insert_at_coords(Block b, int x, int y) {
        checkCoords(x, y);
        boolean inWater = getBlock(x, y).display() == 'W'; //controllo se inserisco nel blocco d'acqua
        map[x][y] = b;
        if(b.isFalls_with_gravity())
            cadi(x, y, inWater);
    }

    /**
     * Fa cadere il blocco fino a quando arriva in terra o fino a quando sotto ha un blocco che non cade
     * @param x
     * @param y
     */
    private void cadi(int x, int y, boolean inWater) {
        checkCoords(x, y);
        boolean s = true;
        while(checkOnGround(x, y) && map[x+1][y].isFall_through()){ //il blocco cade se non è in terra e se sotto ha un blocco attraversabile
            //se cade un oggetto nel blocco d'acqua, il livello non si deve alzare su quella colonna, deve solo sparire il blocco d'acqua, risolvo con l'if
            //se inserisco in un blocco d'acqua poi swappa e rimane W-A-S invece che W-W-S, risolvo con inWater
            if(map[x][y].display() != 'W' && map[x+1][y].display() == 'W' && s && !inWater){
                map[x+1][y] = map[x][y];
                map[x][y] = new AirBlock();
                s = false;
            }else
                swap(x, y);
            x++;
        }
    }

    /**
     * Controlla se il blocco è a terra
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

    /**
     * inserisce una riga di acqua in cima
     */
    private void addRowsOfWater() {
        for(int i = 0; i < y; i++){
            insert_at_coords(new WaterBlock(), 0, i);
        }
    }

    /**
     * aggiunge 3 righe di acqua
     */
    public void addSea() {
        for(int i = 0; i < 3; i++){
            addRowsOfWater();
        }
    }

    /**
     * aggiunge una riga di acqua
     */
    public void addRiver(){
        addRowsOfWater();
    }

    /**
     * ritorna il blocco presente nelle coordinate inserite
     * @param x
     * @param y
     * @return
     */
    public Block getBlock(int x, int y){
        return map[x][y];
    }

    /**
     * Controlla che le coordinate inserite non vadano fuori dai bounds
     * @param x
     * @param y
     */
    public void checkCoords(int x, int y) {
        if(x > this.x-1 || y > this.y-1 || y < 0 || x < 0)
            System.err.println("Errore nelle coordinate inserite");
    }

    /**
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * @return y
     */
    public int getY() {
        return y;
    }
}
