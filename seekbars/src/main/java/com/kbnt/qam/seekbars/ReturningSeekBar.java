package com.kbnt.qam.seekbars;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;

/**
 * Vertical seek bar with thumb returning to the center after release
 */
public class ReturningSeekBar extends VerticalSeekBar {

    private final int DEFAULT_VALUE = getMax() / 2;

    private OnSeekBarChangeListener onSeekBarChangeListener;

    public ReturningSeekBar(Context context) {
        super(context);
        initialize();
    }

    public ReturningSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public ReturningSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialize();
    }

    public void setOnSeekBarChangeListener(OnSeekBarChangeListener onSeekBarChangeListener) {
        this.onSeekBarChangeListener = onSeekBarChangeListener;
    }

    private void initialize() {
        setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setValue(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setProgress(DEFAULT_VALUE);
                setValue(DEFAULT_VALUE);
            }

            private void setValue(int progress) {
                if (onSeekBarChangeListener != null) {
                    final int value = progress - DEFAULT_VALUE;
                    if (value == 0) {
                        onSeekBarChangeListener.onReturn();
                    } else {
                        if (value > 0) {
                            onSeekBarChangeListener.onTouchUp(value);
                        } else {
                            onSeekBarChangeListener.onTouchDown(Math.abs(value));
                        }
                    }
                }
            }
        });
        setProgress(DEFAULT_VALUE);
    }

    public interface OnSeekBarChangeListener {
        void onReturn();

        void onTouchUp(int value);

        void onTouchDown(int value);
    }
}
