package com.self.ylog.subway.View;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.Scroller;

/**
 * Created by deer on 2017/8/10.
 */

public class TestLinearLayout extends LinearLayout {
    private int mLastX=0;
    private int mLastY=0;
    private Scroller mScroller;

    private void init(){
        mScroller = new Scroller(getContext());
    }

    public TestLinearLayout(Context context) {
        super(context);
        init();
    }

    public TestLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TestLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public TestLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        int x= (int) event.getX();
        int y= (int) event.getY();
        int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN){
            mLastX = x;
            mLastY = y;
            if (!mScroller.isFinished()){
                mScroller.abortAnimation();
                return true;
            }
            return false;
        } else {
            return true;
        }
    }
}
