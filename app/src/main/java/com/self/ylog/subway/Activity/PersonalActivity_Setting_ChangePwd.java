package com.self.ylog.subway.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

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
    private ImageView mIconBack;
    /**
     * @control 主界面控件
     * */
    private EditText mEditTextSettingChangePasswordOldPassword;
    private EditText mEditTextSettingChangePasswordNewPassword;
    private EditText mEditTextSettingChangePasswordVerifyPassword;
    private Button mButtonSettingChangePassword;

    //填入密码信息为空
    private static String EMPTY_MESSAGE="密码不可为空";
    //网络连接失败
    private static String NO_NETWORK="网络连接失败";

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
        mIconBack =(ImageView) findViewById(R.id.icon_back);
        mIconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonalActivity_Setting_ChangePwd.this.finish();
            }
        });
        mEditTextSettingChangePasswordOldPassword =(EditText) findViewById(R.id.edittext_setting_changepwd_oldpwd);
        mEditTextSettingChangePasswordNewPassword =(EditText) findViewById(R.id.edittext_setting_changepwd_newpwd);
        mEditTextSettingChangePasswordVerifyPassword =(EditText) findViewById(R.id.edittext_setting_changepwd_verifypwd);
        mButtonSettingChangePassword =(Button) findViewById(R.id.button_setting_changepwd);
        mButtonSettingChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePassword();
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
    private void changePassword(){
        //新旧密码
        String oldpasswd;
        String newpasswd;
        String verifypasswd;
        oldpasswd= mEditTextSettingChangePasswordOldPassword.getText().toString();
        newpasswd= mEditTextSettingChangePasswordNewPassword.getText().toString();
        verifypasswd= mEditTextSettingChangePasswordVerifyPassword.getText().toString();
        //判空
        if (TextUtils.isEmpty(oldpasswd)||TextUtils.isEmpty(newpasswd)||TextUtils.isEmpty(verifypasswd)){
            Toast.makeText(getContext(),EMPTY_MESSAGE,Toast.LENGTH_SHORT).show();
        }
        //提交修改密码请求
    }
}
