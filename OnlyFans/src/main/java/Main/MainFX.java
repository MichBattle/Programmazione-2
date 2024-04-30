package Main;

import View.MainGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFX extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        MainGUI layout = new MainGUI();
        Scene scene = new Scene(layout, 500, 300);
        stage.setTitle("OnlyFans");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}