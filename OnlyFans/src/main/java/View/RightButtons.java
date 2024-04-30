package View;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class RightButtons extends VBox {
    private MainGUI mg;

    private Button sortByName;
    private Button sortByPrice;

    public RightButtons(MainGUI mg) {
        super();
        this.mg = mg;

        sortByName = new Button("Ordina per tipo");
        sortByPrice = new Button("Ordina per prezzo");

        sortByPrice.setDisable(true);

        setButtonAction(sortByName, sortByPrice);
        setButtonAction(sortByPrice, sortByName);

        super.getChildren().addAll(sortByName, sortByPrice);
        super.setSpacing(5);
    }

    private void setButtonAction(Button b, Button other){
        b.setOnAction(actionEvent -> {
            mg.changeSort();
            mg.update_circlePane();

            b.setDisable(true);
            other.setDisable(false);

            mg.update_statsPane(0, 0, 0);
        });
    }
}