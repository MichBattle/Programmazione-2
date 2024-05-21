package data.blocks.utils;

import data.blocks.AirBlock;
import data.blocks.NullBlock;
import data.blocks.SandBlock;
import data.blocks.WaterBlock;
import data.blocks.interfaces.*;
import data.blocks.solids.*;

import java.util.Comparator;

public class BlockComparator implements Comparator<Block> {

    @Override
    public int compare(Block o1, Block o2) {
        return Integer.compare(this.get_value_of_block(o1),this.get_value_of_block(o2));
    }

    private int get_value_of_block(Block b){
        if (b instanceof NullBlock){
            return 0;
        }
        if (b instanceof AirBlock){
            return 1;
        }
        if (b instanceof WaterBlock){
            return 2;
        }
//        if (b instanceof EarthBlock){
//            return 3;
//        }
        if (b instanceof SandBlock){
            return 4;
        }
        if (b instanceof GlassBlock){
            return 5;
        }
        if (b instanceof RawIronBlock){
            return 6;
        }
        if (b instanceof IronSwordInterface){
            return 7;
        }
        return 100;
    }
}
