package Controller;

import View.MainGUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFX extends Application {
    public final static int ALTEZZA = 750;
    public final static int LARGHEZZA = 500;

    @Override
    public void start(Stage stage) throws IOException {
        MainGUI mg = new MainGUI();
        Scene scene = new Scene(mg, ALTEZZA, LARGHEZZA);
        stage.setTitle("Farmacia");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}