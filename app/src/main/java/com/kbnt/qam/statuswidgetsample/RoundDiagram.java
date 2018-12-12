package com.kbnt.qam.statuswidgetsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.kbnt.rounddiagram.RoundDiagramItem;

public class RoundDiagram extends FrameLayout {

    private RoundDiagramItem mLeftJabs;
    private RoundDiagramItem mLeftHooks;
    private RoundDiagramItem mLeftUppers;
    private RoundDiagramItem mRightJabs;
    private RoundDiagramItem mRightHooks;
    private RoundDiagramItem mRightUppers;
    private RoundDiagramItem mTotal;

    public RoundDiagram(@NonNull Context context) {
        super(context);
        init();
    }

    public RoundDiagram(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RoundDiagram(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout, this);

        mLeftJabs = findViewById(R.id.leftJabs);
        mLeftHooks = findViewById(R.id.leftHooks);
        mLeftUppers = findViewById(R.id.leftUppers);

        mRightJabs = findViewById(R.id.rightJabs);
        mRightHooks = findViewById(R.id.rightHooks);
        mRightUppers = findViewById(R.id.rightUppers);

        mTotal = findViewById(R.id.total);
    }
}
