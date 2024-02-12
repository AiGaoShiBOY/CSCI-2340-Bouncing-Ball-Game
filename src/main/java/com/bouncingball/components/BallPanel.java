package com.bouncingball.components;

import com.bouncingball.entity.Ball;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.bouncingball.constants.GameSettings.*;

/**
 * Ball Panel
 *
 * @author FinnerLi 2/11/24 yuanfeng_li@brown.edu
 **/
public class BallPanel extends JPanel {
    private final List<Ball> balls = new ArrayList<>();


    public BallPanel() {
        setOpaque(false);
        Timer timer = new Timer(50, e -> repaint());
        timer.start();
    }

    /**
     * add a ball to the panel
     * @param newBall
     */
    public void addBall(Ball newBall) {
        balls.add(newBall);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball ball : balls) {
            ball.move(getBounds());
            g.setColor(ball.getColor());
            g.fillOval(ball.getX(), ball.getY(), ball.getSize(), ball.getSize());
        }
    }
}
