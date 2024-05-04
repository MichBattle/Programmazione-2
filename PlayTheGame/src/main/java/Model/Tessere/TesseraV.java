package Model.Tessere;

import Model.Gioco;
import Model.Tessera;
import javafx.scene.control.Alert;

public class TesseraV extends Tessera {
    private Gioco gioco;

    public TesseraV(Gioco g) {
        super("V");
        this.gioco = g;
    }

    @Override
    public void scopri() {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Game Over");
        a.setContentText("Complimenti hai vinto");
        System.out.println("Complimenti hai vinto");
        a.setOnCloseRequest(event -> {
            gioco.setPartiteVinte(gioco.getPartiteVinte() + 1);
            gioco.setPunteggio(0);
            gioco.resetAll();
        });
        a.showAndWait();
    }

    @Override
    public void nascondi() {

    }
}
