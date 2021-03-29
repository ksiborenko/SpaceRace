package com.game.app.controllers;

import com.badlogic.gdx.utils.Array;
import com.game.app.objects.Obstacle;

import java.util.Random;

public class ObstacleController {

    private final Array<Obstacle> obstaclesRight;
    private final Array<Obstacle> obstaclesLeft;
    private final float screenWidth;
    private final float screenHeight;
    private final float obstacleWidth;
    private final float obstacleHeight;
    private final int obstacleNumber;
    private final Random random;


    public ObstacleController(float screenWidth, float screenHeight, float obstacleWidth, float obstacleHeight) {
        this.obstacleNumber = 15;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.obstacleWidth = obstacleWidth;
        this.obstacleHeight = obstacleHeight;
        this.obstaclesRight = new Array<>();
        this.obstaclesLeft = new Array<>();
        random = new Random();
        for (int obstacleIndex = 0; obstacleIndex < this.obstacleNumber; obstacleIndex++) {
            this.obstaclesRight.add(new Obstacle(random.nextInt((int) screenWidth) + screenWidth,
                    random.nextInt((int) screenHeight - 100) + 100, obstacleWidth, obstacleHeight));
            this.obstaclesLeft.add(new Obstacle(random.nextInt((int) screenWidth) - screenWidth,
                    random.nextInt((int) screenHeight - 100) + 100, obstacleWidth, obstacleHeight));
        }

    }

    public void update(int xSpeed) {
        for (int obstacleIndex = 0; obstacleIndex < this.obstacleNumber; obstacleIndex++) {
            if (obstaclesRight.get(obstacleIndex).getX() < 0) {
                this.obstaclesRight.removeIndex(obstacleIndex);
                this.obstaclesRight.add(new Obstacle(random.nextInt((int) screenWidth) + screenWidth,
                        random.nextInt((int) screenHeight - 100) + 100, obstacleWidth, obstacleHeight));
            }
        }
        for (int obstacleIndex = 0; obstacleIndex < this.obstacleNumber; obstacleIndex++) {
            if (obstaclesLeft.get(obstacleIndex).getX() > this.screenWidth) {
                this.obstaclesLeft.removeIndex(obstacleIndex);
                this.obstaclesLeft.add(new Obstacle(random.nextInt((int) screenWidth) - screenWidth,
                        random.nextInt((int) screenHeight - 100) + 100, obstacleWidth, obstacleHeight));

            }
        }
        this.move(xSpeed);
    }

    private void move(int xSpeed) {
        for (int obstacleIndex = 0; obstacleIndex < this.obstacleNumber; obstacleIndex++) {
            this.obstaclesRight.get(obstacleIndex).move(0, -xSpeed);
            this.obstaclesLeft.get(obstacleIndex).move(0, xSpeed);

        }
    }

    public Array<Obstacle> getObstaclesRight() {
        return obstaclesRight;
    }

    public Array<Obstacle> getObstaclesLeft() {
        return obstaclesLeft;
    }

    public int getObstacleNumber() {
        return obstacleNumber;
    }
}
