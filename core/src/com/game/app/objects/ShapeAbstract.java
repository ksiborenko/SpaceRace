package com.game.app.objects;

public class ShapeAbstract {

    private float x;
    private float y;
    private final float width;
    private final float height;

    protected ShapeAbstract(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void move(float ySpeed, float xSpeed) {
        this.y += ySpeed;
        this.x += xSpeed;
    }

    public void setPosition(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
