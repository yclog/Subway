package com.self.ylog.subway.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.self.ylog.subway.Adapter.RecyclerViewLifeAndSubwayAdapter;
import com.self.ylog.subway.R;
import com.self.ylog.subway.Utils.ItemNewsData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cylog on 2017/4/27.
 */

public class LifeActivity_Travel extends AppCompatActivity{
    private Context mContext=this;
    /**
     * 定义控件item
     * @control titlebar内控件
     * */
    private ImageView mIconBack;
    private RecyclerView mLifeTravelRecyclerView;
    private RecyclerViewLifeAndSubwayAdapter mLifeTravelRecyclerViewAdapter;
    private List<ItemNewsData> mDataList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_travel);
        initView();
        initRecyclerView();
    }

    public void initRecyclerView(){
        initDataList();
        mLifeTravelRecyclerView=(RecyclerView) findViewById(R.id.Life_Travel_RecyclerView);
        mLifeTravelRecyclerViewAdapter=new RecyclerViewLifeAndSubwayAdapter(getContext(),mDataList);
        mLifeTravelRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mLifeTravelRecyclerView.setAdapter(mLifeTravelRecyclerViewAdapter);
    }

    public void initDataList(){
        mDataList=new ArrayList<ItemNewsData>();
        for (int i = 0; i <5 ; i++) {
            mDataList.add(new ItemNewsData(R.color.colorPrimary,"Test","50","50","05-07","23:33",false,"info"));
        }
    }

    /**
     *  初始化控件，ID绑定
     *  findViewById
     * */
    public void initView(){
        mIconBack =(ImageView) findViewById(R.id.icon_back);
        mIconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LifeActivity_Travel.this.finish();
            }
        });
    }
    /**
     * 重写返回键
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            LifeActivity_Travel.this.finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 获取Context
     * */
    public Context getContext(){
        mContext=this;
        return mContext;
    }
}
