package org.example.soluzione_2019_01_18;

import Controller.MainGUI;
import Model.Tessere.TesseraP;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFX extends Application {
    private static int LATO = 4;
    @Override
    public void start(Stage stage) throws IOException {
        MainGUI mg = new MainGUI();
        Scene scene = new Scene(mg, 320, 240);
        stage.setTitle("Play the game!");
        stage.setScene(scene);
        stage.show();
    }

    public static int getLATO() {
        return LATO;
    }

    public static void main(String[] args) {
        launch();
    }
}