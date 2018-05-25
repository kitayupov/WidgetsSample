package com.kbnt.qam.roundbuttons;

import android.content.Context;
import android.util.AttributeSet;

public class PhotoButton extends RoundButton {

    public PhotoButton(Context context) {
        super(context);
    }

    public PhotoButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PhotoButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void setBackground() {
        setBackgroundResource(R.drawable.button_photo);
    }
}
