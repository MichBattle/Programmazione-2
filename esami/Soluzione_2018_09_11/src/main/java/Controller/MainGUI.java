package Controller;

import Model.Gioco;
import View.HandPane;
import View.PlayerPane;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class MainGUI extends AnchorPane {
    private Gioco gioco;

    private PlayerPane giocatore1;
    private PlayerPane giocatore2;

    private HandPane mano1;
    private HandPane mano2;

    public MainGUI() {
        super();

        gioco = new Gioco();

        giocatore1 = new PlayerPane(this, gioco.getMano1(), gioco.getMano2());
        giocatore2 = new PlayerPane(this, gioco.getMano2(), gioco.getMano1());
        mano1 = new HandPane(gioco.getMano1());
        mano2 = new HandPane(gioco.getMano2());
        giocatore1.getPescaDallAvversario().setDisable(false);

        VBox vb1 = new VBox(mano1, giocatore1);
        VBox vb2 = new VBox(giocatore2, mano2);

        super.getChildren().addAll(vb1, vb2);

        AnchorPane.setTopAnchor(vb2, 0.0);
        AnchorPane.setLeftAnchor(vb2, 0.0);
        AnchorPane.setBottomAnchor(vb1, 0.0);
        AnchorPane.setLeftAnchor(vb1, 0.0);
    }

    public PlayerPane getOtherPlayer(PlayerPane giocatore){
        if (giocatore == giocatore1)
            return giocatore2;
        else if (giocatore == giocatore2)
            return giocatore1;
        else
            return null;
    }

    public HandPane getAvversario(PlayerPane giocatore) {
        if (giocatore == giocatore1)
            return mano2;
        else if (giocatore == giocatore2)
            return mano1;
        else
            return null;
    }

    public HandPane getCurrent(PlayerPane giocatore){
        if (giocatore == giocatore1)
            return mano1;
        else if (giocatore == giocatore2)
            return mano2;
        else
            return null;
    }

    public Gioco getGioco() {
        return gioco;
    }
}
