package Controller;

import View.Bottoni;
import View.CellePane;
import javafx.scene.layout.AnchorPane;

public class MainGUI extends AnchorPane {
    private static int val;
    private Bottoni bottoni;
    private CellePane cellePane;

    public MainGUI() {
        super();
        val = 1;
        cellePane = new CellePane(this);
        bottoni = new Bottoni(this);

        super.getChildren().addAll(cellePane, bottoni);

        AnchorPane.setTopAnchor(cellePane, 0.0);
        AnchorPane.setLeftAnchor(cellePane, 0.0);

        AnchorPane.setBottomAnchor(bottoni, 0.0);
        AnchorPane.setLeftAnchor(bottoni, 15.0);
    }

    public Bottoni getBottoni() {
        return bottoni;
    }

    public static int getVal() {
        return val;
    }

    public static void setVal(int val) {
        MainGUI.val = val;
    }

    public CellePane getCellePane() {
        return cellePane;
    }
}
