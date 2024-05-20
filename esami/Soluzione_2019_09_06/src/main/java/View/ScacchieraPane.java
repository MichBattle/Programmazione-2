package View;

import javafx.scene.layout.GridPane;

import java.util.Random;

public class ScacchieraPane extends GridPane {
    public ScacchieraPane(Bottoni b) {
        super();
        creaGriglia(b);
    }

    public void creaGriglia(Bottoni b){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Random r = new Random();
                Casella c;
                if(r.nextBoolean())
                    c = new CasellaDueBottoni(b);
                else
                    c = new CasellaTreBottoni(b);
                super.add(c, j, i);
            }
        }
    }
}
