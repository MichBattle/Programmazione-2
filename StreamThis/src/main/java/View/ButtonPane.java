package View;

import javafx.scene.control.Button;

public class ButtonPane {
    private MainGUI mg;

    private Button forward;
    private Button back;

    public ButtonPane(MainGUI mg) {
        this.mg = mg;
        forward = new Button(">");
        back = new Button("<");

        attivaBottoneAvanti();
        attivaBottoneDietro();
    }

    public Button getForward() {
        return forward;
    }

    public Button getBack() {
        return back;
    }

    private void attivaBottoneAvanti(){
        forward.setOnAction(actionEvent -> {
            mg.scorriFilm(true);
        });
    }

    private void attivaBottoneDietro(){
        back.setOnAction(actionEvent -> {
            mg.scorriFilm(false);
        });
    }
}