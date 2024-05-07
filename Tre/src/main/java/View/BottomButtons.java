package View;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BottomButtons extends HBox {
    private Button clearAll;
    private Button check;
    private MainGUI mg;

    public BottomButtons(MainGUI mg) {
        super();
        this.mg = mg;

        clearAll = new Button("Clear All");
        check = new Button("Check");

        setClearAllAction();
        setCheckAction();

        super.getChildren().addAll(clearAll, check);
        super.setSpacing(10);
    }

    private void setClearAllAction(){
        clearAll.setOnAction(actionEvent -> {
            clearAction();
        });
    }

    private void setCheckAction(){
        check.setOnAction(actionEvent -> {
            checkAction();
        });
    }

    public void clearAction(){
        ArrayList<Cella> c = mg.getCells();
        for(Cella cella : c){
            cella.setForma(cella.getB().getEmpty());
        }
    }

    public void checkAction(){
        Coordinate c = mg.getCoords();
        if(c != null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("$$$");
            String s = (c.isRiga())? "RIGA" : "COLONNA";
            alert.setContentText("TRE UGUALI IN " + s + " " + c.getX());
            alert.showAndWait();
        }
    }
}
