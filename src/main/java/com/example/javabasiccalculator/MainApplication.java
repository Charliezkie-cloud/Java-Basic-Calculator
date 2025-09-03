package com.example.javabasiccalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 689, 520);
        stage.setMinHeight(520);
        stage.setMinWidth(689);
        stage.setTitle("Java Basic Calculator by Charles Henry M. Tinoy Jr.");
        stage.setScene(scene);
        stage.show();
    }
}
