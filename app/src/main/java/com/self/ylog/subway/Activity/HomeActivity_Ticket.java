package com.self.ylog.subway.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.self.ylog.subway.Adapter.RecyclerViewTicketAdapter;
import com.self.ylog.subway.R;
import com.self.ylog.subway.Utils.ItemStationData;
import com.self.ylog.subway.Utils.LayoutParam;

import static com.self.ylog.subway.Utils.DebugTag.BUYSTATIONDATA;
import static com.self.ylog.subway.Utils.StationConstant.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by cylog on 2017/4/27.
 */

public class HomeActivity_Ticket extends AppCompatActivity implements View.OnClickListener{
    //起始站线路索引
    private String mStartSubwayIndex;
    //起始站线路名
    private String mStartSubwayLabel;
    //终点站线路索引
    private String mEndSubwayIndex;
    //终点站线路名
    private String mEndSubwayLabel;

    //起始站索引
    private String mStartStationIndex;
    //起始站站名
    private String mStartStationLabel;
    //终点站索引
    private String mEndStationIndex;
    //终点站站名
    private String mEndStationLabel;

    private int QR_WIDTH = 200, QR_HEIGHT = 200;
    private Context mContext=this;
    private Intent mGetDataIntent;
    /**
     * 定义控件item
     * @control titlebar内控件
     * */
    private ImageView mIcon_Home;
    private TextView mPick_Start;
    private TextView mPick_End;

    //recyclerview控件参数
    private RecyclerView mTicketRecyclerView;
    private RecyclerViewTicketAdapter mRecyclerViewTicketAdapter;
    private List<ItemStationData> mDataList=new ArrayList<ItemStationData>();;
    //底部滑动栏
    private RelativeLayout mBottomSheetLayout;
    private BottomSheetBehavior mBottomSheetBehavior;
    private Button mPayButton;
    //Dialog二维码显示
    private ImageView mQRCode;

    private TextView mTextview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_ticket);
        getIntentExtra();
        initView();
    }

    /**
     * 使用Intent传递参数
     * */
    public void getIntentExtra(){
        mGetDataIntent=getIntent();
        //获取起始站线路索引 From HomeActivity_Ticket_PickStart
        mStartSubwayIndex=mGetDataIntent.getStringExtra(START_SUBWAY_INDEX);
        Log.d(BUYSTATIONDATA, "获取起始站线路索引: "+mStartSubwayIndex);
        //获取起始站线路名 From HomeActivity_Ticket_PickStart
        mStartSubwayLabel=mGetDataIntent.getStringExtra(START_SUBWAY_LABEL);
        Log.d(BUYSTATIONDATA, "获取起始站线路名: "+mStartSubwayLabel);

        //获取终点站线路索引 From HomeActivity_Ticket_PickEnd
        mEndSubwayIndex=mGetDataIntent.getStringExtra(END_SUBWAY_INDEX);
        Log.d(BUYSTATIONDATA, "获取终点站线路索引: "+mEndSubwayIndex);
        //获取终点站线路名 From HomeActivity_Ticket_PickEnd
        mEndSubwayLabel=mGetDataIntent.getStringExtra(END_SUBWAY_LABEL);
        Log.d(BUYSTATIONDATA, "获取终点站线路名: "+mEndSubwayLabel);

        //获取起始站索引数据 From HomeActivity_Ticket_PickEnd
        mStartStationIndex=mGetDataIntent.getStringExtra(START_STATION_INDEX);
        Log.d(BUYSTATIONDATA, "获取起始站索引数据: "+mStartStationIndex);
        //获取起始站站名数据 From HomeActivity_Ticket_PickEnd
        mStartStationLabel =mGetDataIntent.getStringExtra(START_STATION_LABEL);
        Log.d(BUYSTATIONDATA, "获取起始站站名数据: "+ mStartStationLabel);

        //获取终点站索引数据
        mEndStationIndex =mGetDataIntent.getStringExtra(END_STATION_INDEX);
        Log.d(BUYSTATIONDATA, "获取终点站索引数据: "+ mEndStationIndex);
        //获取终点站站名数据
        mEndStationLabel =mGetDataIntent.getStringExtra(END_STATION_LABEL);
        Log.d(BUYSTATIONDATA, "获取终点站站名数据: "+ mEndStationLabel);
    }

    /**
     *  初始化控件，ID绑定
     *  findViewById
     * */
    public void initView(){
        initBottomSheet();
        mPick_Start=(TextView) findViewById(R.id.pick_start);
        mPick_Start.setOnClickListener(this);
        mPick_End=(TextView) findViewById(R.id.pick_end);
        mPick_End.setOnClickListener(this);
        initRecyclerView();

        mIcon_Home=(ImageView) findViewById(R.id.icon_home);
        mIcon_Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity_Ticket.this.finish();
            }
        });
        mPayButton=(Button) findViewById(R.id.pay_btn);
        mPayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payDialog();
            }
        });
    }

    public void createQRImage(String url) {
        try {
            //判断URL合法性
            if (url == null || "".equals(url) || url.length() < 1) {
                return;
            }
            Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            //图像数据转换，使用了矩阵转换
            BitMatrix bitMatrix = new QRCodeWriter().encode(url, BarcodeFormat.QR_CODE, QR_WIDTH, QR_HEIGHT, hints);
            int[] pixels = new int[QR_WIDTH * QR_HEIGHT];
            //下面这里按照二维码的算法，逐个生成二维码的图片，
            //两个for循环是图片横列扫描的结果
            for (int y = 0; y < QR_HEIGHT; y++) {
                for (int x = 0; x < QR_WIDTH; x++) {
                    if (bitMatrix.get(x, y)) {
                        pixels[y * QR_WIDTH + x] = 0xff000000;
                    }
                    else {
                        pixels[y * QR_WIDTH + x] = 0xffffffff;
                    }
                }
            }
            //生成二维码图片的格式，使用ARGB_8888
            Bitmap bitmap = Bitmap.createBitmap(QR_WIDTH, QR_HEIGHT, Bitmap.Config.ARGB_8888);
            bitmap.setPixels(pixels, 0, QR_WIDTH, 0, 0, QR_WIDTH, QR_HEIGHT);
            //显示到一个ImageView上面
            mQRCode.setImageBitmap(bitmap);
        }
        catch (WriterException e) {
            e.printStackTrace();
        }
    }

    public void payDialog(){
        LayoutInflater inflater = getLayoutInflater();
        View Dialog = inflater.inflate(R.layout.pay_dialog,(ViewGroup) findViewById(R.id.pay_dialog));
        mTextview=(TextView) Dialog.findViewById(R.id.buy_ticket_text_secondary);
        String test=mStartStationLabel+"-->"+mEndStationLabel+" 6元";
        mTextview.setText(test);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showDialog();
            }
        });
        builder.setView(Dialog);
        builder.show();
    }

    private void showDialog() {
        LayoutInflater inflater = getLayoutInflater();
        View Dialog = inflater.inflate(R.layout.dialog_qrcode,(ViewGroup) findViewById(R.id.QRCode_Dialog));
        mQRCode=(ImageView) Dialog.findViewById(R.id.QRCode);
        createQRImage(mStartStationLabel+"-->"+mEndStationLabel+" 6元");

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("确定", null);
        builder.setView(Dialog);
        builder.show();
    }

    public void initBottomSheet(){
        //初始化底部栏
        mBottomSheetLayout=(RelativeLayout) findViewById(R.id.bottom_sheet);
        mBottomSheetBehavior=BottomSheetBehavior.from(mBottomSheetLayout);
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_SETTLING);
        mBottomSheetBehavior.setPeekHeight(150);
        mBottomSheetBehavior.setHideable(false);

    }

    public void initRecyclerView(){
        initData();
        mTicketRecyclerView=(RecyclerView) findViewById(R.id.ticket_recyclerview);
        mRecyclerViewTicketAdapter=new RecyclerViewTicketAdapter(getContext(),mDataList);
        mTicketRecyclerView.setAdapter(mRecyclerViewTicketAdapter);
        mTicketRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void initData(){
        if(IsEnd()){
            mDataList.add(new ItemStationData("开始", "起始站",false,true,1));
            for (int i = 0; i <= 9; i++) {
                mDataList.add(new ItemStationData("开始","中间站",true,true,1));
            }
            mDataList.add(new ItemStationData("结束", "终点站",true,false,1));
        } else {
            int StartIndex=Integer.valueOf(mStartStationIndex);
            int EndIndex=Integer.valueOf(mEndStationIndex);
            mDataList.add(new ItemStationData("开始", mStartStationLabel,false,true,1));
            for (int i = StartIndex; i <= EndIndex; i++) {
                mDataList.add(new ItemStationData("开始","中间站",true,true,1));
            }
            mDataList.add(new ItemStationData("结束", mEndStationLabel,true,false,1));
        }
    }

    public Boolean IsEnd(){
        return mEndSubwayIndex==null ? true:false;
    }

    @Override
    public void onClick(View v) {
        Intent mIntent;
        switch (v.getId()){
            case R.id.pick_start:
                mIntent=new Intent(getContext(),HomeActivity_Ticket_PickStart.class);
                startActivity(mIntent);
                break;
            case R.id.pick_end:
                mIntent=new Intent(getContext(),HomeActivity_Ticket_PickEnd.class);
                startActivity(mIntent);
                break;
        }
    }

    /**
     * 重写返回键
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            HomeActivity_Ticket.this.finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        HomeActivity_Ticket.this.finish();
        super.onPause();
    }

    /**
     * 获取Context
     * */
    public Context getContext(){
        mContext=this;
        return mContext;
    }
}
