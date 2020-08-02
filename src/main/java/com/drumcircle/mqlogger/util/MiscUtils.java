package com.drumcircle.mqlogger.util;

import java.text.SimpleDateFormat;

/**
 * (c) Drum Circle, 2018
 * Created by drumcirle on 8/2/20.
 */
public class MiscUtils {
    public static String nowString(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        return sdf.format(System.currentTimeMillis());

    }
}
