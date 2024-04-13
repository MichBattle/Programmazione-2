package visual.textual;

import data.blocks.interfaces.Block;
import data.blocks.interfaces.CheckIndex;
import data.blocks.interfaces.SmeltableBlock;
import data.blocks.utils.AlphabeticalBlockComparator;
import data.blocks.utils.BlockComparator;
import utils.BlockErrorException;
import utils.WrongCoordinatesException;

import java.util.ArrayList;
import java.util.Comparator;

public class Inventario implements CheckIndex {
    ArrayList<Block> inv;
    Comparator<Block> c;

    public Inventario() {
        inv = new ArrayList<>();
        c = new AlphabeticalBlockComparator();
    }

    /**
     * aggiunge un blocco all'inventario
     * @param b
     */
    public void add_block(Block b){
        inv.add(b);
    }

    /**
     * controlla se il blocco è smeltable
     * @param index
     * @return if block is smeltable
     */
    private boolean isSmeltable(int index){
        return inv.get(index) instanceof SmeltableBlock;
    }

    /**
     * prende l'oggetto di posizione index smeltabile (se non è smeltable lancia un eccezione)
     * @param index
     * @return smeltable block in index
     * @throws BlockErrorException
     * @throws WrongCoordinatesException
     */
    public SmeltableBlock get_smeltable_item(int index) throws BlockErrorException, WrongCoordinatesException {
        if(isSmeltable(index)) {
            if(checkIndex(index))
                return (SmeltableBlock) inv.get(index);
            else
                return null;
        }
        else
            throw new BlockErrorException("MY ERROR: Block in index " + index + " is not smeltable\n");
    }

    /**
     * stampa l'inventario
     */
    public void display_inventory(){
        for (Block block : inv) {
            System.out.print(block.display_in_inventory() + " | ");
        }
    }

    /**
     * controlla che l'indice inserito sia corretto
     * @param index
     * @return
     * @throws WrongCoordinatesException
     */
    public boolean checkIndex(int index) throws WrongCoordinatesException {
        if (index < inv.size() && index >= 0)
            return true;
        else
            throw new WrongCoordinatesException("MY ERROR: index " + index + " is out of bounds\n");
    }

    /**
     * rimuove il blocco in index nell'inventario
     * @param index
     */
    public void remove_block(int index){
        inv.remove(index);
    }

    /**
     * cambia il comparatore da alfabetico a block e viceversa
     */
    public void change_comparator(){
        if(c instanceof AlphabeticalBlockComparator)
            c = new BlockComparator();
        else
            c = new AlphabeticalBlockComparator();
    }

    /**
     * ordina l'inventario in base al comparatore
     */
    public void sort_inventory(){
        if(c instanceof AlphabeticalBlockComparator)
            System.out.println("sorting array in alphabetical order");
        else if(c instanceof BlockComparator)
            System.out.println("sorting array in block order");
        inv.sort(c);
    }
}
