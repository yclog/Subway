package com.self.ylog.subway.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.self.ylog.subway.R;

/**
 * Created by cylog on 2017/4/27.
 */

public class PersonalActivity_Setting_ChangePhone extends AppCompatActivity{
    private Context mContext=this;
    /**
     * 定义控件item
     * @control titlebar内控件
     * */
    private ImageView mIcon_Back;
    /**
     * @control 主界面控件
     * */
    private EditText mEditText_Personal_ChangePhone_Tele;
    private EditText mEditText_Personal_ChangePhone_VerifyCode;
    private Button mButton_Personal_ChangePhone_Get_VerifyCode;
    private Button mButton_Personal_ChangePhone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_setting_changephone);
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
                PersonalActivity_Setting_ChangePhone.this.finish();
            }
        });
        mEditText_Personal_ChangePhone_Tele=(EditText) findViewById(R.id.edittext_personal_changephone_tele);
        mEditText_Personal_ChangePhone_VerifyCode=(EditText) findViewById(R.id.edittext_personal_changephone_verifycode);
        mButton_Personal_ChangePhone_Get_VerifyCode=(Button) findViewById(R.id.button_personal_changephone_get_verifycode);
        mButton_Personal_ChangePhone_Get_VerifyCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getVerifyCode();
            }
        });
        mButton_Personal_ChangePhone=(Button) findViewById(R.id.button_personal_changephone);
        mButton_Personal_ChangePhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePhone();
            }
        });
    }

    /**
     * 重写返回键
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            PersonalActivity_Setting_ChangePhone.this.finish();
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
     * 获取验证码
     * */
    private void getVerifyCode(){
        //需要修改的新手机号和验证码
        String tele;
        String verifyCode;
        tele=mEditText_Personal_ChangePhone_Tele.getText().toString();
        //获取手机验证码
    }

    /**
     * 修改手机号
     * */
    private void changePhone(){

    }
}
