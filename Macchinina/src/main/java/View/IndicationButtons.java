package View;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class IndicationButtons extends BorderPane {
    private Button nord;
    private Button sud;
    private Button est;
    private Button ovest;
    private Button prato;

    public IndicationButtons() {
        nord = new Button("Nord");
        sud = new Button("Sud");
        est = new Button("Est");
        ovest = new Button("Ovest");
        prato = new Button("Prato");

        nord.setPrefSize(70, 10);
        sud.setPrefSize(70, 10);
        est.setPrefSize(70, 10);
        ovest.setPrefSize(70, 10);
        prato.setPrefSize(70, 10);

        HBox topContainer = new HBox(nord);
        HBox bottomContainer = new HBox(sud);
        VBox leftContainer = new VBox(ovest);
        VBox rightContainer = new VBox(est);

        topContainer.setAlignment(Pos.CENTER);
        bottomContainer.setAlignment(Pos.CENTER);
        leftContainer.setAlignment(Pos.CENTER);
        rightContainer.setAlignment(Pos.CENTER);

        setButtonAction(nord);
        setButtonAction(sud);
        setButtonAction(est);
        setButtonAction(ovest);
        setButtonAction(prato);

        super.setTop(topContainer);
        super.setBottom(bottomContainer);
        super.setLeft(leftContainer);
        super.setRight(rightContainer);
        super.setCenter(prato);
    }

    public ArrayList<Button> getButtons(){
        ArrayList<Button> a = new ArrayList<>();
        a.add(nord);
        a.add(sud);
        a.add(est);
        a.add(ovest);
        a.add(prato);
        return a;
    }

    public Button getNord() {
        return nord;
    }

    public Button getSud() {
        return sud;
    }

    public Button getEst() {
        return est;
    }

    public Button getOvest() {
        return ovest;
    }

    public Button getPrato() {
        return prato;
    }

    public void disableButton(Button b){
        for(Button butt : getButtons()){
            butt.setDisable(false);
        }
        b.setDisable(true);
    }

    private void setButtonAction(Button b){
        b.setOnAction(actionEvent -> {
            disableButton(b);
        });
    }

    public void disattivaBottoni(){
        for(Button butt : getButtons()){
            butt.setDisable(false);
        }
    }
}
