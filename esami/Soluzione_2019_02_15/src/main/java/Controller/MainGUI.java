package Controller;

import Model.ListaRecord;
import View.ContenitorePane;
import javafx.scene.layout.HBox;

public class MainGUI extends HBox {
    private ContenitorePane auto;
    private ContenitorePane persona;

    public MainGUI() {
        super();
        auto = new ContenitorePane(new ListaRecord(), true);
        persona = new ContenitorePane(new ListaRecord(), false);

        super.getChildren().addAll(persona, auto);
    }
}
