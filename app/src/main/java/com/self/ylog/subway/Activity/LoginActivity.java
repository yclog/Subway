package com.self.ylog.subway.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.self.ylog.subway.R;
import com.self.ylog.subway.Utils.LoginState;

/**
 * Created by cylog on 2017/4/27.
 * Function:
 */

public class MainActivity_Login extends AppCompatActivity implements View.OnClickListener{
    private TextView mTele;
    private TextView mPasswd;
    private TextView mForgetPwd;
    private Button Login_btn;
    private Button Register_btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init_View();

    }

    //初始化控件
    private void init_View(){
        mTele=(TextView) findViewById(R.id.login_tele);
        mPasswd=(TextView) findViewById(R.id.login_pwd);
        mForgetPwd=(TextView) findViewById(R.id.login_forget);
        mForgetPwd.setOnClickListener(this);
        Login_btn=(Button) findViewById(R.id.login_btn);
        Login_btn.setOnClickListener(this);
        Register_btn=(Button) findViewById(R.id.login_register);
        Register_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_forget:{
                break;
            }
            case R.id.login_btn:{
                break;
            }
            case R.id.login_register:{
                Intent intent=new Intent(this,MainActivity_Register.class);
                startActivity(intent);
                break;
            }
        }
    }

    /**
     * 重写返回键
     */
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            if (LoginState.getInstance().getLoginState()){
//                finish();
//            } else {
//                finish();
//            }
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }

}
