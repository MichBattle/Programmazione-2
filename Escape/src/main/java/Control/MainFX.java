package Control;

import View.KeyHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFX extends Application {
    public final static int SCENE_DIMENSION = 500;

    @Override
    public void start(Stage stage) throws IOException {
        MainGUI mg = new MainGUI();
        Scene scene = new Scene(mg, SCENE_DIMENSION, SCENE_DIMENSION);

        KeyHandler kh = new KeyHandler(scene, mg);
        kh.handleKeyPressed();

        stage.setTitle("Escape!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}