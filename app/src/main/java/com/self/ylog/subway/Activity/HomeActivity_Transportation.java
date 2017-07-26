package com.self.ylog.subway.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.self.ylog.subway.R;

/**
 * Created by cylog on 2017/4/27.
 */

public class HomeActivity_Transportation extends AppCompatActivity{
    private Context mContext=this;
    /**
     * 定义控件item
     * @control titlebar内控件
     * */
    private ImageView mIcon_Back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_transportation);
        initView();
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
                HomeActivity_Transportation.this.finish();
            }
        });
    }
    /**
     * 重写返回键
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            HomeActivity_Transportation.this.finish();
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
