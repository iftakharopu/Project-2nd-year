package com.iftakharopu.minitennis;

import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Mattias on 2014-09-02.
 */
public class Game extends JPanel {

    Ball ball = new Ball(this);
    Racquet racquet = new Racquet(this);

    public Game() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(ABORT);
                }
                racquet.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                racquet.keyReleased(e);
            }
        });
        setFocusable(true);
    }
    private void move() {
        ball.move();
        racquet.move();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(graphics2D);
        racquet.paint(graphics2D);
    }

    public void gameOver() {
        JOptionPane.showMessageDialog(this, "Game Over!!!!!", "haha you lost the game!", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Mini Tennis...");
        Game game = new Game();
        frame.add(game);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            game.move();
            game.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
