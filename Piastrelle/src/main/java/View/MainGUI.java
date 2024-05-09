package View;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainGUI extends BorderPane {
    private PiastrellaPane piastrellaPane;
    private ButtonPane buttonPane;
    private TextPane textPane;
    private DataBase db;
    private static int INDEX;

    public MainGUI() {
        super();
        db = new DataBase();
        INDEX = 0;

        piastrellaPane = new PiastrellaPane(this);
        textPane = new TextPane(this);
        buttonPane = new ButtonPane(this);

        VBox vb = new VBox(textPane, buttonPane);
        HBox hb = new HBox(vb, piastrellaPane);
        hb.setSpacing(10);

        super.setCenter(hb);
    }

    public DataBase getDb() {
        return db;
    }

    public static int getINDEX() {
        return INDEX;
    }

    public static void setINDEX(int INDEX) {
        MainGUI.INDEX = INDEX;
    }

    public PiastrellaPane getPiastrellaPane() {
        return piastrellaPane;
    }

    public TextPane getTextPane() {
        return textPane;
    }
}
