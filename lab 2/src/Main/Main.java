package Main;

import data.*;
import data.blocks.interfaces.IronSwordInterface;
import data.blocks.solids.RawIronBlock;
import utils.Coordinate;
import visual.MainView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MainView m = new MainView(10, 10);

        m.printMappa();
        m.printFornace();
        m.insert(new RawIronBlock(), 0,0);
        m.printMappa();
        m.move_into_furnace(0,0);
        m.printFornace();
        m.printMappa();
        m.printFornace();
    }
}
