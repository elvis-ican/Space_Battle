package com.elvis.game.spacebattle;

/**
 * Bomb class
 */
public class Bomb extends BaseObject {
    public Bomb(double x, double y) {
        super(x, y, 1);
    }

    /**
     * Draw the object on the canvas.
     */
    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(x, y, 2);
    }

    /**
     * Move the object down by one step.
     */
    @Override
    public void move() {
        y++;
    }
}