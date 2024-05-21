package data.blocks;

import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;
import data.blocks.solids.AbstractSolidBlock;

public class NullBlock extends AbstractSolidBlock implements SmeltableBlock {
    public NullBlock() {
        super();
        this.contenuto = ' ';
        this.blockName = "null";
    }

    /**
     * smelta il blocco
     * @return
     */
    @Override
    public Block smelt() {
        return new NullBlock();
    }
}
