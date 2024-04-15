package org.example.luckyclick;

import Model.Gioco;
import View.MainGUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFX extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Gioco g = new Gioco();
        MainGUI layout = new MainGUI(g);
        g.stampaTabellone();
        Scene scene = new Scene(layout, 700, 700);
        stage.setScene(scene);
        stage.setTitle("Lucky Click!");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}