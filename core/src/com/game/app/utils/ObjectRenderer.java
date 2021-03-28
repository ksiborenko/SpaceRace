package com.game.app.utils;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.game.app.controllers.ObstacleController;
import com.game.app.objects.Ship;
import com.game.app.objects.Timer;

public class ObjectRenderer {


    public void render(ShapeRenderer renderer, ObstacleController obstacleController, Timer timer, Ship playerOne, Ship playerTwo) {
        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.rect(timer.getX(), timer.getY(), timer.getWidth(), timer.getHeight());
        renderer.rect(playerOne.getX(), playerOne.getY(), playerOne.getWidth(), playerOne.getHeight());
        renderer.rect(playerTwo.getX(), playerTwo.getY(), playerTwo.getWidth(), playerTwo.getHeight());

        for (int obstacleIndex = 0; obstacleIndex < obstacleController.getObstacleNumber(); obstacleIndex++) {
            renderer.rect(obstacleController.getObstaclesRight().get(obstacleIndex).getX(),
                    obstacleController.getObstaclesRight().get(obstacleIndex).getY(),
                    obstacleController.getObstaclesRight().get(obstacleIndex).getWidth(),
                    obstacleController.getObstaclesRight().get(obstacleIndex).getHeight());
            renderer.rect(obstacleController.getObstaclesLeft().get(obstacleIndex).getX(),
                    obstacleController.getObstaclesLeft().get(obstacleIndex).getY(),
                    obstacleController.getObstaclesLeft().get(obstacleIndex).getWidth(),
                    obstacleController.getObstaclesLeft().get(obstacleIndex).getHeight());
        }
        renderer.end();
    }
}
