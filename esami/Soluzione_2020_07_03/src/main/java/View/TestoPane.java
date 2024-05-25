package View;

import Controller.MainGUI;
import Model.Catalogo;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class TestoPane extends Pane {
    private Catalogo catalogo;
    private Text testo;

    public TestoPane(Catalogo catalogo) {
        super();
        this.catalogo = catalogo;
        testo = new Text();
        aggiornaTesto();
    }

    public void aggiornaTesto(){
        super.getChildren().clear();
        testo.setText(catalogo.getPiastrelle().get(MainGUI.getGeneralIndex()).toString());
        super.getChildren().add(testo);
    }
}
