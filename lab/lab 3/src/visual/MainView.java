package visual;

import data.blocks.AirBlock;
import data.blocks.NullBlock;
import data.blocks.interfaces.Block;
import data.blocks.interfaces.CheckIndex;
import data.blocks.interfaces.SmeltableBlock;
import utils.BlockErrorException;
import utils.WrongCoordinatesException;

public class MainView implements CheckIndex {
    private Mappa m;
    private Furnace f;
    private Inventario i;

    public MainView(int x, int y) throws BlockErrorException, WrongCoordinatesException {
        this.m = new Mappa(x, y);
        this.f = new Furnace();
        this.i = new Inventario();
    }

    /**
     * stampa la mappa
     */
    public void display_map(){
        System.out.println("MAP:");
        m.display_map();
    }

    /**
     * stampa il contenuto della fornace
     */
    public void display_furnace(){
        System.out.println("FURNACE:");
        System.out.println("|| " +
                f.getInput().display_in_inventory() + " --> " +
                f.getOutput().display_in_inventory() + " ||");
        System.out.println("\n");
    }

    /**
     * stampa l'inventario
     */
    public void display_inventory(){
        System.out.println("INVENTORY:");
        i.display_inventory();
        System.out.println("\n");
    }

    /**
     * sposta nella fornace il blocco delle coordinate inserite
     * @param x
     * @param y
     */
    public void move_into_furnace(int x, int y) throws BlockErrorException, WrongCoordinatesException {
        if(m.getBlock(x, y) instanceof SmeltableBlock){
            f.setInput((SmeltableBlock)m.getBlock(x, y));
            m.insert_at_coords(new AirBlock(), x, y);
        }else
            throw new BlockErrorException("nella posizione scelta non c'è uno smeltable block");
    }

    public void smelt(){
        f.smelt();
        i.add_block(f.getInput());
    }

    /**
     * inserisce un blocco
     * @param b
     * @param x
     * @param y
     * @throws WrongCoordinatesException
     */
    public void insert(Block b, int x, int y) throws WrongCoordinatesException {
        m.insert_at_coords(b, x, y);
    }

    /**
     * sposta il blocco dalla fornace all'inventario
     */
    public void move_into_inventory_from_furnace(){
        i.add_block(f.removeInput());
    }

    /**
     * sposta il blocco dall'inventario alla fornace
     * @param index
     * @throws BlockErrorException
     * @throws WrongCoordinatesException
     */
    public void move_into_furnace_from_inventory(int index) throws BlockErrorException, WrongCoordinatesException {
        if(f.getInput() instanceof NullBlock){
            if(f.getOutput() instanceof NullBlock){
                f.setInput(i.get_smeltable_item(index)); //metto il blocco dell'inventario nella fornace
                i.remove_block(index); //tolgo il blocco dall'inventario
            }else
                throw new BlockErrorException("MY ERROR: Output of furnace is full");
        }else
            throw new BlockErrorException("MY ERROR: Input of furnace is full");
    }

    /**
     * raccoglie un blocco
     * @param x
     * @param y
     * @throws WrongCoordinatesException
     */
    public void pick_up_block(int x, int y) throws WrongCoordinatesException {
        i.add_block(m.gimme_pickable(x, y));//aggiungo all'inventario
        m.insert_at_coords(new AirBlock(), x, y);
        int z = x;
        while(z > 0){
            m.cadi(z-1, y);
            z--;
        }
    }

    /**
     * cambia il comparatore dell'inventario
     */
    public void change_inventory_comparator(){
        i.change_comparator();
    }

    /**
     * ordina l'inventario
     */
    public void sort_inventory(){
        i.sort_inventory();
    }

//    public void slash_give(Block b){
//        i.add_block(b);
//    }
}
