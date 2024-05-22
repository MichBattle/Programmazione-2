package Controller;

import View.BottoniCelle;
import View.MappaPane;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class MainGUI extends AnchorPane {
    private MappaPane mappaPane;
    private BottoniCelle bottoniCelle;

    public MainGUI() {
        super();
        super.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        mappaPane = new MappaPane();
        bottoniCelle = new BottoniCelle();

        super.getChildren().addAll(mappaPane, bottoniCelle);

        AnchorPane.setTopAnchor(mappaPane, 0.0);
        AnchorPane.setLeftAnchor(mappaPane, 0.0);

        AnchorPane.setBottomAnchor(bottoniCelle, 0.0);
        AnchorPane.setLeftAnchor(bottoniCelle, 0.0);
    }
}
