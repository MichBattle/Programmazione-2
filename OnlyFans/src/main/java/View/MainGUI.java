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
    private RightButtons right_buttons;

    public MainGUI() {
        super();
        stats = new Stats();
        fans = new Fans();

        stats_pane = new StatsPane(stats);
        cerchi = new CenterPane(this, fans);
        left_buttons = new LeftButtons(this);
        right_buttons = new RightButtons(this);

        GridPane gp = new GridPane();
        gp.add(left_buttons, 0, 0);
        gp.add(cerchi, 1, 0);
        gp.add(right_buttons, 2, 0);
        gp.setHgap(10);

        super.getChildren().addAll(stats_pane, gp);
    }

    public void update_statsPane(int capitale, int spesaMensile, int mesiTrascorsi){
        stats_pane.update_all_labels(capitale, spesaMensile, mesiTrascorsi);
    }

    public int getSoldi(){
        return stats.getCapitale();
    }

    public void impostaCostosi(){
        cerchi.impostaCostosi();
    }

    public int getSpesa(){
        return stats.getSpesaMensile();
    }

    public void resetCircles(){
        cerchi.resetAll();
    }

    public void changeSort(){
        fans.changeSortingMethod();
    }

    public void update_circlePane(){
        cerchi.update_center();
    }

    public int getMesiTrascorsi(){
        return stats.getMesiTrascorsi();
    }
}