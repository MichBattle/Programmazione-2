package Model;

import javafx.application.Platform;
import javafx.scene.control.Alert;

public class AlertDisplayer {
    public static void display_INFO_Alert(String s){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("ATTENZIONE!");
        a.setContentText(s);
        a.show();
    }

    public static void display_LOOSE_Alert(){
        String s = "Peccato, hai perso!";
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("GAME OVER!");
        a.setContentText(s);
        System.out.println(s);
        a.showAndWait();
        a.setOnCloseRequest(event -> Platform.exit());
    }

    public static void display_WIN_Alert(){
        String s = "Complimenti, hai vinto!";
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("GAME OVER!");
        a.setContentText(s);
        System.out.println(s);
        a.showAndWait();
    }
}
