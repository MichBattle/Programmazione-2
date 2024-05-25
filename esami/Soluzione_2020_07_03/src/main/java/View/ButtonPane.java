package View;

import Controller.MainGUI;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ButtonPane extends HBox {
    private Button prev;
    private Button next;

    public ButtonPane(MainGUI mg) {
        super();
        prev = new Button("<prev");
        next = new Button("next>");
        prev.setDisable(true);

        setPrevAction(mg);
        setNextAction(mg);

        super.getChildren().addAll(prev, next);
    }

    private void setPrevAction(MainGUI mg){
        prev.setOnAction(event -> {
            MainGUI.decrementGeneralIndex();
            aggiornaTutto(mg);

            if(MainGUI.getGeneralIndex() == 0)
                prev.setDisable(true);
            else if(MainGUI.getGeneralIndex() < 5)
                next.setDisable(false);
        });
    }

    private void setNextAction(MainGUI mg){
        next.setOnAction(event -> {
            MainGUI.incrementGeneralIndex();
            aggiornaTutto(mg);

            if(MainGUI.getGeneralIndex() == 5)
                next.setDisable(true);
            else if(MainGUI.getGeneralIndex() > 0)
                prev.setDisable(false);
        });
    }

    private void aggiornaTutto(MainGUI mg){
        mg.getTestoPane().aggiornaTesto();
        mg.getPiastrellaCorrente().aggiornaPiastrellaMostrata();
    }
}
