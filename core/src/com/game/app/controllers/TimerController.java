package com.game.app.controllers;

import com.game.app.objects.Timer;
import com.game.app.utils.ScoreCounter;

public class TimerController {

    private Timer timer;

    public TimerController(Timer timer) {
        this.timer = timer;
    }

    public void timeCheck(ScoreCounter scoreCounter) {
        if (timer.getY() + timer.getHeight() < 0) {
            timer.setPosition(0);
            scoreCounter.setPlayerOnePoints(0);
            scoreCounter.setPlayerTwoPoints(0);
        }
    }
}
