package com.self.ylog.subway.View;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

/**
 * Created by deer on 2017/8/14.
 */

public class StickyLayout extends LinearLayout {
    private int mTouchSlop;
    private int mLastX = 0;
    private int mLastY = 0;
    private int mLastXIntercept = 0;
    private int mLastYIntercept = 0;

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
//        test();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width=getWidth();
        int height=getHeight();
        int bottom=getBottom();
        Log.d("test", "onDraw: width: "+width+" height: "+height+" bottom: "+bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        test();
    }

    public StickyLayout(Context context) {
        super(context);
        final View child = getChildAt(2);
        int test=this.getChildCount();
//        Log.d("test", "StickyLayout: "+test);
    }

    public StickyLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        final View child = getChildAt(2);
        int test=this.getChildCount();
//        Log.d("test", "StickyLayout: "+test);
    }

    public StickyLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        final View child = getChildAt(2);
        int test=this.getChildCount();
//        Log.d("test", "StickyLayout: "+test);
    }

    //设置当前HeaderBody底部位置进入LayoutParam类
    public void setHeaderHeight(final RecyclerView mHomeRecyclerView){

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        int intercepted = 0;
        int x = (int)event.getX();
        int y = (int)event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:{
                mLastXIntercept = x;
                mLastYIntercept = y;
                mLastX = x;
                mLastY = y;
                intercepted=0;
                break;
            }
            case MotionEvent.ACTION_MOVE:{
                int deltaX = x-mLastXIntercept;
                int deltaY = y-mLastYIntercept;
            }
            case MotionEvent.ACTION_UP:{}
            default:{}
        }
        return super.onInterceptTouchEvent(event);
    }

    public int getHeaderBodyHeight(){
        int mHeight = 0;
        return mHeight;
    }

    public void test(){
        int width=getWidth();
        int height=getHeight();
        int bottom=getBottom();
        Log.d("test", "onDraw: width: "+width+" height: "+height+" bottom: "+bottom);
    }
}
