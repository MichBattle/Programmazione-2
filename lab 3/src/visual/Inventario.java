package visual;

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

    public void add_block(Block b){
        inv.add(b);
    }

    private boolean isSmeltable(int index){
        return inv.get(index) instanceof SmeltableBlock;
    }

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

    public void display_inventory(){
        for (Block block : inv) {
            System.out.print(block.display_in_inventory() + " | ");
        }
    }

    public boolean checkIndex(int index) throws WrongCoordinatesException {
        if (index < inv.size() && index >= 0)
            return true;
        else
            throw new WrongCoordinatesException("MY ERROR: index " + index + " is out of bounds\n");
    }

    public void remove_block(int index){
        inv.remove(index);
    }

    public void change_comparator(){
        if(c instanceof AlphabeticalBlockComparator)
            c = new BlockComparator();
        else
            c = new AlphabeticalBlockComparator();
    }

    public void sort_inventory(){
        if(c instanceof AlphabeticalBlockComparator)
            System.out.println("sorting array in alphabetical order");
        else if(c instanceof BlockComparator)
            System.out.println("sorting array in block order");
        inv.sort(c);
    }
}
