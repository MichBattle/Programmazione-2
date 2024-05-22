package View;

import Model.Celle.Prato;
import javafx.scene.layout.GridPane;

public class MappaPane extends GridPane {
    public MappaPane() {
        super();
        creaMappa();
    }
    
    public void creaMappa(){
        super.getChildren().clear();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                super.add(new Prato(), j, i);
            }
        }
    }
}
