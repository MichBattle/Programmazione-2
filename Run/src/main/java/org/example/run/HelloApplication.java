package org.example.run;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.KeyHandler;
import view.MainGUI;

import java.io.IOException;

public class HelloApplication extends Application {
    public static final int WIDTH = 500;
    public static final int HEIGTH = 200;

    @Override
    public void start(Stage stage) throws IOException {
        MainGUI layout = new MainGUI();
        Scene scene = new Scene(layout, WIDTH, HEIGTH);

        KeyHandler kh = new KeyHandler(scene, layout);
        kh.handle_keys_pressed();
        stage.setTitle("Run!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}