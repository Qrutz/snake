package com.snake;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Group;

public class Snake {
    private int length = 3;

    // Use a List to store the body parts of the snake
    private List<Rectangle> bodyParts = new ArrayList<>();

    public Snake() {
        // Create the snake
        for (int i = 0; i < length; i++) {
            Rectangle bodyPart = new Rectangle(10, 10, Color.GREEN);
            bodyPart.setX(250 - i * 10);
            bodyPart.setY(250);
            bodyParts.add(bodyPart);
            App.root.getChildren().add(bodyPart);
        }
    }

    public boolean isSnakeEatingItself() {
        for (int i = 1; i < bodyParts.size(); i++) {
            if (bodyParts.get(0).getX() == bodyParts.get(i).getX()
                    && bodyParts.get(0).getY() == bodyParts.get(i).getY()) {
                return true;
            }
        }
        return false;
    }

    public void moveUp() {
        // account for when the snake grows
        for (int i = bodyParts.size() - 1; i >= 1; i--) {
            bodyParts.get(i).setX(bodyParts.get(i - 1).getX());
            bodyParts.get(i).setY(bodyParts.get(i - 1).getY());
        }
        bodyParts.get(0).setY(bodyParts.get(0).getY() - 10);

    }

    public void moveDown() {
        // account for when the snake grows
        for (int i = bodyParts.size() - 1; i >= 1; i--) {
            bodyParts.get(i).setX(bodyParts.get(i - 1).getX());
            bodyParts.get(i).setY(bodyParts.get(i - 1).getY());
        }
        bodyParts.get(0).setY(bodyParts.get(0).getY() + 10);

    }

    public void moveRight() {
        // account for when the snake grows
        for (int i = bodyParts.size() - 1; i >= 1; i--) {
            bodyParts.get(i).setX(bodyParts.get(i - 1).getX());
            bodyParts.get(i).setY(bodyParts.get(i - 1).getY());
        }
        bodyParts.get(0).setX(bodyParts.get(0).getX() + 10);

    }

    public void moveLeft() {

        // account for when the snake grows
        for (int i = bodyParts.size() - 1; i >= 1; i--) {
            bodyParts.get(i).setX(bodyParts.get(i - 1).getX());
            bodyParts.get(i).setY(bodyParts.get(i - 1).getY());
        }
        bodyParts.get(0).setX(bodyParts.get(0).getX() - 10);

    }

    public void eat() {
        // make snake longer by one rectangle , add it to the root
        this.length++;

    }

    public void grow() {
        // insert a rectangle between the tail and head of the snake and move the tail
        // forward
        Rectangle bodyPart = new Rectangle(10, 10, Color.GREEN);
        bodyPart.setX(bodyParts.get(bodyParts.size() - 1).getX());
        bodyPart.setY(bodyParts.get(bodyParts.size() - 1).getY());
        bodyParts.add(bodyPart);
        App.root.getChildren().add(bodyPart);

    }

    public double getSnakeHeadX() {
        return this.bodyParts.get(0).getX();
    }

    public double getSnakeHeadY() {
        return this.bodyParts.get(0).getY();
    }

}
