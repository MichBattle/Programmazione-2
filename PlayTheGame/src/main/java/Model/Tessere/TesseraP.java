package Model.Tessere;

import Model.Tessera;
import javafx.application.Platform;
import javafx.scene.control.Alert;

public class TesseraP extends Tessera {

    public TesseraP() {
        super("P");
    }

    @Override
    public void scopri() {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Game Over");
        a.setContentText("Peccato hai perso!");
        System.out.println("Peccato hai perso!");
        a.setOnCloseRequest(event -> Platform.exit());
        a.showAndWait();
    }

    @Override
    public void nascondi() {

    }
}
