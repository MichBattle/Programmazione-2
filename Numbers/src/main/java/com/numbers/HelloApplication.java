package com.numbers;

import Controller.MainGUI;
import View.KeyHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MainGUI mg = new MainGUI();
        Scene scene = new Scene(mg, 250, 300);
        KeyHandler kh = new KeyHandler(scene, mg);
        kh.handleKeysEvent();
        stage.setTitle("Numbers!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}