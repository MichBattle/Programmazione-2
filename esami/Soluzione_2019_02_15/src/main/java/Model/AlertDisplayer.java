package Model;

import javafx.scene.control.Alert;

public class AlertDisplayer {
    public static void display_ERROR_alert(String s){
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("ERRORE");
        a.setContentText(s);
        System.out.println(s);
        a.showAndWait();
    }
}
