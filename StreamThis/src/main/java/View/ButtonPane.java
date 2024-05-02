package View;

import javafx.scene.control.Button;

public class ButtonPane {
    private MainGUI mg;

    private Button forward;
    private Button back;

    private Button clear;

    public ButtonPane(MainGUI mg) {
        this.mg = mg;
        forward = new Button(">");
        back = new Button("<");

        clear = new Button("Clear");

        attivaBottoneAvanti();
        attivaBottoneDietro();
        attivaClear();
    }

    public Button getForward() {
        return forward;
    }

    public Button getBack() {
        return back;
    }

    public Button getClear() {
        return clear;
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

    private void attivaClear(){
        clear.setOnAction(actionEvent -> {
            mg.resetAll();
        });
    }
}