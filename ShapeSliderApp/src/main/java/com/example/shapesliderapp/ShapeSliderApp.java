package com.example.shapesliderapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ShapeSliderApp extends Application {

    @Override
    public void start(Stage primaryStage) {

        ShapeManager shapeManager = new ShapeManager();


        ShapePane shapePane = new ShapePane(shapeManager);


        primaryStage.setScene(new Scene(shapePane.getRoot(), 400, 400));
        primaryStage.setTitle("Shape Slider App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

