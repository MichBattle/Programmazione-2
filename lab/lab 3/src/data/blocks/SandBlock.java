package data.blocks;

import data.blocks.interfaces.DustBlock;

public class SandBlock extends AbstractBlock implements DustBlock {
    public SandBlock() {
        super();
        this.contenuto = 'S';
        this.falls_with_gravity = true;
        this.fall_through = false;
        this.blockName = "Sand";
        this.pickable = true;
    }
}
