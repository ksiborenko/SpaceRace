package com.game.app.controllers;

import com.game.app.objects.Ship;
import com.game.app.utils.CollisionDetector;

public class ShipController {

    private final CollisionDetector detector;
    private final Ship ship;
    private final int height;

    public ShipController(CollisionDetector detector, Ship ship, int height) {
        this.detector = detector;
        this.ship = ship;
        this.height = height;
    }

    public void setPosition(int yPosition) {
        if (this.detector.check() || this.ship.getY() > this.height|| this.ship.getY() < yPosition) {
            this.ship.setPosition(yPosition);
        }
    }
}
