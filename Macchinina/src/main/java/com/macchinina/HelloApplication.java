package com.macchinina;

import View.KeyHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MainGUI mg = new MainGUI();
        Scene scene = new Scene(mg, 310, 400);
        KeyHandler kh = new KeyHandler(scene, mg);
        kh.handleKeysPressed();
        stage.setTitle("MACCHININA!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}