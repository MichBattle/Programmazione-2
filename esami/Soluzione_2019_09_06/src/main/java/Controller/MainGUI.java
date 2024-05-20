package Controller;

import View.Bottoni.BottoniPerGestire;
import View.ScacchieraPane;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class MainGUI extends VBox {
    private ScacchieraPane scacchieraPane;
    private BottoniPerGestire bottoniPerGestire;

    public MainGUI() {
        super();
        scacchieraPane = new ScacchieraPane();
        bottoniPerGestire = new BottoniPerGestire(scacchieraPane);

        super.getChildren().addAll(scacchieraPane, bottoniPerGestire);
        bottoniPerGestire.setAlignment(Pos.CENTER);
        scacchieraPane.setAlignment(Pos.CENTER);
    }

    public BottoniPerGestire getBottoniPerGestire() {
        return bottoniPerGestire;
    }

    public ScacchieraPane getScacchieraPane() {
        return scacchieraPane;
    }
}
