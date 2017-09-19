package com.self.ylog.subway.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.self.ylog.subway.R;

/**
 * Created by cylog on 2017/4/27.
 * Function:用户登陆界面
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    //界面控件
    private TextView mTele;
    private TextView mPasswd;
    private TextView mForgetPwd;
    private Button mLoginBtn;
    private Button mRegisterBtn;
    //登陆失败
    private static int LOGIN_FAILED=0;
    //登陆成功
    private static int LOGIN_SUCCESS=1;
    //登陆账号无效
    private static String LOGIN_INVAILD_ACCOUNT="账号不存在";
    //登陆密码无效
    private static String LOGIN_INVAILD_PASSWORD="密码错误，请再次输入";
    //登陆账号密码为空
    private static String LOGIN_EMPTY_MESSAGE="账号密码不可为空";
    //网络连接失败
    private static String NO_NETWORK="网络连接失败";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    //初始化控件
    private void initView(){
        mTele=(TextView) findViewById(R.id.login_tele);
        mPasswd=(TextView) findViewById(R.id.login_pwd);
        mForgetPwd=(TextView) findViewById(R.id.login_forget);
        mForgetPwd.setOnClickListener(this);
        mLoginBtn =(Button) findViewById(R.id.login_btn);
        mLoginBtn.setOnClickListener(this);
        mRegisterBtn =(Button) findViewById(R.id.login_register);
        mRegisterBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_forget:{
                break;
            }
            case R.id.login_btn:{
                toLogin();
                break;
            }
            case R.id.login_register:{
                Intent intent=new Intent(this,RegisterActivity.class);
                startActivity(intent);
                break;
            }
        }
    }

    /**
     * 登陆
     * */
    private void toLogin(){
        //用户账号密码
        String tele=mTele.getText().toString();
        String passwd=mPasswd.getText().toString();
        //判断输入为空
        if (TextUtils.isEmpty(tele)||TextUtils.isEmpty(passwd)){
            Toast.makeText(getApplicationContext(),LOGIN_EMPTY_MESSAGE,Toast.LENGTH_SHORT).show();
        }
        //尝试登陆
        tryLogin(tele,passwd);
    }

    /**
     * 尝试登陆
     * */
    private void tryLogin(String tele,String passwd){
        //检查网络连接

        //加密发送登陆请求
    }

}
