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

import com.self.ylog.subway.Adapter.RecyclerViewOrderAdapter;
import com.self.ylog.subway.R;
import com.self.ylog.subway.Utils.ItemOrderData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cylog on 2017/4/27.
 */

public class PersonalActivity_Route extends AppCompatActivity{
    private Context mContext=this;
    /**
     * 定义控件item
     * @control titlebar内控件
     * */
    private ImageView mIcon_Back;
    /**
     * 行程订单（RecyclerView）
     * */
    private RecyclerView mOrderRecyclerView;
    private RecyclerViewOrderAdapter mOrderRecyclerViewAdapter;
    //数据保存表
    private List<ItemOrderData> mDataList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_order);
        initView();
        init_RecyclerView();
    }

    public void init_RecyclerView(){
        initDataList();
        mOrderRecyclerView=(RecyclerView)findViewById(R.id.Order_RecyclerView);
        mOrderRecyclerViewAdapter =new RecyclerViewOrderAdapter(getContext(),mDataList);
        mOrderRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mOrderRecyclerView.setAdapter(mOrderRecyclerViewAdapter);
    }

    /**
     * 初始化行程数据表
     * */
    public void initDataList(){
        //设置测试数据
        mDataList=new ArrayList<ItemOrderData>();
        for (int i = 0; i <5 ; i++) {
            mDataList.add(new ItemOrderData("地铁","已完成","05-08","20:47","西安市.五路口-地铁站","西安市.西安北站-地铁站"));
        }
        //导入在线数据
    }

    /**
     *  初始化控件，ID绑定
     *  findViewById
     * */
    public void initView(){
        mIcon_Back=(ImageView) findViewById(R.id.icon_back);
        mIcon_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonalActivity_Route.this.finish();
            }
        });
    }
    /**
     * 重写返回键
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            PersonalActivity_Route.this.finish();
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
