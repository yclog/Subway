package com.self.ylog.subway.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.self.ylog.subway.R;

/**
 * Created by cylog on 2017/4/27.
 */

public class PersonalActivity_Setting extends AppCompatActivity implements View.OnClickListener{
    private Context mContext=this;
    /**
     * 定义控件item
     * @control titlebar内控件
     * */
    private ImageView mIconBack;
    private RelativeLayout mPersonalSettingChangeLanguage;
    private RelativeLayout mPersonalSettingChangePhone;
    private RelativeLayout mPersonalSettingExit;
    private RelativeLayout mPersonalSettingChangePassword;
    private Button mPersonalSettingLoginOut;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_setting);
        initView();
    }

    /**
     *  初始化控件，ID绑定
     *  findViewById
     * */
    public void initView(){
        mPersonalSettingChangeLanguage =(RelativeLayout) findViewById(R.id.personal_setting_changelanguage);
        mPersonalSettingChangeLanguage.setOnClickListener(this);
        mPersonalSettingChangePhone =(RelativeLayout) findViewById(R.id.personal_setting_changephone);
        mPersonalSettingChangePhone.setOnClickListener(this);
        mPersonalSettingExit =(RelativeLayout) findViewById(R.id.personal_setting_exit);
        mPersonalSettingExit.setOnClickListener(this);
        mPersonalSettingChangePassword =(RelativeLayout) findViewById(R.id.personal_setting_changpwd);
        mPersonalSettingChangePassword.setOnClickListener(this);
        mPersonalSettingLoginOut =(Button) findViewById(R.id.personal_setting_logout);
        mPersonalSettingLoginOut.setOnClickListener(this);
        mIconBack =(ImageView) findViewById(R.id.icon_back);
        mIconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonalActivity_Setting.this.finish();
            }
        });
    }

    /**
     * 监听控件点击事件
     * */
    @Override
    public void onClick(View view) {
        Intent mIntent;
        switch (view.getId()){
            case R.id.personal_setting_changelanguage:
                Toast.makeText(getContext(),"程序员哥哥们正在努力开发中…",Toast.LENGTH_SHORT).show();
                break;
            case R.id.personal_setting_changephone:
                mIntent=new Intent(getContext(), PersonalActivity_Setting_ChangePhone.class);
                startActivity(mIntent);
                break;
            case R.id.personal_setting_exit:
                Toast.makeText(getContext(),"程序员哥哥们正在努力开发中…",Toast.LENGTH_SHORT).show();
                break;
            case R.id.personal_setting_changpwd:
                mIntent=new Intent(getContext(), PersonalActivity_Setting_ChangePwd.class);
                startActivity(mIntent);
                break;
            case R.id.personal_setting_logout:
                Toast.makeText(getContext(),"程序员哥哥们正在努力开发中…",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * 重写返回键
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            PersonalActivity_Setting.this.finish();
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
