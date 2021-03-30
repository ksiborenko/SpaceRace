package com.game.app.utils;

import com.badlogic.gdx.utils.Array;
import com.game.app.objects.Obstacle;
import com.game.app.objects.ShapeAbstract;
import com.game.app.objects.Ship;

public class CollisionDetector {

    private final Array<Obstacle> listOne;
    private final Array<Obstacle> listTwo;
    private final Ship ship;

    public CollisionDetector(Array<Obstacle> listOne, Array<Obstacle> listTwo, Ship ship) {
        this.listOne = listOne;
        this.listTwo = listTwo;
        this.ship = ship;
    }

    public boolean check() {
        for (int obstacleIndex = 0; obstacleIndex < this.listOne.size; obstacleIndex++) {
            if (check(this.listOne.get(obstacleIndex), this.ship) ||
                    check(this.listTwo.get(obstacleIndex), this.ship)) {
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
