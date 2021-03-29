package com.game.app.utils;

import com.badlogic.gdx.utils.Array;
import com.game.app.objects.Obstacle;
import com.game.app.objects.ShapeAbstract;
import com.game.app.objects.Ship;

public class CollisionDetector {

    private Array<Obstacle> listOne;
    private Array<Obstacle> listTwo;
    private Ship playerOne;
    private Ship playerTwo;

    public CollisionDetector(Array<Obstacle> listOne, Array<Obstacle> listTwo, Ship playerOne, Ship playerTwo) {
        this.listOne = listOne;
        this.listTwo = listTwo;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public boolean checkPlayerOne() {
        for (int obstacleIndex = 0; obstacleIndex < this.listOne.size; obstacleIndex++) {
            if (check(this.listOne.get(obstacleIndex), this.playerOne) ||
                    check(this.listTwo.get(obstacleIndex), this.playerOne)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkPlayerTwo() {
        for (int obstacleIndex = 0; obstacleIndex < this.listOne.size; obstacleIndex++) {
            if (check(this.listOne.get(obstacleIndex), this.playerTwo) ||
                    check(this.listTwo.get(obstacleIndex), this.playerTwo)) {
                return true;
            }
        }
        return false;
    }


    private boolean check(ShapeAbstract shapeOne, ShapeAbstract shapeTwo) {
        return shapeOne.getX() + shapeOne.getWidth() > shapeTwo.getX() &&
                shapeOne.getX() < shapeTwo.getX() + shapeTwo.getWidth() &&
                shapeOne.getY() + shapeOne.getHeight() > shapeTwo.getY() &&
                shapeOne.getY() < shapeTwo.getY() + shapeTwo.getHeight();
    }
}
