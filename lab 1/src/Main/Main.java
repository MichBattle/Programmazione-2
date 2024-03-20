package Main;

import data.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int x, y;

        System.out.println("inserisci la larghezza: ");
        x = in.nextInt();
        System.out.println("inserisci l'altezza: ");
        y = in.nextInt();

        Mappa mappa = new Mappa(x, y);

        mappa.display_on_out();

        /*for(int i = 0; i < 3; i++){
            System.out.println("riga da cambiare: ");
            x = in.nextInt();
            System.out.println("colonna da cambiare: ");
            y = in.nextInt();

            mappa.change_cell(x, y);
            mappa.display_on_out();
        }*/

        //mappa.change_cell(2, 3);
        //mappa.display_on_out();

        /*for(int i = 0; i < 5; i++){
            System.out.println("riga da cambiare: ");
            int z = in.nextInt();
            System.out.println("colonna da cambiare: ");
            int k = in.nextInt();

            mappa.swap(z, k);
            mappa.display_on_out();
        }*/

        System.out.println("riga in cui inserire il blocco: ");
        int z = in.nextInt();
        System.out.println("colonna in cui inserire il blocco: ");
        int k = in.nextInt();
        mappa.insert_at_coords(new AirBlock('A'), z, k);
        mappa.display_on_out();
    }
}
