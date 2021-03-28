package com.game.app.utils;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.game.app.objects.Ship;


public class Hud {

    private Stage stage;
    private final Label pointsOne;
    private final Label pointsTwo;
    private ScoreCounter scoreCounter;

    public Hud(Ship playerOne, Ship playerTwo, int height) {
        this.stage = new Stage();
        this.scoreCounter = new ScoreCounter(playerOne, playerTwo, height);
        this.pointsOne = new Label(String.format("%01d", this.scoreCounter.getPlayerOnePoints()), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        this.pointsTwo = new Label(String.format("%01d", this.scoreCounter.getPlayerTwoPoints()), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Table table = new Table();
        table.top();
        table.setFillParent(true);
        table.add(pointsOne).expandX().padTop(10);
        table.add(pointsTwo).expandX().padTop(10);
        this.stage.addActor(table);
    }

    public void updatePoints() {
        this.pointsOne.setText(this.scoreCounter.getPlayerOnePoints());
        this.pointsTwo.setText(this.scoreCounter.getPlayerTwoPoints());
        this.scoreCounter.count();
    }

    public Stage getStage() {
        return stage;
    }
}