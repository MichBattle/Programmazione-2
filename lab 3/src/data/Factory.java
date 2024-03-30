package data;

import data.blocks.*;
import data.blocks.interfaces.Block;
import data.blocks.solids.RawIronBlock;

import java.util.Random;

public class Factory {
    private static final int RAND_UPPERBOUND = 3;

    public Factory(){
    }

    /**
     * crea blocco random
     * @return
     */
    public Block random_block(){
        Random rand = new Random();
        int r = rand.nextInt(RAND_UPPERBOUND);
        switch (r){
            case 0:
                return this.rawIronBlock();
            case 1:
                return this.sandBlock();
            default:
                return this.nullBlock();
        }
    }

    public AirBlock default_block(){
        return new AirBlock();
    }

    public SandBlock sandBlock(){
        return new SandBlock();
    }

    public WaterBlock waterBlock(){
        return new WaterBlock();
    }

    public NullBlock nullBlock(){
        return new NullBlock();
    }

    public RawIronBlock rawIronBlock(){
        return new RawIronBlock();
    }
}