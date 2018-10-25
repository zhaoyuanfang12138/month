package com.example.lenovo.month021025;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lenovo on 2018/10/25.
 */

public class IViewi extends ViewGroup{
    public IViewi(Context context) {
        this(context,null);
    }

    public IViewi(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public IViewi(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        measureChildren(0,0);

        int totalw = 0;
        int totalh = 0;
        for (int i4 = 0; i4<getChildCount(); i4++){
            View view = getChildAt(i4);

            if (totalw+view.getMeasuredWidth()>=getMeasuredWidth()){
                totalw =0;
                totalh+=view.getMeasuredHeight();
            }
          //  view.layout(totalw,totalh,totalw+view.getMeasuredWidth(),totalh+view.getMeasuredHeight());
            view.layout(
                    totalw,
                    totalh,
                    totalw + view.getMeasuredWidth(),
                    totalh + view.getMeasuredHeight());
            totalw+=view.getMeasuredWidth();
        }

    }
}
