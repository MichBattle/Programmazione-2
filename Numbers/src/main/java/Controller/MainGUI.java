package Controller;

import View.ButtonPane;
import View.GrigliaPane;
import javafx.scene.layout.AnchorPane;

public class MainGUI extends AnchorPane {
    private GrigliaPane gp;
    private ButtonPane bp;

    public MainGUI() {
        super();
        gp = new GrigliaPane(this);
        bp = new ButtonPane();

        AnchorPane.setTopAnchor(gp, 0.0);
        AnchorPane.setLeftAnchor(gp, 0.0);

        AnchorPane.setBottomAnchor(bp, 0.0);
        AnchorPane.setLeftAnchor(bp, 15.0);

        super.getChildren().addAll(gp, bp);
    }

    public ButtonPane getBp() {
        return bp;
    }
}
