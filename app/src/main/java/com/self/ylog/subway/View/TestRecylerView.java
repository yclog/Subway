package com.self.ylog.subway.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by deer on 2017/8/10.
 */

public class TestRecylerView extends RecyclerView {
    private int mLastX=0;
    private int mLastY=0;

    public TestRecylerView(Context context) {
        super(context);
    }

    public TestRecylerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TestRecylerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        int x=(int) event.getX();
        int y=(int) event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:{
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            }
            case MotionEvent.ACTION_MOVE:{
                int deltaX=x-mLastX;
                int deltaY=y-mLastY;
                if (Math.abs(deltaX) > Math.abs(deltaY)){
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
            }
            case MotionEvent.ACTION_UP:{
                break;
            }
            default:{
                break;
            }
        }
        mLastX=x;
        mLastY=y;
        return super.dispatchTouchEvent(event);
    }
}
