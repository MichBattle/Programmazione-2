package controller.escape;

import Main.Utente;
import javafx.scene.layout.Pane;

public class MainGUI extends Pane {
    private Utente u;

    public MainGUI() {
        super();
        u = new Utente();

        super.getChildren().add(u);
        u.setCenterX(250);
        u.setCenterY(250);
    }

    public Utente getU() {
        return u;
    }
}
