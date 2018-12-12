package com.kbnt.rounddiagram;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class RoundDiagramSector extends View {

    private float mRadius;
    private int mCount;
    private int mDegree;
    private int mSectors;
    private int mGap;
    private Paint[] mPaints;
    private Paint mSelectedPaint;
    private Paint mRimPaint;
    private float mRim;
    private int mSelectedSector = -1;

    public RoundDiagramSector(Context context) {
        super(context);
        init(null, 0);
    }

    public RoundDiagramSector(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public RoundDiagramSector(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.RoundDiagramSector, defStyle, 0);
        mRadius = a.getDimension(R.styleable.RoundDiagramSector_radius, 50);
        mCount = a.getInteger(R.styleable.RoundDiagramSector_count, 4);
        mDegree = a.getInteger(R.styleable.RoundDiagramSector_degree, 270);
        mSectors = a.getInteger(R.styleable.RoundDiagramSector_sectors, 6);
        mGap = a.getInteger(R.styleable.RoundDiagramSector_gap, 2);
        mRim = a.getDimension(R.styleable.RoundDiagramSector_rim, 20);
        int color = a.getColor(R.styleable.RoundDiagramSector_color, Color.WHITE);
        int gradient = a.getInteger(R.styleable.RoundDiagramSector_gradient, 20);
        int rimColor = a.getColor(R.styleable.RoundDiagramSector_rimColor, Color.DKGRAY);
        a.recycle();

        mRimPaint = new Paint();
        mRimPaint.setColor(rimColor);
        mRimPaint.setStyle(Paint.Style.STROKE);

        mPaints = new Paint[mCount];
        for (int i = 0; i < mCount; i++) {
            mPaints[i] = new Paint();
            mPaints[i].setARGB(gradient, Color.red(color), Color.green(color), Color.blue(color));
            mPaints[i].setStyle(Paint.Style.STROKE);
        }

        mSelectedPaint = new Paint();
        mSelectedPaint.setARGB(gradient, Color.red(color), Color.green(color), Color.blue(color));
        mSelectedPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();

        int contentWidth = getWidth() - paddingLeft - paddingRight;
        int contentHeight = getHeight() - paddingTop - paddingBottom;

        float contentSize = Math.min(contentWidth, contentHeight);

        float centerX = contentWidth / 2;
        float centerY = contentHeight / 2;

        float stroke = (contentSize / 2 - mRadius) / (mCount + 1);

        RectF[] rectFS = new RectF[mCount];
        for (int i = 0; i < mCount; i++) {
            float step = mRadius + stroke / 2 * (i + 1);
            rectFS[i] = new RectF(centerX - step, centerY - step, centerX + step, centerY + step);
            mPaints[i].setStrokeWidth(stroke * (i + 1));
        }

        float select = mRadius + stroke / 2 * (mCount + 1);
        RectF rectSelected = new RectF(centerX - select, centerY - select, centerX + select, centerY + select);
        mSelectedPaint.setStrokeWidth(stroke * (mCount + 1));

        float rim = mRadius + mRim / 2;
        RectF rectRim = new RectF(centerX - rim, centerY - rim, centerX + rim, centerY + rim);
        mRimPaint.setStrokeWidth(mRim);

        int sector = 360 / mSectors;
        for (int i = 0; i < mSectors; i++) {
            int angle = mDegree + i * sector;
            for (int j = 0; j < mCount; j++) {
                canvas.drawArc(rectFS[j], angle, sector - mGap, false, mPaints[j]);
            }
            canvas.drawArc(rectRim, angle, sector - mGap, false, mRimPaint);
        }

        if (mSelectedSector != -1) {
            canvas.drawArc(rectSelected, mDegree + mSelectedSector * sector, sector - mGap, false, mSelectedPaint);
        }
    }

    public void setSelectedSector(int index) {
        mSelectedSector = index % mSectors;
    }
}
