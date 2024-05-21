package visual.textual;

import data.blocks.interfaces.Block;
import data.blocks.NullBlock;
import data.blocks.interfaces.SmeltableBlock;

import javax.swing.plaf.RootPaneUI;

public class Furnace{
    private SmeltableBlock input;
    private Block output;

    /**
     * crea la fornace vuota
     */
    public Furnace() {
        this.input = new NullBlock();
        this.output = new NullBlock();
    }

    /**
     * Inserisce l'oggetto nella fornace e lo smelta
     * @param b
     */
    public void setInput(SmeltableBlock b){
        input = b;
        output = b.smelt();
    }

    /**
     * Smelta l'input mettendolo nell'output e imposta l'input a nullblock
     */
    public Block smelt(){
        if (!(input instanceof NullBlock)) {
            Block r = output;
            this.reset_furnace();
            return r;
        }
        return input;
    }

    /**
     * ritorna l'input della fornace
     * @return furnace input
     */
    public SmeltableBlock getInput() {
        return input;
    }

    /**
     * ritorna l'output della fornace
     * @return furnace output
     */
    public Block getOutput() {
        return output;
    }

    /**
     * imposta l'input della fornace a nullBlock
     * @return furnace input before null
     */
    public SmeltableBlock removeInput(){
        SmeltableBlock b = input;
        input = new NullBlock();
        return b;
    }

    /**
     * resetta la fornace a nullBlocks
     */
    private void reset_furnace(){
        this.input = new NullBlock();
        this.output = new NullBlock();
    }
}