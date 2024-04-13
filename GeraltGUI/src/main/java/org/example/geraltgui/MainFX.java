package org.example.geraltgui;

import View.MainGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.geralt.Geralt;

public class MainFX extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        Geralt g = new Geralt();
        MainGUI layout = new MainGUI(g);
        Scene scene = new Scene(layout, 300, 300);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}