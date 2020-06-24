package com.iftakharopu.minitennis;

import java.awt.*;

/**
 * Created by iftakharopu on 2016-07-02.
 */
public class Ball {

    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;

    private static final int DIAMETER = 60;

    private Game game;

    public Ball(Game game) {
        this.game = game;
    }

    public void move() {
        if (x + xa < 0)
            xa = 1;
        if (x + xa > game.getWidth() - DIAMETER)
            xa = -1;
        if (y + ya < 0)
            ya = 1;
        if (y + ya > game.getHeight() - DIAMETER)
            game.gameOver();
        if (collision()) {
            ya = -1;
            y = game.racquet.getTopY() - DIAMETER;
        }
        x = x + xa;
        y = y + ya;
    }

    public void paint(Graphics2D graphics2D) {
        graphics2D.setColor(Color.GREEN);
        graphics2D.fillOval(x, y, 60, 60);
    }

    private boolean collision() {
        return game.racquet.getBounds().intersects(getBounds());
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}
