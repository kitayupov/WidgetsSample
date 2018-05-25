package com.kbnt.qam.statuswigdet;

import android.content.Context;
import android.util.AttributeSet;

import com.kbnt.qam.statuswigdet.utils.ResourceUtils;
import com.kbnt.qam.statuswigdet.utils.TextUtils;

/**
 * Status widget to display battery status
 */
public class BatteryStatusRow extends StatusRow {

    public BatteryStatusRow(Context context) {
        super(context);
        setStatusType(StatusType.BATTERY);
    }

    public BatteryStatusRow(Context context, AttributeSet attrs) {
        super(context, attrs);
        setStatusType(StatusType.BATTERY);
    }
}
