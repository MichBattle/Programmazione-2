package View;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class PiastrellaPane extends GridPane {
    private ArrayList<Piastrella> piastrelle;

    public PiastrellaPane(MainGUI mg) {
        super();
        piastrelle = mg.getDb().getPiastrelle();

        updatePiastrellaMostrata();
    }

    public void updatePiastrellaMostrata(){
        super.getChildren().clear();
        super.getChildren().add(piastrelle.get(MainGUI.getINDEX()));
    }
}
