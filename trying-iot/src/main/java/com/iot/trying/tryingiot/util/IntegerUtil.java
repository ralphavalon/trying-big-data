package com.iot.trying.tryingiot.util;

public class IntegerUtil {

    public static int getRandomIntegerBetweenRange(int min, int max){
        return (int) ((Math.random()*((max-min)+1))+min);
    }

}
