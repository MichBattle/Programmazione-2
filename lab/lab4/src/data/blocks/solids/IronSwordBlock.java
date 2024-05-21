package data.blocks.solids;

import data.blocks.AbstractBlock;
import data.blocks.interfaces.IronSwordInterface;

class IronSwordBlock extends AbstractBlock implements IronSwordInterface {
    public IronSwordBlock() {
        super();
        this.contenuto = 'Z';
        this.blockName = "Sword";
    }
}
