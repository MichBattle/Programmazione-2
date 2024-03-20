package visual;

import data.blocks.AirBlock;
import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;
import utils.Coordinate;

public class MainView {
    private Mappa m;
    private Furnace f;

    public MainView(int x, int y) {
        this.m = new Mappa(x, y);
        this.f = new Furnace();
    }

    /**
     * stampa la mappa
     */
    public void printMappa(){
        for(int i = 0; i < m.getX(); i++){
            for(int k = 0; k < m.getY(); k++){
                System.out.print(m.getBlock(i, k).display() + "    ");
            }
            System.out.println("\n");
        }
        System.out.println("\n");
    }

    /**
     * stampa il contenuto della fornace
     */
    public void printFornace(){
        System.out.println("|| " +
                f.getInput().display() + " --> " +
                f.getOutput().display() + " ||");
    }

    /**
     * sposta nella fornace il blocco delle coordinate inserite
     * @param x
     * @param y
     */
    public void move_into_furnace(int x, int y) {
        if(m.getBlock(x, y) instanceof SmeltableBlock){
            f.setInput((SmeltableBlock)m.getBlock(x, y));
            m.insert_at_coords(new AirBlock(), x, y);
        }else{
            System.err.println("nella posizione scelta non c'è uno smeltable block");
        }
    }

    public void insert(Block b, int x, int y){
        m.insert_at_coords(b, x, y);
    }
}
