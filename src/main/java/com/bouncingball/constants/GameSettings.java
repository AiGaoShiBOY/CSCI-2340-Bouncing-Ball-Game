package com.bouncingball.constants;

/**
 * @author FinnerLi 2/11/24 yuanfeng_li@brown.edu
 **/
public interface GameSettings {
    int WINDOW_WIDTH = 1000;

    int WINDOW_HEIGHT = 1000;

    int DEFAULT_VELOCITY = 40;

    int DEFAULT_SIZE = 40;

    int X_RANGE_START = (int) (WINDOW_WIDTH * 0.1);

    int X_RANGE_END = (int) (WINDOW_WIDTH * 0.9);

    int Y_RANGE_START =  (int) (WINDOW_WIDTH * 0.1);

    int Y_RANGE_END =  (int) (WINDOW_WIDTH * 0.9);

    int ADD_BALL_WINDOW_WIDTH = 700;

    int ADD_BALL_WINDOW_HEIGHT = 700;

    int MIN_SIZE = 20;

    int MAX_SIZE = 80;

    int MAX_VELOCITY = 80;

    int MIN_VELOCITY = 10;

}
