package com.snake;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.Group;

public class Food {
    private static Rectangle food = new Rectangle(10, 10, Color.RED);

    public Food() {
        App.root.getChildren().add(food);
    }

    public void generateFood() {
        // food shouldnt be generated on the snake
        int x = App.random.nextInt(50) * 10;
        int y = App.random.nextInt(50) * 10;
        food.setX(x);
        food.setY(y);
    }

    public void getFoodLocation() {
        // return food location
        System.out.println(food.getX());
        System.out.println(food.getY());
    }

    public static double getFoodX() {
        return food.getX();
    }

    public static double getFoodY() {
        return food.getY();
    }
}
