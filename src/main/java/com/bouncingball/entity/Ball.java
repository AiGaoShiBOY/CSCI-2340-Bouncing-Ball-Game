package com.bouncingball.entity;
import lombok.Builder;
import lombok.Data;
import java.awt.*;
import java.util.Random;

/**
 * Ball class
 * @author FinnerLi 2/11/24 yuanfeng_li@brown.edu
 **/
@Data
@Builder
public class Ball {

    private int x;

    private int y;

    private int velocity;

    private int size;

    private Color color = Color.BLACK;


    /**
     * ball movement
     * @param bounds
     */
    public void move(Rectangle bounds) {
        if (x < bounds.getX() || x > bounds.getWidth() - size) {
            setVelocity(-velocity);
            setX(x + velocity);
            setY(y + velocity);
            return;
        }
        if (y < bounds.getY() || y > bounds.getHeight() - size){
            setVelocity(-velocity);
            setX(x + velocity);
            setY(y + velocity);
            return;
        }
        setX(x + velocity);
        setY(y + velocity);
    }

}
