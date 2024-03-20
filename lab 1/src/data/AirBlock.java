package data;

public class AirBlock extends AbstractBlock{
    public AirBlock(){
        super();
        this.contenuto = '.';
        this.falls_with_gravity = false;
        this.fall_through = true;
        this.blockName = "Air";
    }

    public AirBlock(char contenuto){
        super();
        this.contenuto = contenuto;
        this.falls_with_gravity = true;
        this.fall_through = false;
        this.blockName = "Air";
    }

}
