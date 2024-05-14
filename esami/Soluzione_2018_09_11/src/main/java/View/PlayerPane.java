package View;

import Controller.MainGUI;
import Model.Mano;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class PlayerPane extends HBox {
    private Text nome;
    private Button pescaDallAvversario;
    private Button cercaCoppie;
    private Button pescaDalMazzo;

    public PlayerPane(Mano giocatoreCorrente, Mano avversario) {
        super();

        nome = new Text();
    }
}
