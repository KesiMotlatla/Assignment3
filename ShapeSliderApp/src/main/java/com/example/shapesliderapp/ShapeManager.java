// ShapeManager.java
package com.example.shapesliderapp;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class ShapeManager {

    private Shape[] shapes;
    private int currentIndex = 0;
    private Shape currentShape;
    private double initialX, initialY;

    public ShapeManager() {
        // Create shapes
        shapes = new Shape[]{
                createTriangle(80),
                createRectangle(200, 200),
                createCircle(80)
        };
        currentShape = shapes[currentIndex];
    }

    private Shape createTriangle(double size) {
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(size / 2.0, 0.0,size, size,0.0, size);
        return triangle;
    }

    private Shape createRectangle(double width, double height) {
        Rectangle rectangle = new Rectangle(width, height);
        return rectangle;
    }

    private Shape createCircle(double radius) {
        Circle circle = new Circle(radius);
        return circle;
    }

    public Shape getCurrentShape() {
        return currentShape;
    }

    public void startDragging(double x, double y) {
        initialX = x;
        initialY = y;
    }

    public void dragShape(double x, double y) {
        double offsetX = x - initialX;
        double offsetY = y - initialY;
        currentShape.setLayoutX(currentShape.getLayoutX() + offsetX);
        currentShape.setLayoutY(currentShape.getLayoutY() + offsetY);
        initialX = x;
        initialY = y;
    }

    public void showPreviousShape() {
        currentIndex = (currentIndex - 1 + shapes.length) % shapes.length;
        currentShape = shapes[currentIndex];
    }

    public void showNextShape() {
        currentIndex = (currentIndex + 1) % shapes.length;
        currentShape = shapes[currentIndex];
    }

    public Color generateRandomColor() {
        return Color.rgb(
                (int) (Math.random() * 256),
                (int) (Math.random() * 256),
                (int) (Math.random() * 256)
        );
    }
}


