package visual;

import data.blocks.*;
import data.blocks.interfaces.Block;
import data.blocks.interfaces.DustBlock;
import data.blocks.solids.TorchBlock;
import utils.BlockErrorException;
import utils.WrongCoordinatesException;

public class Mappa {
    private Block[][] map;
    private int x;
    private int y;

    /**
     * Inizializza la mappa con il fiume e blocchi di aria
     * @param x, y
     */
    public Mappa(int x, int y) throws BlockErrorException, WrongCoordinatesException {
        this.x = x;
        this.y = y;
        map = new AbstractBlock[x][y];
        for(int i = 0; i < x; i++){
            for(int k = 0; k < y; k++){
                map[i][k] = new AirBlock();
            }
        }

        addSea();
    }

    /**
     * Cambia il valore di un blocco nelle coordinate inserite
     * @param x
     * @param y
     */
    public void change_cell(int x, int y) throws BlockErrorException, WrongCoordinatesException {
        checkCoords(x, y);
        map[x][y].setContenuto('A');
    }

    /**
     * Scambia il valore del blocco nelle coordinate inserite con quello del blocco sotto
     * @param x
     * @param y
     */
//    public void swap(int x, int y) throws BlockErrorException, WrongCoordinatesException {
//        checkCoords(x, y);
//        if(checkOnGround(x, y)){ //controlla se il blocco da swappare è gia in terra
//            char temp = map[x][y].display_in_inventory();
//            map[x][y].setContenuto(map[x+1][y].display_in_inventory());
//            map[x+1][y].setContenuto(temp);
//        }
//    }

    /**
     * Inserisce un blocco nelle coordinate
     * se il blocco cade con la gravita allora lo fa cadere
     * @param b
     * @param x
     * @param y
     */
    public void insert_at_coords(Block b, int x, int y) throws BlockErrorException, WrongCoordinatesException {
        checkCoords(x, y);
        map[x][y] = b;
        if(b.isFalls_with_gravity())
            cadi(x, y);
    }

    /**
     * Fa cadere il blocco fino a quando arriva in terra o fino a quando sotto ha un blocco che non cade
     * @param x
     * @param y
     */
//    public void cadi(int x, int y, boolean inWater) throws BlockErrorException, WrongCoordinatesException {
//        checkCoords(x, y);
//        boolean s = true;
//        while(checkOnGround(x, y) && map[x+1][y].isFall_through()){ //il blocco cade se non è in terra e se sotto ha un blocco attraversabile
//            //se cade un oggetto nel blocco d'acqua, il livello non si deve alzare su quella colonna, deve solo sparire il blocco d'acqua, risolvo con l'if
//            //se inserisco in un blocco d'acqua poi swappa e rimane W-A-S invece che W-W-S, risolvo con inWater
//            if(map[x][y].display_in_inventory() != 'W' && map[x+1][y].display_in_inventory() == 'W' && s && !inWater){
//                map[x+1][y] = map[x][y];
//                map[x][y] = new AirBlock();
//                s = false;
//            }else
//                swap(x, y);
//
//            x++;
//        }
//    }

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
    private void addRowsOfWater() throws BlockErrorException, WrongCoordinatesException {
        for(int i = 0; i < y; i++){
            insert_at_coords(new WaterBlock(), 0, i);
        }
    }

    /**
     * aggiunge 3 righe di acqua
     */
    public void addSea() throws BlockErrorException, WrongCoordinatesException {
        for(int i = 0; i < 3; i++){
            addRowsOfWater();
        }
    }

    /**
     * aggiunge una riga di acqua
     */
    public void addRiver() throws BlockErrorException, WrongCoordinatesException {
        addRowsOfWater();
    }

    /**
     * ritorna il blocco presente nelle coordinate inserite
     * @param x
     * @param y
     * @return
     */
    public Block getBlock(int x, int y) throws BlockErrorException, WrongCoordinatesException {
        checkCoords(x, y);
        return map[x][y];
    }

    /**
     * Controlla che le coordinate inserite non vadano fuori dai bounds
     * @param x
     * @param y
     */
    public void checkCoords(int x, int y) throws WrongCoordinatesException {
        if(x > this.x-1 || y > this.y-1 || y < 0 || x < 0)
            throw new WrongCoordinatesException("Errore nelle coordinate inserite");
    }

    private boolean isPickable(int x, int y) throws BlockErrorException, WrongCoordinatesException {
        checkCoords(x, y);
        return getBlock(x, y).isPickable();
    }

    public Block gimme_pickable(int x, int y) throws BlockErrorException, WrongCoordinatesException {
        checkCoords(x, y);
        if(isPickable(x, y))
            return getBlock(x, y);
        else
            throw new BlockErrorException("Block in coords " + x + " " + y + " is not pickable");
    }

    public void display_map(){
        for(int i = 0; i < x; i++){
            for(int k = 0; k < y; k++){
                System.out.print(map[i][k].display_in_inventory() + "    ");
            }
            System.out.println("\n");
        }
        System.out.println("\n");
    }

    public int getX() {
        return x;
    }

    public void cadi(int x, int y) throws WrongCoordinatesException {
        int row = x;
        int col = y;
        if (row == this.x - 1){
            return;
        }
        if(this.map[row+1][col] instanceof TorchBlock && this.map[row][col] instanceof DustBlock)
            this.map[row][col] = new AirBlock();
        if (!this.map[row][col].isFalls_with_gravity()){
            return;
        }
        if (!this.map[row+1][col].isFall_through()){
            return;
        }
        else{
            this.swap(x, y);
            this.cadi(x+1, y);
        }

    }

    // precondition: row and col are valid, and so are for the next
    private void swap(int x, int y) throws WrongCoordinatesException {
        checkCoords(x, y);
        int row = x;
        int col = y;
        Block b = this.map[row][col];
        this.map[row][col] = this.map[row+1][col];
        this.map[row+1][col] = b;
    }

}
