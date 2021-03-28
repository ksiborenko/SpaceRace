package com.game.app.utils;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;


public class Hud {

    private Stage stage;
    private int playerOne;
    private int playerTwo;
    private final Label pointsOne;
    private final Label pointsTwo;

    public Hud() {
        this.playerOne = 0;
        this.playerTwo = 0;
        this.stage = new Stage();
        this.pointsOne = new Label(String.format("%01d", this.playerOne), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        this.pointsTwo = new Label(String.format("%01d", this.playerTwo), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Table table = new Table();
        table.top();
        table.setFillParent(true);
        table.add(pointsOne).expandX().padTop(10);
        table.add(pointsTwo).expandX().padTop(10);
        this.stage.addActor(table);
    }

    public void updatePoints() {
    }

    public Stage getStage() {
        return stage;
    }
}