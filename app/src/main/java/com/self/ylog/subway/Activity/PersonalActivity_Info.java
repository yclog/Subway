package com.self.ylog.subway.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.self.ylog.subway.R;

/**
 * Created by cylog on 2017/4/27.
 */

public class PersonalActivity_Info extends AppCompatActivity implements View.OnClickListener{
    private Context mContext=this;
    /**
     * 定义控件item
     * @control titlebar内控件
     * */
    private ImageView mIcon_Back;
    private RelativeLayout mPersonal_Info_Avatar;
    private RelativeLayout mPersonal_Info_Nickname;
    private RelativeLayout mPersonal_Info_Birth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        initView();
    }

    /**
     *  初始化控件，ID绑定
     *  findViewById
     * */
    public void initView(){
        mPersonal_Info_Avatar=(RelativeLayout) findViewById(R.id.personal_info_avatar);
        mPersonal_Info_Avatar.setOnClickListener(this);
        mPersonal_Info_Nickname=(RelativeLayout) findViewById(R.id.personal_info_nickname);
        mPersonal_Info_Nickname.setOnClickListener(this);
        mPersonal_Info_Birth=(RelativeLayout) findViewById(R.id.personal_info_birth);
        mPersonal_Info_Birth.setOnClickListener(this);
        mIcon_Back=(ImageView) findViewById(R.id.icon_back);
        mIcon_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonalActivity_Info.this.finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent mIntent;
        switch (view.getId()){
            case R.id.personal_info_avatar:
                break;
            case R.id.personal_info_nickname:
                mIntent=new Intent(getContext(),PersonalActivity_Info_nickname.class);
                startActivity(mIntent);
                break;
            case R.id.personal_info_birth:
                mIntent=new Intent(getContext(),PersonalActivity_Info_Birth.class);
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
            PersonalActivity_Info.this.finish();
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

    /**
     * 获取头像和昵称
     * */
    private void getUserInfo(){

    }
}
