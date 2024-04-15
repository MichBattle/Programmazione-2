package View;

import Model.Gioco;
import javafx.scene.layout.AnchorPane;

public class MainGUI extends AnchorPane {
    private TabPane tp;
    private StatsPane sp;

    public MainGUI(Gioco g) {
        super();

        sp = new StatsPane(g);
        tp = new TabPane(g, this);

        super.getChildren().addAll(sp, tp);

        AnchorPane.setTopAnchor(sp, 0.0);
        AnchorPane.setBottomAnchor(tp, 0.0);
    }

    public void updatePunteggio(){
        sp.updateLabels();
    }
}
