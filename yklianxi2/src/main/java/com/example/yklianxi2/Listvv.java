package com.example.yklianxi2;

import android.content.Context;
import android.icu.util.Measure;
import android.util.AttributeSet;
import android.widget.ListView;

/*
 *@Auther:田恒宇
 *@weichat: 15020451581
 *@Description:function
 */
public class Listvv extends ListView {
    public Listvv(Context context) {
        super(context);
    }

    public Listvv(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Listvv(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Listvv(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, i);
    }
}
