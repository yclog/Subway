package com.self.ylog.subway.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import com.self.ylog.subway.Adapter.RecyclerViewStationLineAdapter;
import com.self.ylog.subway.R;
import com.self.ylog.subway.Utils.itemStationLineData;
import java.util.ArrayList;
import java.util.List;
import static com.self.ylog.subway.Utils.StationConstant.*;
import static com.self.ylog.subway.Utils.DebugTag.*;

/**
 * Created by cylog on 2017/5/17.
 */

public class HomeActivity_Ticket_PickStart extends AppCompatActivity{
    private Context mContext=this;
    /**
     * 定义控件item
     * @control titlebar内控件
     * */
    private ImageView mIconBack;
    private List<itemStationLineData> mDataList;
    private RecyclerView mPickStartRecyclerView;
    private RecyclerViewStationLineAdapter mRecyclerViewStationLineAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_ticket_start);
        initView();
    }

    /**
     *  初始化控件，ID绑定
     *  findViewById
     * */
    public void initView(){
        initRecyclerView();
        mIconBack =(ImageView) findViewById(R.id.icon_back);
        mIconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity_Ticket_PickStart.this.finish();
            }
        });
    }

    public void initRecyclerView(){
        initDataList();
        mPickStartRecyclerView=(RecyclerView)findViewById(R.id.StationStart_RecyclerView);
        mRecyclerViewStationLineAdapter =new RecyclerViewStationLineAdapter(getContext(),mDataList);
        mPickStartRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mPickStartRecyclerView.setAdapter(mRecyclerViewStationLineAdapter);
        initEvent();
    }

    private void initEvent() {
        mRecyclerViewStationLineAdapter.setOnItemClickLitener(new RecyclerViewStationLineAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent mIntent=new Intent(getContext(),HomeActivity_Ticket_Content.class);

                //注入起始地铁线路索引
                mIntent.putExtra(START_SUBWAY_INDEX,position+1+"");
                Log.d(BUYSTATIONDATA, "注入起始地铁线路索引: "+mIntent.getStringExtra(START_SUBWAY_INDEX));
                //注入起始地铁线路名
                mIntent.putExtra(START_SUBWAY_LABEL,mDataList.get(position).getLine_text()+"");
                Log.d(BUYSTATIONDATA, "注入起始地铁线路名: "+mIntent.getStringExtra(START_SUBWAY_LABEL));
                startActivity(mIntent);
            }
        });
    }

    public void initDataList(){
        mDataList=new ArrayList<itemStationLineData>();
        mDataList.add(new itemStationLineData("一号线"));
        mDataList.add(new itemStationLineData("二号线"));
        mDataList.add(new itemStationLineData("三号线"));
        mDataList.add(new itemStationLineData("四号线"));
        mDataList.add(new itemStationLineData("五号线"));
    }

    /**
     * 重写返回键
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            HomeActivity_Ticket_PickStart.this.finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        HomeActivity_Ticket_PickStart.this.finish();
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
