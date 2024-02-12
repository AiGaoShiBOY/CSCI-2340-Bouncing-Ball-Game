package com.bouncingball.utils;

/**
 * @author FinnerLi 2/11/24 yuanfeng_li@brown.edu
 **/
public class BallGameUtils {

    /**
     * fix x to [max, min]
     * @param x
     * @param max
     * @param min
     * @return
     */
    public static int fixInt(int x, int max, int min){
        if(x > max){
            return max;
        }
        return Math.max(x, min);
    }

    /**
     * parse x to int first, and fix it to [max, min]
     * @param x
     * @param max
     * @param min
     * @return
     */
    public static int parseAndFixInt(String x, int max, int min){
        int integer = Integer.parseInt(x);
        return fixInt(integer, max, min);
    }
}
