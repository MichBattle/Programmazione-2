package Model;

import javafx.scene.control.Alert;

public class AlertDisplayer {
    public static void display_error_alert(String s){
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setHeaderText("ATTENZIONE");
        a.setTitle("ERRORE");
        a.setContentText(s);
        a.show();
    }
}
