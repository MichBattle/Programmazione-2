package View;

import javafx.scene.layout.AnchorPane;

public class MainGUI extends AnchorPane {
    private GrigliaPane grigliaPane;
    private IndicationButtons indicationButtons;
    private SettingsButtons settingsButtons;

    public MainGUI() {
        super();
        indicationButtons = new IndicationButtons();
        grigliaPane = new GrigliaPane(this);
        settingsButtons = new SettingsButtons();

        super.getChildren().addAll(grigliaPane, indicationButtons, settingsButtons);

        AnchorPane.setTopAnchor(grigliaPane, 0.0);
        AnchorPane.setLeftAnchor(grigliaPane, 0.0);

        AnchorPane.setBottomAnchor(indicationButtons, 0.0);
        AnchorPane.setLeftAnchor(indicationButtons, 0.0);

        AnchorPane.setBottomAnchor(settingsButtons, 0.0);
        AnchorPane.setRightAnchor(settingsButtons, 0.0);
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
