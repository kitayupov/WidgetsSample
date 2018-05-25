package com.kbnt.qam.statuswigdet.utils;

import com.kbnt.qam.statuswigdet.R;

/**
 * Utils for extracting image resources for concrete values
 */
public class ResourceUtils {

    public static int getImageResourceForBatteryLevel(int value) {
        if (value > 85) {
            return R.mipmap.battery_85_100;
        } else if (value > 65) {
            return R.mipmap.battery_66_85;
        } else if (value > 40) {
            return R.mipmap.battery_41_65;
        } else if (value > 20) {
            return R.mipmap.battery_21_40;
        } else if (value > 10) {
            return R.mipmap.battery_10_20;
        } else {
            return R.mipmap.battery_0_9;
        }
    }

    public static int getImageResourceForMemoryLevel(int value) {
        if (value > 75) {
            return R.mipmap.memory_76_100;
        } else if (value > 50) {
            return R.mipmap.memory_51_75;
        } else if (value > 25) {
            return R.mipmap.memory_26_50;
        } else if (value > 10) {
            return R.mipmap.memory_11_25;
        } else {
            return R.mipmap.memory_0_10;
        }
    }
}
