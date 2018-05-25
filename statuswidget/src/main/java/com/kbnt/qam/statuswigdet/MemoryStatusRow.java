package com.kbnt.qam.statuswigdet;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Status widget to display memory status
 */
public class MemoryStatusRow extends StatusRow {

    public MemoryStatusRow(Context context) {
        super(context);
        setStatusType(StatusType.MEMORY);
    }

    public MemoryStatusRow(Context context, AttributeSet attrs) {
        super(context, attrs);
        setStatusType(StatusType.MEMORY);
    }
}
