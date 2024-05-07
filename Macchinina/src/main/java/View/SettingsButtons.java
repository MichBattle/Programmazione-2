package View;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class SettingsButtons extends VBox {
    private Button aggiungiAuto;
    private Button muoviAuto;
    private Button reset;

    public SettingsButtons() {
        aggiungiAuto = new Button("Add");
        muoviAuto = new Button("Move");
        reset = new Button("Reset");

        aggiungiAuto.setPrefSize(70,10);
        muoviAuto.setPrefSize(70, 10);
        reset.setPrefSize(70, 10);

        super.getChildren().addAll(aggiungiAuto, muoviAuto, reset);
    }
}
