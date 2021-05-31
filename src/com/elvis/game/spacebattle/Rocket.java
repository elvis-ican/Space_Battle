package com.elvis.game.spacebattle;

/**
 * Rocket class
 */
public class Rocket extends BaseObject {

    public Rocket(double x, double y) {
        super(x, y, 1);
    }

    /**
     * This method draws the object on the canvas.
     */
    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(x, y, 1);
    }

    /**
     * Move the object up by one step.
     */
    @Override
    public void move() {
        y--;
    }
}