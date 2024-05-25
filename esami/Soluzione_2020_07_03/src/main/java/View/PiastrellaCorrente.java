package View;

import Controller.MainGUI;
import Model.Catalogo;
import javafx.scene.layout.Pane;

public class PiastrellaCorrente extends Pane {
    private Catalogo catalogo;

    public PiastrellaCorrente(Catalogo catalogo) {
        super();
        this.catalogo = catalogo;
        aggiornaPiastrellaMostrata();
    }

    public void aggiornaPiastrellaMostrata(){
        super.getChildren().clear();
        super.getChildren().add(catalogo.getPiastrelle().get(MainGUI.getGeneralIndex()));
    }
}
