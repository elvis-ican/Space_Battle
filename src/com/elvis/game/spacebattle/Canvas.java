package com.elvis.game.spacebattle;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {
    private int width;
    private int height;
    private int[][] matrix;
    private static final Color BG_COLOR = new Color(0x808080);
    private static final String FONT_NAME = "Arial";
    private static final int TILE_SIZE = 10;
    private static final int TILE_MARGIN = 1;
    private Color[] colors = {new Color(0x202020),new Color(0xCD5C5C), new Color(0x6495ED),
            Color.cyan, Color.magenta, Color.orange, new Color(0x40E0D0), Color.yellow, Color.pink};

    public Canvas(int width, int height) {
        setFocusable(true);
        this.width = width;
        this.height = height;
        this.matrix = new int[height][width];
    }

    public void clear() {
        this.matrix = new int[height][width];
    }

    public void drawMatrix(double x, double y, int[][] matrix, int c) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    setPoint(x + j, y + i, matrix[i][j]);
                }
            }
        }
    }

    public void setPoint(double x, double y, int c) {
        int xRounded = (int) Math.round(x);
        int yRounded = (int) Math.round(y);
        if (xRounded >= 0 && xRounded < matrix[0].length && yRounded >= 0 && yRounded < matrix.length) {
            matrix[yRounded][xRounded] = c;
        }
    }

 /*   public void print() {
        System.out.println();

        for (int i = 0; i < height + 2; i++) {
            for (int j = 0; j < width + 2; j++) {
                System.out.print(" ");
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }

            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println();
    }
*/

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getMatrix() {
        return matrix;
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(BG_COLOR);
        g.fillRect(0, 0, this.getSize().width, this.getSize().height);
        for (int x = 0; x < matrix[0].length; x++) {
            for (int y = 0; y < matrix.length; y++) {
                drawTile(g, matrix[y][x], x, y);
            }
        }
    }

    private void drawTile(Graphics g2, int color, int x, int y) {
        Graphics2D g = ((Graphics2D) g2);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int xOffset = offsetCoors(x);
        int yOffset = offsetCoors(y);
        g.setColor(colors[color]);
        g.fillRoundRect(xOffset, yOffset, TILE_SIZE, TILE_SIZE , 0, 0);
    }

    private static int offsetCoors(int arg) {
        return arg * (TILE_MARGIN + TILE_SIZE) + TILE_MARGIN;
    }

}
