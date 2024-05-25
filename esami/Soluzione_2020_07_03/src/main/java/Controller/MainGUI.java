package Controller;

import Model.Catalogo;
import View.ButtonPane;
import View.PiastrellaCorrente;
import View.TestoPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainGUI extends HBox {
    private TestoPane testoPane;
    private ButtonPane buttonPane;
    private Catalogo catalogo;
    private PiastrellaCorrente piastrellaCorrente;
    private static int GENERAL_INDEX;

    public MainGUI() {
        super();
        GENERAL_INDEX = 0;
        catalogo = new Catalogo();
        testoPane = new TestoPane(catalogo);
        buttonPane = new ButtonPane(this);
        piastrellaCorrente = new PiastrellaCorrente(catalogo);

        VBox vb = new VBox(testoPane, buttonPane);
        vb.setSpacing(10);

        super.getChildren().addAll(vb, piastrellaCorrente);
        super.setAlignment(Pos.CENTER);
        super.setPadding(new Insets(0,0,50,20));

    }

    public PiastrellaCorrente getPiastrellaCorrente() {
        return piastrellaCorrente;
    }

    public TestoPane getTestoPane() {
        return testoPane;
    }

    public static int getGeneralIndex() {
        return GENERAL_INDEX;
    }

    public static void incrementGeneralIndex() {
        GENERAL_INDEX++;
    }

    public static void decrementGeneralIndex(){
        GENERAL_INDEX--;
    }
}
