package View;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class ButtonPane extends VBox {
    public ButtonPane(Bottoni bottoni, boolean isAutoList) {
        super();
        super.getChildren().addAll(bottoni.getMescola(), bottoni.getOrdina(), bottoni.getConta(), bottoni.getOrdinaPer());

        if(!isAutoList){
            this.setAlignment(Pos.CENTER_RIGHT);
        }
    }
}
