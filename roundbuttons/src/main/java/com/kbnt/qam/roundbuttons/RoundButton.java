package com.kbnt.qam.roundbuttons;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ToggleButton;

public class RoundButton extends ToggleButton {

    public RoundButton(Context context) {
        super(context);
        initialize();
    }

    public RoundButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public RoundButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    private void initialize() {
        setText(null);
        setTextOn(null);
        setTextOff(null);
        setBackground();
    }

    protected void setBackground() {
        setBackgroundResource(R.drawable.button_background);
    }
}
