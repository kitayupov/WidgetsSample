package com.kbnt.qam.statuswigdet.utils;

/**
 * Utils for creating text with specific format for concrete value
 */
public class TextUtils {

    private static final String PERCENT = "%";

    public static String getPercentFormat(int value) {
        return value + PERCENT;
    }
}
