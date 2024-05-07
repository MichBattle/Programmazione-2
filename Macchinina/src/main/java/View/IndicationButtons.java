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

        setNordAction();
        setSudAction();
        setEstAction();
        setOvestAction();
        setPratoAction();

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

    private void setNordAction(){
        nord.setOnAction(actionEvent -> {
            nord.setDisable(true);
            sud.setDisable(false);
            ovest.setDisable(false);
            est.setDisable(false);
            prato.setDisable(false);
        });
    }

    private void setSudAction(){
        sud.setOnAction(actionEvent -> {
            nord.setDisable(false);
            sud.setDisable(true);
            ovest.setDisable(false);
            est.setDisable(false);
            prato.setDisable(false);
        });
    }

    private void setEstAction(){
        est.setOnAction(actionEvent -> {
            nord.setDisable(false);
            sud.setDisable(false);
            ovest.setDisable(false);
            est.setDisable(true);
            prato.setDisable(false);
        });
    }

    private void setOvestAction(){
        ovest.setOnAction(actionEvent -> {
            nord.setDisable(false);
            sud.setDisable(false);
            ovest.setDisable(true);
            est.setDisable(false);
            prato.setDisable(false);
        });
    }

    private void setPratoAction(){
        prato.setOnAction(actionEvent -> {
            nord.setDisable(false);
            sud.setDisable(false);
            ovest.setDisable(false);
            est.setDisable(false);
            prato.setDisable(true);
        });
    }
}
