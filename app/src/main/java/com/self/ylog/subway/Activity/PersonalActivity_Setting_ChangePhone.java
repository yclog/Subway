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
    private ImageView mIconBack;
    /**
     * @control 主界面控件
     * */
    private EditText mEditTextPersonalChangePhoneTele;
    private EditText mEditTextPersonalChangePhoneVerifyCode;
    private Button mButtonPersonalChangePhoneGetVerifyCode;
    private Button mButtonPersonalChangePhone;

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
        mIconBack =(ImageView) findViewById(R.id.icon_back);
        mIconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonalActivity_Setting_ChangePhone.this.finish();
            }
        });
        mEditTextPersonalChangePhoneTele =(EditText) findViewById(R.id.edittext_personal_changephone_tele);
        mEditTextPersonalChangePhoneVerifyCode =(EditText) findViewById(R.id.edittext_personal_changephone_verifycode);
        mButtonPersonalChangePhoneGetVerifyCode =(Button) findViewById(R.id.button_personal_changephone_get_verifycode);
        mButtonPersonalChangePhoneGetVerifyCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getVerifyCode();
            }
        });
        mButtonPersonalChangePhone =(Button) findViewById(R.id.button_personal_changephone);
        mButtonPersonalChangePhone.setOnClickListener(new View.OnClickListener() {
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
        tele= mEditTextPersonalChangePhoneTele.getText().toString();
        //获取手机验证码
    }

    /**
     * 修改手机号
     * */
    private void changePhone(){

    }
}
