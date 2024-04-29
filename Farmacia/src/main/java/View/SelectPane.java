package View;

import Model.ConRicetta;
import Model.RicettaUtente;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class SelectPane extends Pane {
    private Text testoMedicina;
    private Button compra;
    private VBox vb;
    private MainGUI mg;

    public SelectPane(MainGUI mg) {
        super();
        this.mg = mg;

        testoMedicina = new Text();
        compra = new Button();

        compra.setOpacity(0);

        vb = new VBox(testoMedicina, compra);
        super.getChildren().add(vb);
    }

    public void updateLabel(RicettaUtente ric){
        updateText(ric);
        updateButton(ric);
    }

    private void updateText(RicettaUtente ric){
        testoMedicina.setText(ric.getMedicina().toString());
    }

    private void updateButton(RicettaUtente ric){
        compra.setOpacity(1);
        compra.setText("compra");
        setAction(compra, ric);
    }

    private void setAction(Button b, RicettaUtente ric){
        b.setOnAction(actionEvent -> {
            ConRicetta c = (ConRicetta) ric.getMedicina();
            if(ric.getMedicina().getPrezzoScontato() > mg.getSoldi()){
                displayAlert("soldi insufficienti");
            }else if(ric.getMedicina().isScaduto()){
                displayAlert("medicina scaduta");
            }else if(c.getRipetibili() <= 0){
                displayAlert("non hai piu ripetizioni su questa medicina");
            }else {
                mg.setSoldi(mg.getSoldi()-ric.getMedicina().getPrezzoScontato());
                c.setRipetibili(c.getRipetibili()-1);

                //aggiorno lable soldi
                mg.updateSoldiLabel();

                //aggiorno lable ripetibili qua e su mp
                updateText(ric);
                mg.updateMedicinsLable();
            }
        });
    }

    private void displayAlert(String s){
        Alert win = new Alert(Alert.AlertType.INFORMATION);
        win.setTitle("ERROR!");
        win.setHeaderText("ERRORE");
        win.setContentText(s);
        win.showAndWait();
    }
}
