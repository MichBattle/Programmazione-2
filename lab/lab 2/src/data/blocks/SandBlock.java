package data.blocks;

import data.blocks.AbstractBlock;

public class SandBlock extends AbstractBlock {
    public SandBlock() {
        super();
        this.contenuto = 'S';
        this.falls_with_gravity = true;
        this.fall_through = false;
        this.blockName = "Sand";
    }
}
