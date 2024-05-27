package Controller;

import Model.TitoliDB;
import Model.Titolo;
import View.BottoniDirezione;
import View.BottoniSorting;
import View.TitoliPane;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class MainGUI extends BorderPane {
    private static int GENERAL_INDEX;
    private TitoliDB titoliDB;
    private TitoliPane titoliPane;
    private BottoniDirezione bottoniDirezione;
    private BottoniSorting bottoniSorting;
    private Button clear;

    public MainGUI() {
        super();
        GENERAL_INDEX = 0;
        clear = new Button("Clear");
        setClearAction();
        titoliDB = new TitoliDB();
        titoliPane = new TitoliPane(this);
        bottoniDirezione = new BottoniDirezione(this);
        bottoniSorting = new BottoniSorting(this);

        Button indietro = bottoniDirezione.getBack();
        Button avanti = bottoniDirezione.getNext();

        HBox hb = new HBox(indietro, titoliPane, avanti);

        super.setTop(hb);
        super.setLeft(clear);
        super.setRight(bottoniSorting);
    }

    private void setClearAction() {
        clear.setOnAction(event -> {
            GENERAL_INDEX = 0;
            titoliDB.sortByName();
            setCenter(null);
            titoliPane.aggiornaTitoliPane();
            for (Titolo t : titoliDB.getArchivio())
                t.resetPrezzo();
        });
    }

    public static int getGeneralIndex() {
        return GENERAL_INDEX;
    }

    public static void incrementGeneralIndex() {
        GENERAL_INDEX++;
    }

    public static void decrementGeneralIndex() {
        GENERAL_INDEX--;
    }

    public static void resetGeneralIndex() {
        GENERAL_INDEX = 0;
    }

    public TitoliDB getTitoliDB() {
        return titoliDB;
    }

    public TitoliPane getTitoliPane() {
        return titoliPane;
    }
}
