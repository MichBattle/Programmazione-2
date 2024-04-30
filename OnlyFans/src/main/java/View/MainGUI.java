package View;

import Controller.Fans;
import Controller.Stats;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class MainGUI extends VBox {
    private Stats stats;
    private Fans fans;

    private StatsPane stats_pane;
    private LeftButtons left_buttons;
    private CenterPane cerchi;

    public MainGUI() {
        super();
        stats = new Stats();
        fans = new Fans();

        stats_pane = new StatsPane(stats);
        left_buttons = new LeftButtons(this);
        cerchi = new CenterPane(this, fans);

        GridPane gp = new GridPane();
        gp.add(left_buttons, 0, 0);
        gp.add(cerchi, 1, 0);
        gp.setHgap(10);

        super.getChildren().addAll(stats_pane, gp);
    }

    public void update_statsPane(int capitale, int spesaMensile, int mesiTrascorsi){
        stats_pane.update_all_labels(capitale, spesaMensile, mesiTrascorsi);
    }

    public int getSoldi(){
        return stats.getCapitale();
    }
}