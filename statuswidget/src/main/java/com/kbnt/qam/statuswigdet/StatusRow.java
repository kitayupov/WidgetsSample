package com.kbnt.qam.statuswigdet;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import com.kbnt.qam.statuswigdet.utils.ResourceUtils;
import com.kbnt.qam.statuswigdet.utils.TextUtils;

/**
 * Component widget with ImageView and TextView to display status
 */
public class StatusRow extends TableRow {

    private static final int EMPTY_VALUE = -1;

    private ImageView imageView;
    private TextView textView;

    private StatusType statusType = StatusType.NONE;

    public enum StatusType {
        BATTERY(1),
        MEMORY(2),
        NONE(0);

        private final int value;

        StatusType(int value) {
            this.value = value;
        }

        private static StatusType getType(int value) {
            for (StatusType type : StatusType.values()) {
                if (value == type.value) {
                    return type;
                }
            }
            return NONE;
        }
    }

    public enum VisionType {
        IMAGE(1),
        TEXT(2),
        ALL(0);

        private final int value;

        VisionType(int value) {
            this.value = value;
        }

        private static VisionType getType(int value) {
            for (VisionType type : VisionType.values()) {
                if (value == type.value) {
                    return type;
                }
            }
            return ALL;
        }
    }

    public StatusRow(Context context) {
        super(context);
        initialize(null);
    }

    public StatusRow(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(attrs);
    }

    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }

    private void initialize(AttributeSet attrs) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout, this);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        if (attrs != null) {
            setAttributes(attrs);
        }
    }

    private void setAttributes(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.StatusRow);
        try {
            setImageViewAttributes(a);
            setTextViewAttributes(a);
            setStatusType(a);
            setVisionType(a);
            setValue(a);
        } finally {
            a.recycle();
        }
    }

    private void setImageViewAttributes(TypedArray a) {
        int defImageSize = getResources().getDimensionPixelSize(R.dimen.imageSize);
        int imageSize = a.getDimensionPixelSize(R.styleable.StatusRow_imageSize, defImageSize);
        int imageWidth = a.getDimensionPixelSize(R.styleable.StatusRow_imageWidth, defImageSize);
        int imageHeight = a.getDimensionPixelSize(R.styleable.StatusRow_imageHeight, defImageSize);

        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = Math.max(imageWidth, imageSize);
        layoutParams.height = Math.max(imageHeight, imageSize);
    }

    private void setTextViewAttributes(TypedArray a) {
        float defTextSize = getResources().getDimension(R.dimen.textSize);
        float textSize = a.getDimension(R.styleable.StatusRow_textSize, defTextSize);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);

        int defSpaceSize = getResources().getDimensionPixelSize(R.dimen.spaceSize);
        int spaceSize = a.getDimensionPixelSize(R.styleable.StatusRow_spaceSize, defSpaceSize);
        TableRow.LayoutParams layoutParams = (LayoutParams) textView.getLayoutParams();
        layoutParams.setMarginStart(spaceSize);
    }

    private void setStatusType(TypedArray a) {
        int value = a.getInt(R.styleable.StatusRow_statusType, StatusType.NONE.value);
        statusType = StatusType.getType(value);
    }

    private void setVisionType(TypedArray a) {
        int value = a.getInt(R.styleable.StatusRow_visionType, VisionType.ALL.value);
        VisionType type = VisionType.getType(value);
        setVisionType(type);
    }

    public void setVisionType(VisionType visionType) {
        switch (visionType) {
            case TEXT:
                imageView.setVisibility(GONE);
                textView.setVisibility(VISIBLE);
                break;
            case IMAGE:
                imageView.setVisibility(VISIBLE);
                textView.setVisibility(GONE);
                break;
            case ALL:
                imageView.setVisibility(VISIBLE);
                imageView.setVisibility(VISIBLE);
                break;
        }
    }

    private void setValue(TypedArray a) {
        int value = a.getInt(R.styleable.StatusRow_value, EMPTY_VALUE);
        setValue(value);
    }

    public void setValue(int value) {
        if (StatusType.NONE.equals(statusType)) {
            textView.setText(String.valueOf(value));
        } else {
            if (value == EMPTY_VALUE) {
                imageView.setImageDrawable(null);
                textView.setText(null);
            } else {
                switch (statusType) {
                    case BATTERY:
                        imageView.setImageResource(ResourceUtils.getImageResourceForBatteryLevel(value));
                        break;
                    case MEMORY:
                        imageView.setImageResource(ResourceUtils.getImageResourceForMemoryLevel(value));
                }
                textView.setText(TextUtils.getPercentFormat(value));
            }
        }
    }
}
