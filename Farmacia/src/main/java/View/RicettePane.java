package View;

import Model.DataBase;
import Model.RicettaUtente;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class RicettePane extends VBox {
    private ArrayList<RicettaUtente> ricette;
    private MainGUI mg;

    public RicettePane(MainGUI mg, DataBase db) {
        super();

        this.mg = mg;
        ricette = db.getRicette();

        for(RicettaUtente ric : ricette){
            super.getChildren().add(creaBottone(ric));
        }

        super.setSpacing(5);
    }

    private Button creaBottone(RicettaUtente ric){
        Button b = new Button(ric.toString());
        if(!checkScaduta(b))
            setButtonAction(b, ric);
        else
            b.setDisable(true);
        return b;
    }

    private void setButtonAction(Button b, RicettaUtente ric){
        b.setOnAction(actionEvent -> {
            b.setDisable(true);
            mg.updateSelectPaneText(ric);
            b.setText(b.getText() + "(selezionato)");
            abilitaAltriBottoni(b);
        });
    }

    private boolean checkScaduta(Button b){
        return b.getText().contains("scaduto");
    }

    private void abilitaAltriBottoni(Button b){
        for (Node butt : super.getChildren()) {
            if (butt instanceof Button) { //se è un bottone
                if(!((Button) butt).getText().equals(b.getText())){ //se non è quello inserito
                    if(!checkScaduta((Button) butt) && butt.isDisabled()){ //se non è disabilitato per scadenza ed è disabilitato
                        butt.setDisable(false);
                        ((Button) butt).setText(((Button) butt).getText().replace("(selezionato)", ""));
                    }
                }
            }
        }
    }
}
