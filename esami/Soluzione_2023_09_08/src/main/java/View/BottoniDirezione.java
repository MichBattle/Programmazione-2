package View;

import Controller.MainGUI;
import Model.AlertDisplayer;
import javafx.scene.control.Button;

public class BottoniDirezione {
    private Button back;
    private Button next;

    public BottoniDirezione(MainGUI mg) {
        super();
        back = new Button("<");
        next = new Button(">");
        setBackAction(mg);
        setNextAction(mg);
    }

    private void setNextAction(MainGUI mg) {
        next.setOnAction(event -> {
            MainGUI.incrementGeneralIndex();
            if(MainGUI.getGeneralIndex() > 4){
                AlertDisplayer.display_ERROR_Alert("Non puoi andare avanti");
                MainGUI.decrementGeneralIndex();
            } else
                mg.getTitoliPane().aggiornaTitoliPane();
        });
    }

    private void setBackAction(MainGUI mg) {
        back.setOnAction(event -> {
            MainGUI.decrementGeneralIndex();
            if(MainGUI.getGeneralIndex() < 0){
                AlertDisplayer.display_ERROR_Alert("Non puoi andare indietro");
                MainGUI.incrementGeneralIndex();
            } else
                mg.getTitoliPane().aggiornaTitoliPane();
        });
    }

    public Button getBack() {
        return back;
    }

    public Button getNext() {
        return next;
    }
}
