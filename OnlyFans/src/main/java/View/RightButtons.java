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

    /**
     * imposta l'azione di un bottone
     * cambia il tipo di sort dell'arraylist di ventilatori
     * aggiorna il pane dei cerchi
     * disabilita un bottone e abilita l'altro (disabilita quello appena premuto perche è gia sortato in quel modo e attiva quello per sortare nell'altro modo)
     * @param b
     * @param other
     */
    private void setButtonAction(Button b, Button other){
        b.setOnAction(actionEvent -> {
            mg.changeSort();
            mg.update_circlePane();

            b.setDisable(true);
            other.setDisable(false);
        });
    }
}