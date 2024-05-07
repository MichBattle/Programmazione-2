package com.macchinina;

import Main.Coordinate;
import View.GrigliaPane;
import View.IndicationButtons;
import View.SettingsButtons;
import javafx.scene.layout.AnchorPane;

public class MainGUI extends AnchorPane {
    private Coordinate coordinateAuto;
    private GrigliaPane grigliaPane;
    private IndicationButtons indicationButtons;
    private SettingsButtons settingsButtons;

    public MainGUI() {
        super();
        coordinateAuto = null;
        indicationButtons = new IndicationButtons();
        settingsButtons = new SettingsButtons(this);
        grigliaPane = new GrigliaPane(this);

        super.getChildren().addAll(grigliaPane, indicationButtons, settingsButtons);

        AnchorPane.setTopAnchor(grigliaPane, 0.0);
        AnchorPane.setLeftAnchor(grigliaPane, 0.0);

        AnchorPane.setBottomAnchor(indicationButtons, 0.0);
        AnchorPane.setLeftAnchor(indicationButtons, 0.0);

        AnchorPane.setBottomAnchor(settingsButtons, 0.0);
        AnchorPane.setRightAnchor(settingsButtons, 0.0);
    }

    public void setCoordinateAuto(Coordinate coordinateAuto) {
        this.coordinateAuto = coordinateAuto;
    }

    public Coordinate getCoordinateAuto() {
        return coordinateAuto;
    }

    public IndicationButtons getIndicationButtons() {
        return indicationButtons;
    }

    public GrigliaPane getGrigliaPane() {
        return grigliaPane;
    }

    public SettingsButtons getSettingsButtons() {
        return settingsButtons;
    }
}
