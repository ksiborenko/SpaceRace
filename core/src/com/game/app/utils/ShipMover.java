package com.game.app.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.game.app.objects.Ship;

public class ShipMover {

    private final Ship shipOne;
    private final Ship shipTwo;

    public ShipMover(Ship shipOne, Ship shipTwo) {
        this.shipOne = shipOne;
        this.shipTwo = shipTwo;
    }

    public void move() {
        int shipSpeed = 2;
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            this.shipOne.move(shipSpeed, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            this.shipOne.move(-shipSpeed, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            this.shipTwo.move(shipSpeed, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            this.shipTwo.move(-shipSpeed, 0);
        }

    }
}
