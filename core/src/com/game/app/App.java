package com.game.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.game.app.controllers.GameController;

public class App extends Game {

    public static final int HEIGHT = 800;
    public static final int WIDTH = 800;
    public ShapeRenderer shapeRenderer;

    @Override
    public void create() {
        this.shapeRenderer = new ShapeRenderer();
        this.setScreen(new GameController(this, WIDTH, HEIGHT));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
