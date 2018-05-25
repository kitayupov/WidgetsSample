package com.kbnt.qam.roundbuttons;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ToggleButton;

public class RecordButton extends ToggleButton implements View.OnClickListener, View.OnLongClickListener {

    private OnRecButtonTouchListener listener;

    public RecordButton(Context context) {
        super(context);
        init();
    }

    public RecordButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RecordButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public RecordButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void setOnRecButtonTouchListener(OnRecButtonTouchListener listener) {
        this.listener = listener;
    }

    public void setRecord(boolean record) {
        super.setChecked(record);
    }

    @Override
    public void setChecked(boolean checked) {
    }

    private void init() {
        setOnClickListener(this);
        setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            if (!isChecked()) {
                listener.onRecordStart();
            } else {
                listener.onMessage();
            }
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (listener != null) {
            if (!isChecked()) {
                listener.onRecordStart();
            } else {
                listener.onRecordStop();
            }
        }
        return true;
    }

    public interface OnRecButtonTouchListener {
        void onRecordStart();

        void onRecordStop();

        void onMessage();
    }
}
