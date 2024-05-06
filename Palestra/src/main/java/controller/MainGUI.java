package controller;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import main.Palestra;
import view.MidPane;
import view.TopPane;

public class MainGUI extends BorderPane {
    private Palestra palestra;

    private TopPane topPane;
    private MidPane midPane;

    private Button exit;

    public MainGUI() {
        super();
        palestra = new Palestra();
        exit = new Button("Exit");
        topPane = new TopPane(this);
        midPane = new MidPane(this);

        exit.setOnAction(actionEvent -> Platform.exit());

        BorderPane.setAlignment(exit, Pos.BOTTOM_RIGHT);
        BorderPane.setMargin(exit, new Insets(0, 10, 10, 0));

        super.setTop(topPane);
        super.setCenter(midPane);
        super.setBottom(exit);
    }

    public MidPane getMidPane() {
        return midPane;
    }

    public Palestra getPalestra() {
        return palestra;
    }

    public TopPane getTopPane() {
        return topPane;
    }
}
