package visual.textual;

import data.blocks.*;
import data.blocks.interfaces.Block;
import data.blocks.interfaces.DustBlock;
import data.blocks.solids.TorchBlock;
import utils.BlockErrorException;
import utils.WrongCoordinatesException;

public class Mappa {
    public static final int ROWS = 10;
    public static final int COLUMNS = 10;

    private Block[][] map;

    /**
     * Inizializza la mappa con il fiume e blocchi di aria
     */
    public Mappa() throws WrongCoordinatesException {
        map = new AbstractBlock[ROWS][COLUMNS];
        for(int i = 0; i < ROWS; i++){
            for(int k = 0; k < COLUMNS; k++){
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
    public void change_cell(int x, int y) throws WrongCoordinatesException {
        checkCoords(x, y);
        map[x][y].setContenuto('A');
    }

    /**
     * Inserisce un blocco nelle coordinate
     * se il blocco cade con la gravita allora lo fa cadere
     * @param b
     * @param x
     * @param y
     */
    public void insert_at_coords(Block b, int x, int y) throws WrongCoordinatesException {
        checkCoords(x, y);
        map[x][y] = b;
        if(b.isFalls_with_gravity())
            cadi(x, y);
    }

    /**
     * inserisce una riga di acqua in cima
     */
    private void addRowsOfWater() throws WrongCoordinatesException {
        for(int i = 0; i < COLUMNS; i++){
            insert_at_coords(new WaterBlock(), 0, i);
        }
    }

    /**
     * aggiunge 3 righe di acqua
     */
    public void addSea() throws WrongCoordinatesException {
        for(int i = 0; i < 3; i++){
            addRowsOfWater();
        }
    }

    /**
     * aggiunge una riga di acqua
     */
    public void addRiver() throws WrongCoordinatesException {
        addRowsOfWater();
    }

    /**
     * ritorna il blocco presente nelle coordinate inserite
     * @param x
     * @param y
     * @return
     */
    public Block getBlock(int x, int y) throws WrongCoordinatesException {
        checkCoords(x, y);
        return map[x][y];
    }

    /**
     * Controlla che le coordinate inserite non vadano fuori dai bounds
     * @param x
     * @param y
     */
    public void checkCoords(int x, int y) throws WrongCoordinatesException {
        if(x > ROWS-1 || y > COLUMNS-1 || y < 0 || x < 0)
            throw new WrongCoordinatesException("Errore nelle coordinate inserite");
    }

    /**
     * ritorna se il blocco è raccoglibile
     * @param x
     * @param y
     * @return
     * @throws BlockErrorException
     * @throws WrongCoordinatesException
     */
    private boolean isPickable(int x, int y) throws WrongCoordinatesException {
        checkCoords(x, y);
        return getBlock(x, y).isPickable();
    }

    /**
     * ritorna un blocco raccoglibile
     * @param x
     * @param y
     * @return pickable block
     * @throws BlockErrorException
     * @throws WrongCoordinatesException
     */
    public Block gimme_pickable(int x, int y) throws WrongCoordinatesException{
        checkCoords(x, y);
        if(isPickable(x, y))
            return getBlock(x, y);
        else
            throw new WrongCoordinatesException("Block in coords " + x + " " + y + " is not pickable");
    }

    /**
     * stampa la mappa
     */
    public void display_map(){
        for(int i = 0; i < ROWS; i++){
            for(int k = 0; k < COLUMNS; k++){
                System.out.print(map[i][k].display_in_inventory() + "    ");
            }
            System.out.println("\n");
        }
        System.out.println("\n");
    }

    /**
     * fa cadere un blocco
     * @param x
     * @param y
     * @throws WrongCoordinatesException
     */
    public void cadi(int x, int y) throws WrongCoordinatesException {
        int row = x;
        int col = y;
        if (row == ROWS - 1){
            return;
        }
        if(this.map[row+1][col] instanceof TorchBlock && this.map[row][col] instanceof DustBlock) //se sotto c'è torch ed è gravel o sabbia si rompe il blocco
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

    /**
     * scambia due blocchi
     * @param x
     * @param y
     * @throws WrongCoordinatesException
     */
    private void swap(int x, int y) throws WrongCoordinatesException {
        checkCoords(x, y);
        int row = x;
        int col = y;
        Block b = this.map[row][col];
        this.map[row][col] = this.map[row+1][col];
        this.map[row+1][col] = b;
    }

}
