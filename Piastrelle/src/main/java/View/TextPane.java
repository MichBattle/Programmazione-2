package View;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class TextPane extends Pane {
    private Text text;
    private ArrayList<Piastrella> piastrelle;

    public TextPane(MainGUI mg) {
        super();
        text = new Text();
        piastrelle = mg.getDb().getPiastrelle();

        updateText();
        super.getChildren().add(text);
    }

    public void updateText(){
        text.setText(piastrelle.get(MainGUI.getINDEX()).toString());
    }
}
