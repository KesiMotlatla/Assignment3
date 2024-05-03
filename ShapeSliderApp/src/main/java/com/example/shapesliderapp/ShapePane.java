package com.example.shapesliderapp;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ShapePane {

    private ShapeManager shapeManager;
    private Pane root;

    public ShapePane(ShapeManager shapeManager) {
        this.shapeManager = shapeManager;
        this.root = new Pane();


        root.getChildren().add(shapeManager.getCurrentShape());


        root.setOnMousePressed(event -> shapeManager.startDragging(event.getX(), event.getY()));
        root.setOnMouseDragged(event -> shapeManager.dragShape(event.getX(), event.getY()));


        Button previousBtn = new Button("Previous");
        previousBtn.setOnAction(e -> {
            shapeManager.showPreviousShape();
            root.getChildren().set(0, shapeManager.getCurrentShape()); // Replace the current shape
        });

        Button nextBtn = new Button("Next");
        nextBtn.setOnAction(e -> {
            shapeManager.showNextShape();
            root.getChildren().set(0, shapeManager.getCurrentShape()); // Replace the current shape
        });

        Button changeBackgroundBtn = new Button("Change Background");
        changeBackgroundBtn.setOnAction(e -> root.setBackground(new Background(new BackgroundFill(shapeManager.generateRandomColor(), CornerRadii.EMPTY, Insets.EMPTY))));


        HBox buttonBox = new HBox(10, previousBtn, nextBtn, changeBackgroundBtn);
        buttonBox.setPadding(new Insets(10));
        buttonBox.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));


        root.getChildren().add(buttonBox);
    }

    public Pane getRoot() {
        return root;
    }
}



