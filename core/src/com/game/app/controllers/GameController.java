package com.game.app.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.game.app.App;
import com.game.app.objects.Ship;
import com.game.app.objects.Timer;
import com.game.app.utils.CollisionDetector;
import com.game.app.utils.Hud;
import com.game.app.utils.ObjectRenderer;
import com.game.app.utils.ShipMover;

public class GameController implements Screen {

    public static final int yStartingPosition = 20;
    private final App app;
    private final Ship playerOne;
    private final Ship playerTwo;
    private final ShipMover shipMover;
    private final ObstacleController obstacleController;
    private final ObjectRenderer objectRenderer;
    private final Timer timer;
    private final Hud hud;
    private final CollisionDetector detectorPlayerOne;
    private final CollisionDetector detectorPlayerTwo;
    private final ShipController controllerPlayerOne;
    private final ShipController controllerPlayerTwo;
    private final TimerController timerController;

    public GameController(App app, float screenWidth, float screenHeight) {
        this.app = app;
        int shipWidth = 15;
        int shipHeight = 40;
        this.playerOne = new Ship(screenWidth / 3, yStartingPosition, shipWidth, shipHeight);
        this.playerTwo = new Ship(screenWidth / 3 * 2, yStartingPosition, shipWidth, shipHeight);
        this.shipMover = new ShipMover(this.playerOne, this.playerTwo);
        this.obstacleController = new ObstacleController(screenWidth, screenHeight, 4, 1);
        this.objectRenderer = new ObjectRenderer();
        this.timer = new Timer(screenWidth / 2, 0, 2, 450);
        this.hud = new Hud(this.playerOne, this.playerTwo, (int) screenHeight);
        this.detectorPlayerOne = new CollisionDetector(this.obstacleController.getObstaclesLeft(),
                this.obstacleController.getObstaclesRight(), this.playerOne);
        this.detectorPlayerTwo = new CollisionDetector(this.obstacleController.getObstaclesLeft(),
                this.obstacleController.getObstaclesRight(), this.playerTwo);
        this.controllerPlayerOne = new ShipController(this.detectorPlayerOne, this.playerOne, (int) screenHeight);
        this.controllerPlayerTwo = new ShipController(this.detectorPlayerTwo, this.playerTwo, (int) screenHeight);
        this.timerController = new TimerController(this.timer);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.objectRenderer.render(this.app.shapeRenderer, this.obstacleController, this.timer, this.playerOne, this.playerTwo);
        this.shipMover.move();
        this.obstacleController.update(2);
        this.timer.move(-0.1f, 0);
        this.hud.getStage().draw();
        this.hud.updatePoints();
        this.detectorPlayerOne.check();
        this.detectorPlayerTwo.check();
        this.controllerPlayerOne.setPosition(yStartingPosition);
        this.controllerPlayerTwo.setPosition(yStartingPosition);
        this.timerController.timeCheck(this.hud.getScoreCounter());
    }


    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
