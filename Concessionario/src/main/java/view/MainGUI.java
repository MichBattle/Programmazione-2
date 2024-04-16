package view;

import javafx.scene.layout.AnchorPane;
import model.Concessionario;

public class MainGUI extends AnchorPane {
    private Concessionario c;
    private StatsPane sp;
    private ButtonPane bp;


    public MainGUI() {
        super();

        c = new Concessionario();
        sp = new StatsPane(c);
        bp = new ButtonPane(this, c);

        super.getChildren().add(sp);
        super.getChildren().add(bp);

        AnchorPane.setTopAnchor(sp, 0.0);
        AnchorPane.setLeftAnchor(sp, 0.0);

        AnchorPane.setBottomAnchor(bp, 0.0);
        AnchorPane.setRightAnchor(bp, 0.0);
    }

    public void updateStatsPane(int index){
        sp.updateLable(index);
    }
}
