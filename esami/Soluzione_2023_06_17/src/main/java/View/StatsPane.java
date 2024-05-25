package View;

import Model.geralt.Geralt;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class StatsPane extends Pane {

    public StatsPane(Geralt geralt) {
        super();
        creaTesto(geralt);
    }

    public void creaTesto(Geralt geralt){
        super.getChildren().clear();
        super.getChildren().add(new Text(geralt.stringaStats()));
    }
}
