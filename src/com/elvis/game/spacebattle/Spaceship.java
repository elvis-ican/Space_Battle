package com.elvis.game.spacebattle;

/**
 * Spaceship class
 */
public class Spaceship extends BaseObject {
    // Picture to draw the ship
    private static int[][] matrix = {
            {0, 0, 0, 0, 0},
            {0, 0, 5, 0, 0},
            {0, 0, 4, 0, 0},
            {3, 0, 4, 0, 3},
            {4, 4, 4, 4, 4},
    };

    // movement vector (-1 — left, +1 — right)
    private double dx = 0;

    public Spaceship(double x, double y) {
        super(x, y, 3);
    }

    /**
     * Set the movement vector to move left
     */
    public void moveLeft() {
        dx = -1;
    }

    /**
     * Set the movement vector to move right
     */
    public void moveRight() {
        dx = 1;
    }

    /**
     * This method draws the object on the canvas.
     */
    @Override
    public void draw(Canvas canvas) {
        canvas.drawMatrix(x - radius + 1, y - radius + 1, matrix, 'M');
    }

    /**
     * Move by one step.
     * Check for collision with the edges.
     */
    @Override
    public void move() {
        x = x + dx;

        checkBorders(radius, Space.game.getWidth() - radius, 1, Space.game.getHeight() + 1);
    }

    /**
     * We're shooting.
     * Create two rockets: on the left and right of the ship.
     */
    public void fire() {
        Space.game.getRockets().add(new Rocket(x - 2, y));
        Space.game.getRockets().add(new Rocket(x + 2, y));
    }
}