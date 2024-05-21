package data.blocks.solids;

import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;
import data.blocks.solids.AbstractSolidBlock;
import data.blocks.solids.IronSwordBlock;

public class RawIronBlock extends AbstractSolidBlock implements SmeltableBlock {
    public RawIronBlock() {
        super();
        this.contenuto = 'F';
        this.blockName = "Iron";
    }

    @Override
    public Block smelt() {
        return new IronSwordBlock();
    }
}
