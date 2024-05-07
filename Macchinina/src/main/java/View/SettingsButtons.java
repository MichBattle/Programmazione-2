package View;

import Main.Coordinate;
import View.Celle.Strada;
import com.macchinina.MainGUI;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class SettingsButtons extends VBox {
    private MainGUI mg;

    private Button aggiungiAuto;
    private Button muoviAuto;
    private Button reset;

    public SettingsButtons(MainGUI mg) {
        this.mg = mg;

        aggiungiAuto = new Button("Add");
        muoviAuto = new Button("Move");
        reset = new Button("Reset");

        muoviAuto.setDisable(true);
        setAggiungiAutoAction();
        setMuoviAutoAction();
        setResetAction();

        aggiungiAuto.setPrefSize(70,10);
        muoviAuto.setPrefSize(70, 10);
        reset.setPrefSize(70, 10);

        super.getChildren().addAll(aggiungiAuto, muoviAuto, reset);
    }

    public Button getAggiungiAuto() {
        return aggiungiAuto;
    }

    public Button getMuoviAuto() {
        return muoviAuto;
    }

    private void setAggiungiAutoAction(){
        aggiungiAuto.setOnAction(actionEvent -> {
                aggiungiAuto.setDisable(true);
                mg.getIndicationButtons().disattivaBottoni();
        });
    }

    private void setMuoviAutoAction(){
        muoviAuto.setOnAction(actionEvent -> {
            Coordinate coordinateAuto = mg.getCoordinateAuto();
            GrigliaPane gp = mg.getGrigliaPane();
            Strada s = (Strada) gp.getElementAt(coordinateAuto.getY(), coordinateAuto.getX());
            s.removeAuto();
            s.muoviAuto();
        });
    }

    private void setResetAction(){
        reset.setOnAction(actionEvent -> {
            resetAction();
        });
    }

    /**
     *
     */
    public void resetAction(){
        mg.getGrigliaPane().creaGriglia();
        mg.getIndicationButtons().disattivaBottoni();
        aggiungiAuto.setDisable(false);
        muoviAuto.setDisable(true);
    }
}
