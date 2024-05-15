package Controller;

import View.GrigliaPane;
import View.StatsPane;
import javafx.scene.layout.VBox;

public class MainGUI extends VBox {
    private StatsPane statsPane;
    private GrigliaPane grigliaPane;

    public MainGUI() {
        super();

        statsPane = new StatsPane();
        grigliaPane = new GrigliaPane(this);

        super.getChildren().addAll(statsPane, grigliaPane);
    }

    public StatsPane getStatsPane() {
        return statsPane;
    }
}
