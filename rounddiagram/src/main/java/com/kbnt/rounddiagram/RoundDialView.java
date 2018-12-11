package com.kbnt.rounddiagram;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class RoundDialView extends View {

    private Paint mDialPaint;
    private Paint mBottomPaint;
    private Paint mCenterPaint;
    private Paint mAccPaint;
    private Paint mVelPaint;

    @IntRange(from = 0, to = 100)
    private int mAccValue;
    @IntRange(from = 0, to = 100)
    private int mVelValue;

    public RoundDialView(@NonNull Context context) {
        super(context);
        init(null, 0);
    }

    public RoundDialView(@NonNull Context context, @NonNull AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public RoundDialView(@NonNull Context context, @NonNull AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(@Nullable AttributeSet attrs, int defStyle) {
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.RoundDialView, defStyle, 0);

        int dialBackgroundColor = a.getColor(
                R.styleable.RoundDialView_colorDialBackground, Color.GRAY);
        int bottomColor = a.getColor(
                R.styleable.RoundDialView_colorBottom, Color.LTGRAY);
        int centerColor = a.getColor(
                R.styleable.RoundDialView_colorCenter, Color.DKGRAY);
        int accelerationColor = a.getColor(
                R.styleable.RoundDialView_colorAcceleration, Color.RED);
        int velocityColor = a.getColor(
                R.styleable.RoundDialView_colorVelocity, Color.CYAN);

        a.recycle();

        mDialPaint = new Paint();
        mDialPaint.setColor(dialBackgroundColor);

        mBottomPaint = new Paint();
        mBottomPaint.setColor(bottomColor);
        mBottomPaint.setStyle(Paint.Style.STROKE);

        mCenterPaint = new Paint();
        mCenterPaint.setColor(centerColor);

        mAccPaint = new Paint();
        mAccPaint.setColor(accelerationColor);
        mAccPaint.setStyle(Paint.Style.STROKE);

        mVelPaint = new Paint();
        mVelPaint.setColor(velocityColor);
        mVelPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        int dimen = Math.min(width, height);
        setMeasuredDimension(dimen, dimen);
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

        int contentSize = Math.min(contentWidth, contentHeight);

        float left = (contentWidth - contentSize) / 2.F;
        float top = (contentHeight - contentSize) / 2.F;
        float right = left + contentSize;
        float bottom = top + contentSize;

        float stroke = contentSize * 0.08F;

        mBottomPaint.setStrokeWidth(stroke * 2);
        mAccPaint.setStrokeWidth(stroke);
        mVelPaint.setStrokeWidth(stroke);

        RectF dialRect = new RectF(left + stroke, top + stroke, right - stroke, bottom - stroke);
        RectF accRect = new RectF(dialRect.left - stroke / 2, dialRect.top - stroke / 2, dialRect.right + stroke / 2, dialRect.bottom + stroke / 2);
        RectF velRect = new RectF(dialRect.left + stroke / 2, dialRect.top + stroke / 2, dialRect.right - stroke / 2, dialRect.bottom - stroke / 2);

        canvas.drawCircle((left + right) / 2, (top + bottom) / 2, contentSize / 2, mDialPaint);
        canvas.drawCircle((left + right) / 2, (top + bottom) / 2, contentSize / 2 - 2 * stroke, mCenterPaint);
        canvas.drawArc(dialRect, 45, 90, false, mBottomPaint);

        canvas.drawArc(accRect, 135, 270 * (mAccValue / 100.F), false, mAccPaint);
        canvas.drawArc(velRect, 135, 270 * (mVelValue / 100.F), false, mVelPaint);
    }

    public void setAccValue(@IntRange(from = 0, to = 100) int value) {
        mAccValue = value;
        invalidate();
    }

    public void setVelValue(@IntRange(from = 0, to = 100) int value) {
        mVelValue = value;
        invalidate();
    }
}
