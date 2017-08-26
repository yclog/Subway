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

public class PersonalActivity_Setting_ChangePwd extends AppCompatActivity{
    private Context mContext=this;
    /**
     * 定义控件item
     * @control titlebar内控件
     * */
    private ImageView mIcon_Back;
    /**
     * @control 主界面控件
     * */
    private EditText mEditText_Setting_ChangePwd_Oldpwd;
    private EditText mEditText_Setting_ChangePwd_Newpwd;
    private EditText mEditText_Setting_ChangePwd_Verifypwd;
    private Button mButton_Setting_Changepwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_setting_changepwd);
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
                PersonalActivity_Setting_ChangePwd.this.finish();
            }
        });
        mEditText_Setting_ChangePwd_Oldpwd=(EditText) findViewById(R.id.edittext_setting_changepwd_oldpwd);
        mEditText_Setting_ChangePwd_Newpwd=(EditText) findViewById(R.id.edittext_setting_changepwd_newpwd);
        mEditText_Setting_ChangePwd_Verifypwd=(EditText) findViewById(R.id.edittext_setting_changepwd_verifypwd);
        mButton_Setting_Changepwd=(Button) findViewById(R.id.button_setting_changepwd);
        mButton_Setting_Changepwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePasswd();
            }
        });
    }
    /**
     * 重写返回键
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            PersonalActivity_Setting_ChangePwd.this.finish();
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
     * 修改密码
     * */
    private void changePasswd(){
        //新旧密码
        String oldpasswd;
        String newpasswd;
        String verifypasswd;
        oldpasswd=mEditText_Setting_ChangePwd_Oldpwd.getText().toString();
        newpasswd=mEditText_Setting_ChangePwd_Newpwd.getText().toString();
        verifypasswd=mEditText_Setting_ChangePwd_Verifypwd.getText().toString();
        //提交修改密码请求
    }
}
