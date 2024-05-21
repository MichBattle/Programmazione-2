package Main;

import data.blocks.SandBlock;
import data.blocks.solids.RawIronBlock;
import data.blocks.solids.TorchBlock;
import utils.BlockErrorException;
import utils.WrongCoordinatesException;
import visual.GUI.BlockPane;
import visual.textual.MainView;

public class Main {

    private static void main1(MainView m) throws WrongCoordinatesException, BlockErrorException {
        System.out.println("-------------------------------------------");

        System.out.println("INSERISCO BLOCCO DI FERRO IN 0-0\n");
        m.insert(new RawIronBlock(), 0,0);
        m.display_map();
        m.display_furnace();
        m.display_inventory();

        System.out.println("-------------------------------------------");

        System.out.println("RACCOLGO IL BLOCCO DI FERRO IN 0-0\n");
        m.pick_up_block(0,0);
        m.display_map();
        m.display_furnace();
        m.display_inventory();

        System.out.println("-------------------------------------------");

        System.out.println("METTO IL BLOCCO DALL'INVENTARIO ALLA FORNACE\n");
        m.move_into_furnace_from_inventory(0);
        m.display_map();
        m.display_furnace();
        m.display_inventory();

        System.out.println("-------------------------------------------");

        System.out.println("RACCOLGO IL BLOCCO SMELTATO DALLA FORNACE\n");
        m.move_into_inventory_from_furnace();
        m.display_map();
        m.display_furnace();
        m.display_inventory();

        System.out.println("-------------------------------------------");
    }

    private static void main2(MainView m) throws WrongCoordinatesException, BlockErrorException {
        m.insert(new RawIronBlock(), 5, 0);
        m.insert(new SandBlock(), 4, 0);
//        m.insert(new WaterBlock(), 4, 0);
//        m.insert(new WaterBlock(), 3, 0);
//        m.insert(new WaterBlock(), 2, 0);
//        m.insert(new WaterBlock(), 1, 0);
//        m.insert(new WaterBlock(), 0, 0);
        m.insert(new TorchBlock(), 6, 0);
        m.display_map();

        m.pick_up_block(5,0);
        m.display_map();
    }

    public static void main(String[] args) {
//        try{
//            MainView m = new MainView(10, 10);
//            m.display_map();
//            m.display_furnace();
//            m.display_inventory();
//
//            main2(m);
//
//        }catch(BlockErrorException | WrongCoordinatesException b){
//            System.out.println(b.getMessage());
//        }

        BlockPane b = new BlockPane(new SandBlock());


    }
}
