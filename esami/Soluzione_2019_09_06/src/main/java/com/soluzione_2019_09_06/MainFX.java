package com.soluzione_2019_09_06;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFX extends Application {
    private final static double LATO_EMPTY_FIGURE = 40;
    private final static double LATO_TRIANGOLO = 30;
    private final static double RAGGIO_CERCHIO = 30;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainFX.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static double getLATO_EMPTY_FIGURE() {
        return LATO_EMPTY_FIGURE;
    }

    public static double getLATO_TRIANGOLO() {
        return LATO_TRIANGOLO;
    }

    public static double getRAGGIO_CERCHIO() {
        return RAGGIO_CERCHIO;
    }

    public static void main(String[] args) {
        launch();
    }
}