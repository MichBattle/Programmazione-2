package Controller;

import Model.Gioco;
import View.HandPane;
import View.PlayerPane;
import javafx.scene.layout.AnchorPane;

public class MainGUI extends AnchorPane {
    private Gioco gioco;

    private PlayerPane giocatore1;
    private PlayerPane giocatore2;

    private HandPane mano1;
    private HandPane mano2;

    public MainGUI() {
        super();

        gioco = new Gioco();
        giocatore1 = new PlayerPane(gioco.getMano1(), gioco.getMano2());
        giocatore2 = new PlayerPane(gioco.getMano2(), gioco.getMano1());

    }
}
