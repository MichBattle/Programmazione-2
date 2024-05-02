package View;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class LeftButtons extends VBox {
    private MainGUI mg;
    private Button prossimoMese;
    private Button aumentaFondo;

    public LeftButtons(MainGUI mg) {
        super();
        this.mg = mg;
        prossimoMese = new Button("Prox Mese");
        aumentaFondo = new Button("+100 fondi");

        activate_month_button();
        activate_money_button();

        super.getChildren().addAll(prossimoMese, aumentaFondo);
        super.setSpacing(5);
    }

    /**
     * attiva il bottone del mese
     * aumenta il mese di 1
     * toglie la spesa dal fondo
     * resetta i cerchi
     * imposta i cerchi troppo costosi a bordo grigio
     */
    private void activate_month_button(){
        prossimoMese.setOnAction(actionEvent -> {
            mg.update_statsPane(-mg.getSpesa(), 0, 1);
            mg.resetCircles();
            mg.impostaCostosi();
        });
    }

    /**
     * attiva il bottone per aumentare il fondo
     * aumenta di 100 il capitale
     * imposta i cerchi troppo costosi a bordo grigio
     */
    private void activate_money_button(){
        aumentaFondo.setOnAction(actionEvent -> {
            mg.update_statsPane(100, 0,0);
            mg.impostaCostosi();
        });
    }
}