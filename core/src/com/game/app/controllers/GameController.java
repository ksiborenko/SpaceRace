package com.game.app.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.game.app.App;
import com.game.app.objects.Ship;
import com.game.app.objects.Timer;
import com.game.app.utils.Hud;
import com.game.app.utils.ObjectRenderer;
import com.game.app.utils.ShipMover;

public class GameController implements Screen {

    private final App app;
    private float width;
    private final Ship playerOne;
    private final Ship playerTwo;
    private final ShipMover shipMover;
    private final ObstacleController obstacleController;
    private final ObjectRenderer objectRenderer;
    private final Timer timer;
    private final Hud hud;

    public GameController(App app, float width, float height) {
        this.app = app;
        this.width = width;
        this.playerOne = new Ship(width / 3, 20, 15, 40);
        this.playerTwo = new Ship(width / 3 * 2, 20, 15, 40);
        this.shipMover = new ShipMover(this.playerOne, this.playerTwo);
        this.obstacleController = new ObstacleController(width, height, 4, 1);
        this.objectRenderer = new ObjectRenderer();
        this.timer = new Timer(width / 2, 0, 2, 450);
        this.hud = new Hud(this.playerOne, this.playerTwo, (int) height);
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
