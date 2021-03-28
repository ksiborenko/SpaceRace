package com.game.app.utils;

import com.game.app.objects.Ship;

public class ScoreCounter {

    private final Ship playerOne;
    private final Ship playerTwo;
    private final int height;
    private int playerOnePoints;
    private int playerTwoPoints;

    public ScoreCounter(Ship playerOne, Ship playerTwo, int height) {
        this.playerOnePoints = 0;
        this.playerTwoPoints = 0;
        this.height = height;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void count() {
        if (this.playerOne.getY() > height) {
            this.playerOnePoints++;
        }
        if (this.playerTwo.getY() > height) {
            this.playerTwoPoints++;
        }
    }

    public int getPlayerOnePoints() {
        return playerOnePoints;
    }

    public int getPlayerTwoPoints() {
        return playerTwoPoints;
    }
}
