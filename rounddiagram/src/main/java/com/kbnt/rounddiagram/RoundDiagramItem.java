package com.kbnt.rounddiagram;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.TextView;

public class RoundDiagramItem extends ConstraintLayout {

    private RoundDialView mDial;
    private TextView mCount;
    private TextView mText;

    public RoundDiagramItem(@NonNull Context context) {
        super(context);
        init(null, 0);
    }

    public RoundDiagramItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public RoundDiagramItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(@Nullable AttributeSet attrs, int defStyle) {
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.RoundDiagramItem, defStyle, 0);
        String label = a.getString(R.styleable.RoundDiagramItem_label);
        int textSize = a.getDimensionPixelSize(R.styleable.RoundDiagramItem_textSize, 0);
        int countTextSize = a.getDimensionPixelSize(R.styleable.RoundDiagramItem_countSize, 0);
        a.recycle();

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_diagram_item, this);
        ((TextView) findViewById(R.id.label)).setText(label);

        mDial = findViewById(R.id.dial);
        mCount = findViewById(R.id.count);
        mText = findViewById(R.id.text);
        if (textSize > 0) {
            mText.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        }
        if (countTextSize > 0) {
            mCount.setTextSize(TypedValue.COMPLEX_UNIT_SP, countTextSize);
        }
    }

    public void setCount(@IntRange(from = 0) int count) {
        mCount.setText(String.valueOf(count));
    }

    public void setText(String text) {
        mText.setText(text);
    }

    public void setDial(@IntRange(from = 0, to = 100) int acc, @IntRange(from = 0, to = 100) int vel) {
        mDial.setAccValue(acc);
        mDial.setVelValue(vel);
    }
}
