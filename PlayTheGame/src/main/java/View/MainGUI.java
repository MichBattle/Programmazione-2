package View;

import Model.Gioco;
import javafx.scene.layout.VBox;

public class MainGUI extends VBox {
    private Gioco gioco;

    private StatsPane stats_pane;
    private TessPane grid_pane;
    private ButtonPane button_pane;

    public MainGUI(int N) {
        super();
        gioco = new Gioco(N, this);
        stats_pane = new StatsPane(this);
        grid_pane = new TessPane(this);
        button_pane = new ButtonPane(this);

        super.getChildren().addAll(stats_pane, grid_pane, button_pane);
    }

    public Gioco getGioco() {
        return gioco;
    }

    public void resetAll(){
        gioco.riempiScacchiera();
        grid_pane.resetAll();
        stats_pane.updatePunteggio();
        stats_pane.updatePartiteVinte();
        System.out.println("PARTITA RICOMINCIATA");
        gioco.printScacchiera();
    }

    public void updatePunteggio(){
        stats_pane.updatePunteggio();
    }
}
