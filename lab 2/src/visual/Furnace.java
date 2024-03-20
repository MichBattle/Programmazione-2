package visual;

import data.blocks.interfaces.Block;
import data.blocks.NullBlock;
import data.blocks.interfaces.SmeltableBlock;

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
     * inserisce l'oggetto nella fornace e lo smelta
     * @param b
     */
    public void setInput(SmeltableBlock b){
        input = b;
        output = b.smelt();
    }

    /**
     * smelta l'input mettendolo nell'output e imposta l'input a nullblock
     */
    public void smelt(){
        output = input.smelt();
        input = new NullBlock();
    }

    public SmeltableBlock getInput() {
        return input;
    }

    public Block getOutput() {
        return output;
    }
}