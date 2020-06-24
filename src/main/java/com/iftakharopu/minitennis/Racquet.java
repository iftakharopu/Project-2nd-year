package com.iftakharopu.minitennis;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by iftakharopu on 2016-07-02.
 */
public class Racquet {

    int x = 0;
    int xa = 1;

    private static final int Y = 500;
    private static final int WIDTH = 90;
    private static final int HEIGHT = 20;

    private Game game;

    public Racquet(Game game) {
        this.game = game;
    }

    public void move() {
        if (x + xa > 0 && x + xa < game.getWidth() - WIDTH)
            x = x + xa;
    }

    public void paint(Graphics2D graphics2D) {
        graphics2D.setColor(Color.BLACK);
        graphics2D.fillRect(x, Y, WIDTH, HEIGHT);
    }

    public void keyReleased(KeyEvent e) {
        xa = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            xa = -1;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            xa = 1;
    }

    public Rectangle getBounds() {

        return new Rectangle(x, Y, WIDTH, HEIGHT);
    }

    public int getTopY() {
        return Y;
    }


}
