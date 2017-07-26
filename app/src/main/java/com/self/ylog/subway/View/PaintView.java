package com.self.ylog.subway.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.self.ylog.subway.Utils.PathNode;
import com.self.ylog.subway.Utils.PaintLineSet;
import com.self.ylog.subway.Utils.PaintInfo;

import java.util.ArrayList;
import java.util.List;


public class PaintView extends View{
    // judge your fingers' tremble
    private static final float TOUCH_TOLERANCE = 4;
    private static final int STATION_LINE_NUM=4;

    Paint mPaint = new Paint();
    Paint mEraserPaint = new Paint();
    private Path mPath;
    private Paint mBitmapPaint;
    private int width;
    private int height;
    private Canvas mCanvas;
    private Bitmap mBitmap;
    private Context context;
    private boolean isShowLiveStream=false;
    PaintView paintView;

    public static boolean IsPaint = true;
    private float mX, mY;
    private List<PathNode> mDataList;

    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        Init_Paint(PaintInfo.PaintColor_One, PaintInfo.PaintWidth);
        //获取设备宽高
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        width = manager.getDefaultDisplay().getWidth();
        height = manager.getDefaultDisplay().getHeight();

        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);

        mPath = new Path();
        mBitmapPaint = new Paint(Paint.DITHER_FLAG);
    }

    public PaintView(Context context) {
        super(context);
        this.context = context;
        Init_Paint(PaintInfo.PaintColor_One, PaintInfo.PaintWidth);
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        width = manager.getDefaultDisplay().getWidth();
        height = manager.getDefaultDisplay().getHeight();

        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
        mBitmapPaint = new Paint(Paint.DITHER_FLAG);
    }

    // init paint
    public void Init_Paint(int color, int width) {
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(color);
        mPaint.setStyle(Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(width);
    }

    public void setIsLiveStream(boolean isShowLiveStream){
        this.isShowLiveStream=isShowLiveStream;
    }

    public void IsPaint(Boolean IsPaint){
        this.IsPaint=IsPaint;
    }

    public void station_start(int x, int y){
        mPath.reset();
        mPath.moveTo(x, y);
        mX = x;
        mY = y;
        Log.i("point",mX+" "+mY);

        mCanvas.drawCircle(mX,mY,30,mPaint);
    }

    public void station_middle(int x, int y){
        float dx = Math.abs(x - mX);
        float dy = Math.abs(y - mY);
        if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
            mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
            mX = x;
            mY = y;
        }
        mCanvas.drawOval(mX-10,mY-10,mX+10,mY+10,mPaint);
    }

    public void station_up(int x, int y){
        Log.i("point",mX+" "+mY);
        mPath.lineTo(mX, mY);
        mCanvas.drawCircle(mX,mY,30,mPaint);
        if(IsPaint)
            mCanvas.drawPath(mPath, mPaint);
        else
            mCanvas.drawPath(mPath, mEraserPaint);
        mPath.reset();
    }

    //绘制线路
    public void DrawStationLine(Canvas canvas){
        mDataList=new ArrayList<PathNode>();
        canvas.drawPath(mPath, mPaint);
        for (int i = 1; i <= STATION_LINE_NUM; i++) {
            Init_Line(i);
            canvas.drawPath(mPath, mPaint);
        }
    }

    //初始化参数值
    public void Init_Line(int index){
        switch (index){
            case 1:
                if (isShowLiveStream)
                    Init_Paint(PaintInfo.PaintColor_Red, PaintInfo.PaintWidth);
                else
                    Init_Paint(PaintInfo.PaintColor_One, PaintInfo.PaintWidth);
                break;
            case 2:
                Init_Paint(PaintInfo.PaintColor_Two, PaintInfo.PaintWidth);
                break;
            case 3:
                Init_Paint(PaintInfo.PaintColor_Three, PaintInfo.PaintWidth);
                break;
            case 4:
                Init_Paint(PaintInfo.PaintColor_Four, PaintInfo.PaintWidth);
                break;
        }
        PaintLineSet mPaintLineSet =new PaintLineSet();
        mDataList= mPaintLineSet.getInstance().getDataList(index);
        LineDataSet(mDataList);
    }

    public void LineDataSet(List<PathNode> mDataList){
        station_start(mDataList.get(0).getmX(),mDataList.get(0).getmY());
        for (int i = 0; i < mDataList.size(); i++) {
            station_middle(mDataList.get(i).getmX(),mDataList.get(i).getmY());
        }
        station_up(mDataList.get(mDataList.size()-1).getmX(),mDataList.get(3).getmY());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mBitmap, 0, 0, mBitmapPaint);
        DrawStationLine(canvas);
    }

}
