package View;

import Controller.ArchivioTitoli;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MainGUI extends BorderPane {
    private ArchivioTitoli archivio;
    private TitoliPane titoli_pane;
    private ButtonPane bp;

    private Button clear;
    private RightPane right_pane;

    public MainGUI() {
        super();

        archivio = new ArchivioTitoli();

        titoli_pane = new TitoliPane(this, archivio);
        bp = new ButtonPane(this);
        right_pane = new RightPane(this, archivio);

        Button indietro = bp.getBack();
        Button avanti = bp.getForward();
        clear = bp.getClear();

        HBox hb = new HBox(indietro, titoli_pane, avanti);

        super.setTop(hb);
        super.setLeft(clear);
        super.setRight(right_pane);
    }

    public void scorriFilm(boolean avanti){
        titoli_pane.scorri(avanti);
    }

    public void setGridCenter(VBox v) {
        super.setCenter(v);
    }

    public void resetAll(){
        titoli_pane.resetAll();
    }
}