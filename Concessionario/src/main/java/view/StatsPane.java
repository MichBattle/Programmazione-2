package view;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import model.Concessionario;

public class StatsPane extends HBox {
    private Concessionario c;

    public StatsPane(Concessionario c) {
        super();
        this.c = c;

        updateLable(0);
    }

    public void updateLable(int index){
        super.getChildren().clear();
        super.getChildren().add(new Text(c.getAutoAtIndex(index).toString()));
    }
}
