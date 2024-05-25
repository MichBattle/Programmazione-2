package Controller;

import Model.Catalogo;
import View.ButtonPane;
import View.PiastrellaCorrente;
import View.TestoPane;
import javafx.scene.layout.HBox;

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
