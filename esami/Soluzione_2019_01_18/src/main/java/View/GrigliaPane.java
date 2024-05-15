package View;

import Controller.MainGUI;
import Model.Tessera;
import Model.Tessere.TesseraP;
import Model.Tessere.TesseraS;
import Model.Tessere.TesseraV;
import javafx.scene.layout.GridPane;
import org.example.soluzione_2019_01_18.MainFX;

import java.util.ArrayList;
import java.util.Random;

public class GrigliaPane extends GridPane {
    private MainGUI mg;

    public GrigliaPane(MainGUI mg) {
        super();
        this.mg = mg;

        creaGriglia();
    }

    public void creaGriglia(){
        ArrayList<Tessera> tessere = new ArrayList<>();

        for (int i = 0; i < (MainFX.getLATO()*MainFX.getLATO()) - 2; i++) {
            tessere.add(new TesseraS(mg));
        }
        tessere.add(new TesseraP(mg));
        tessere.add(new TesseraV(mg));
        Random r = new Random();

        for (int i = 0; i < MainFX.getLATO(); i++) {
            for (int j = 0; j < MainFX.getLATO(); j++) {
                int index = r.nextInt(tessere.size());
                Tessera t = tessere.get(index);
                tessere.remove(index);
                super.add(t, j, i);
                System.out.print(t + " ");
            }
            System.out.println();
        }
    }
}
