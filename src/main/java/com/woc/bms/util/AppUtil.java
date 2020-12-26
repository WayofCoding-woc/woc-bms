package com.woc.bms.util;

import java.util.Random;

public class AppUtil {


    public static long generateRandomNumber() {
        Random r = new Random(System.currentTimeMillis() );
        return Math.abs(1000000000 + r.nextInt(2000000000));
    }
}
