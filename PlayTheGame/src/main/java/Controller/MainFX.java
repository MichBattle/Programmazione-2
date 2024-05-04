package Controller;

import View.MainGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import java.util.Optional;

public class MainFX extends Application {
    @Override
    public void start(Stage stage) {
        int N;
        do{
            System.out.println("inserisci la dimensione della griglia: ");
            N = Integer.parseInt(InputDialog.getResponse());
            System.out.println("Hai inserito " + N + ((N < 3 || N > 9)? ",indice non valido, inserisci da 3 a 9" : "!"));
        }while(N < 3 || N > 9);

        MainGUI mg = new MainGUI(N);
        Scene scene = new Scene(mg, N*60, N*70);
        stage.setTitle("Play The Game!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


    public static class InputDialog {
        static String getResponse(){
           TextInputDialog dialog = new TextInputDialog();
           dialog.setHeaderText("inserisci la dimensione della griglia:");
           Optional<String> result = dialog.showAndWait();
            return result.orElse(null);
        }
    }
}