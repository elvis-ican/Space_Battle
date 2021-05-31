package com.elvis.game.spacebattle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Checking {
    public JFrame frame;
    public Canvas2 canvas;
    int color = 0;

    public static void main(String[] args) throws Exception {
        Checking checking = new Checking(45,45);
        checking.canvas.fillMatrix(1);
        checking.canvas.repaint();
        checking.run();
    }

    public Checking(int width, int height) {
        frame = new JFrame();
        canvas = new Canvas2(width, height);
        frame.setTitle("Space Battle");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(570, 640);
        frame.setResizable(false);
        frame.add(canvas);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static class Canvas2 extends JPanel {
        private int score;
        private int maxScore;
        private int width;
        private int height;
        private int[][] matrix;
        private final Color BG_COLOR = new Color(0x202020);
        private static final String FONT_NAME = "Arial";
        private static final int TILE_SIZE = 10;
        private static final int TILE_MARGIN = 1;
        private Color[] colors = {new Color(0x202020), new Color(0xCD5C5C), new Color(0x6495ED),
                Color.cyan, Color.magenta, Color.orange, new Color(0x40E0D0), Color.yellow, Color.pink};

        public Canvas2(int width, int height) {
            setFocusable(true);
            this.width = width;
            this.height = height;
            this.matrix = new int[height][width];
        }

        public void clear() {
            this.matrix = new int[height][width];
        }

        public void fillMatrix(int c) {
            for (int i = 0; i< height; i++) {
                for (int j = 0; j < width; j++) {
                    matrix[i][j] = c;
                }
            }
        }

        public void loadMatrix(int[][] matrix, int score, int maxScore) {
            this.score = score;
            this.maxScore = maxScore;
            for (int i = 0; i< height; i++) {
                for (int j = 0; j < width; j++) {
                    this.matrix[i][j] = matrix[i][j];
                }
            }
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
            g.setColor(Color.white);
            g.drawString("Score: " + score, 80, 560);
            g.drawString("Highest Score: " + maxScore, 400, 560);
            g.drawLine(60,580, 520, 580);
        }

        private void drawTile(Graphics g2, int color, int x, int y) {
            Graphics2D g = ((Graphics2D) g2);
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int xOffset = offsetCoors(x);
            int yOffset = offsetCoors(y);
            g.setColor(colors[color]);
            g.fillRoundRect(xOffset, yOffset, TILE_SIZE, TILE_SIZE, 3, 3);
        }

        private static int offsetCoors(int arg) {
            return arg * (TILE_MARGIN + TILE_SIZE) + TILE_MARGIN;
        }

    }

    public void run() throws Exception {
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();
        while(true) {
            if (keyboardObserver.hasKeyEvents()) {
                KeyEvent event = keyboardObserver.getEventFromTop();
                if (event.getKeyCode() == KeyEvent.VK_ESCAPE)
                    System.exit(0);
                else if (event.getKeyCode() == KeyEvent.VK_UP) {
                    color++;
                    canvas.fillMatrix(color);
                    canvas.repaint();
                }
            }
        }
    }
}