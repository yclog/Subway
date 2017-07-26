package com.self.ylog.subway.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import static com.self.ylog.subway.Utils.DebugTag.BUYSTATIONDATA;
import static com.self.ylog.subway.Utils.StationConstant.*;
import com.self.ylog.subway.Adapter.RecyclerViewStationLineAdapter;
import com.self.ylog.subway.R;
import com.self.ylog.subway.Utils.ItemStationLineData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cylog on 2017/5/23.
 */

public class HomeActivity_Ticket_Content extends AppCompatActivity{

    private Context mContext=this;

    private Intent mGetDataIntent;
    private RecyclerView mRecyclerView;
    private RecyclerViewStationLineAdapter mAdapter;
    private List<ItemStationLineData> mDataList;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_ticket_content);
        getIntentExtra();
        initview();
    }

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

    public void initview(){
        init_RecyclerView();
    }

    public void init_RecyclerView(){
        initdata();
        mRecyclerView=(RecyclerView) findViewById(R.id.station_recyclerview);
        mAdapter =new RecyclerViewStationLineAdapter(getContext(),mDataList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);
        initEvent();
    }

    private void initEvent() {
        mAdapter.setOnItemClickLitener(new RecyclerViewStationLineAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent mIntent=new Intent();
                if (IsFromStart()){
                    Log.d(BUYSTATIONDATA, "onItemClick: From Start");
                    mIntent=new Intent(getContext(),HomeActivity_Ticket_PickEnd.class);
                    mIntent.putExtra(START_SUBWAY_INDEX,mStartSubwayIndex);
                    Log.d(BUYSTATIONDATA, "注入起始地铁线路索引: "+mIntent.getStringExtra(START_SUBWAY_INDEX));
                    mIntent.putExtra(START_SUBWAY_LABEL,mStartSubwayLabel);
                    Log.d(BUYSTATIONDATA, "注入起始地铁线路名: "+mIntent.getStringExtra(START_SUBWAY_LABEL));
                    mIntent.putExtra(START_STATION_INDEX,position+1+"");
                    Log.d(BUYSTATIONDATA, "注入购票起始站索引: "+mIntent.getStringExtra(START_STATION_INDEX));
                    mIntent.putExtra(START_STATION_LABEL,mDataList.get(position).getLine_text());
                    Log.d(BUYSTATIONDATA, "注入购票起始站名: "+mIntent.getStringExtra(START_STATION_LABEL));
                } else {
                    Log.d(BUYSTATIONDATA, "onItemClick: From End");
                    mIntent=new Intent(getContext(),HomeActivity_Ticket.class);
                    mIntent.putExtra(START_SUBWAY_INDEX,mStartSubwayIndex);
                    Log.d(BUYSTATIONDATA, "注入起始地铁线路索引: "+mIntent.getStringExtra(START_SUBWAY_INDEX));
                    mIntent.putExtra(START_SUBWAY_LABEL,mStartSubwayLabel);
                    Log.d(BUYSTATIONDATA, "注入起始地铁线路名: "+mIntent.getStringExtra(START_SUBWAY_LABEL));
                    mIntent.putExtra(START_STATION_INDEX,mStartStationIndex);
                    Log.d(BUYSTATIONDATA, "注入购票起始站索引: "+mIntent.getStringExtra(START_STATION_INDEX));
                    mIntent.putExtra(START_STATION_LABEL,mStartStationLabel);
                    Log.d(BUYSTATIONDATA, "注入购票起始站名: "+mIntent.getStringExtra(START_STATION_LABEL));

                    mIntent.putExtra(END_SUBWAY_INDEX,mEndSubwayIndex);
                    Log.d(BUYSTATIONDATA, "注入购票终点站线路索引: "+mIntent.getStringExtra(END_SUBWAY_INDEX));
                    mIntent.putExtra(END_SUBWAY_LABEL,mEndSubwayLabel);
                    Log.d(BUYSTATIONDATA, "注入购票终点站线路名: "+mIntent.getStringExtra(END_SUBWAY_LABEL));
                    mIntent.putExtra(END_STATION_INDEX,position+1+"");
                    Log.d(BUYSTATIONDATA, "注入购票终点站索引: "+mIntent.getStringExtra(END_STATION_INDEX));
                    mIntent.putExtra(END_STATION_LABEL,mDataList.get(position).getLine_text());
                    Log.d(BUYSTATIONDATA, "注入购票终点站站名: "+mIntent.getStringExtra(END_STATION_LABEL));
                }
                startActivity(mIntent);
            }
        });
    }

    public Boolean IsFromStart(){
        return mEndSubwayIndex==null ? Boolean.TRUE:Boolean.FALSE;
    }

    public void initdata(){
        if (mStartSubwayLabel.equals("二号线")){
            mDataList=new ArrayList<ItemStationLineData>();
            mDataList.add(new ItemStationLineData("后卫寨"));
            mDataList.add(new ItemStationLineData("三桥"));
            mDataList.add(new ItemStationLineData("阿房路"));
            mDataList.add(new ItemStationLineData("汉城路"));
            mDataList.add(new ItemStationLineData("洒金桥"));
            mDataList.add(new ItemStationLineData("五路口"));
            mDataList.add(new ItemStationLineData("朝阳门"));
            mDataList.add(new ItemStationLineData("万寿路"));
            mDataList.add(new ItemStationLineData("纺织城"));
        } else {
            mDataList = new ArrayList<ItemStationLineData>();
            mDataList.add(new ItemStationLineData("北客站"));
            mDataList.add(new ItemStationLineData("运动公园"));
            mDataList.add(new ItemStationLineData("市图书馆"));
            mDataList.add(new ItemStationLineData("大明宫西"));
            mDataList.add(new ItemStationLineData("安远门"));
            mDataList.add(new ItemStationLineData("钟楼"));
            mDataList.add(new ItemStationLineData("小寨"));
            mDataList.add(new ItemStationLineData("会展中心"));
            mDataList.add(new ItemStationLineData("韦曲南"));
        }
    }

    @Override
    protected void onPause() {
        HomeActivity_Ticket_Content.this.finish();
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