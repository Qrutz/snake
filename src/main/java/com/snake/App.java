package com.snake;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

/**
 * JavaFX App
 */
public class App extends Application {

    public static Scene scene;

    static Group root = new Group();
    static Random random = new Random();
    static Snake snake = new Snake();

    @Override
    public void start(Stage stage) throws IOException {

        scene = new Scene(root, 500, 500, Color.BLACK);
        stage.setScene(scene);
        stage.show();

        Food food = new Food();
        food.generateFood();

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP) {
                snake.moveUp();
                if (isSnakeEatingFood()) {
                    food.generateFood();
                    snake.grow();
                }
            } else if (event.getCode() == KeyCode.DOWN) {
                snake.moveDown();
                if (isSnakeEatingFood()) {
                    food.generateFood();
                    snake.grow();
                }
            } else if (event.getCode() == KeyCode.RIGHT) {
                snake.moveRight();
                if (isSnakeEatingFood()) {
                    food.generateFood();
                    snake.grow();
                }
            } else if (event.getCode() == KeyCode.LEFT) {
                snake.moveLeft();
                if (isSnakeEatingFood()) {
                    food.generateFood();
                    snake.grow();
                }
            }
        });

    }

    public boolean isSnakeEatingFood() {
        if (snake.getSnakeHeadX() == Food.getFoodX() && snake.getSnakeHeadY() == Food.getFoodY()) {
            return true;
        } else {
            return false;
        }
    }

    public static void generateFood() {
        // food shouldnt be generated on the snake
        int x = random.nextInt(50) * 10;
        int y = random.nextInt(50) * 10;

        Rectangle food = new Rectangle(10, 10, Color.RED);
        food.setX(x);
        food.setY(y);
        root.getChildren().add(food);

    }

    public static void main(String[] args) {
        launch();
    }

}