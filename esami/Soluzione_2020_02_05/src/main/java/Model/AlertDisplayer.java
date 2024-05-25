package Model;

import javafx.scene.control.Alert;

public class AlertDisplayer {
    public static void displayAlertWin(){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("VITTORIA");
        a.setHeaderText("Vittoria");
        a.setContentText("Complimenti, hai vinto!");
        a.show();
    }

    public static void displayAlertDraw(){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("PAREGGIO");
        a.setHeaderText("Pareggio");
        a.setContentText("Hai pareggiato!");
        a.show();
    }

    public static void displayAlertLoose(){
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("SCONFITTA");
        a.setHeaderText("Sconfitta");
        a.setContentText("Mi dispiace, hai perso!");
        a.show();
    }
}
