package View;

import Controller.ArchivioTitoli;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainGUI extends BorderPane {
    private ArchivioTitoli archivio;
    private TitoliPane titoli_pane;
    private ButtonPane bp;
    private Button indietro;
    private Button avanti;

    public MainGUI() {
        super();

        archivio = new ArchivioTitoli();

        titoli_pane = new TitoliPane(this, archivio);
        bp = new ButtonPane(this);
        indietro = bp.getBack();
        avanti = bp.getForward();

        HBox hb = new HBox(indietro, titoli_pane, avanti);

        super.setTop(hb);
    }

    public void scorriFilm(boolean avanti){
        titoli_pane.scorri(avanti);
    }

    public void setGridCenter(VBox v) {
        super.setCenter(v);
    }
}