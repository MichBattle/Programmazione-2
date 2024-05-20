package Controller;

import View.Bottoni;
import View.BottoniPerGestire;
import View.ScacchieraPane;
import javafx.scene.layout.VBox;

public class MainGUI extends VBox {
    private ScacchieraPane scacchieraPane;
    private BottoniPerGestire bottoniPerGestire;
    private Bottoni bottoni;

    public MainGUI() {
        super();
        bottoni = new Bottoni();
    }
}
