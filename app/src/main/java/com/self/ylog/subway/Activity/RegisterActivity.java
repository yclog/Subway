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
 * Function:用户注册界面
 */

public class RegisterActivity extends AppCompatActivity{
    private Context mContext=this;
    /**
     * @control titlebar内控件
     * */
    private ImageView mIcon_Cancel;
    /**
     * @control 主界面控件
     * */
    private EditText mTele;
    private EditText mVerifyCode;
    private EditText mPasswd;
    private Button mRegister_btn;
    private Button mGetVerifyCode_btn;
    //注册账号无效
    private static String REGISTER_INVAILD_ACCOUNT="此账号已经存在";
    //注册密码无效
    private static String REGISTER_INVAILD_PASSWORD="密码错误，请按照格式输入";
    //注册账号密码为空
    private static String REGISTER_EMPTY_MESSAGE="账号密码不可为空";
    //验证码错误
    private static String REGISTER_INVALID_VERIFYCODE="验证码错误";
    //网络连接失败
    private static String NO_NETWORK="网络连接失败";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    /**
     *  初始化控件，ID绑定
     *  findViewById
     * */
    public void initView(){
        //titlebar控件
        mIcon_Cancel=(ImageView) findViewById(R.id.icon_cancel);
        mIcon_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterActivity.this.finish();
            }
        });
        //主界面控件
        mTele=(EditText) findViewById(R.id.register_tele);
        mPasswd=(EditText) findViewById(R.id.register_pwd);
        mVerifyCode=(EditText) findViewById(R.id.register_code);
        mRegister_btn=(Button) findViewById(R.id.register_btn);
        mRegister_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });
        mGetVerifyCode_btn=(Button) findViewById(R.id.getVerifyCode_btn);
        mGetVerifyCode_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetVerifyCode();
            }
        });
    }
    /**
     * 重写返回键
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            RegisterActivity.this.finish();
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
     * 注册
     * */
    private void Register(){
        //用户账号密码
        String tele=mTele.getText().toString();
        String verifycode=mVerifyCode.getText().toString();
        String passwd=mPasswd.getText().toString();
        //判断输入为空
        if (TextUtils.isEmpty(tele)||TextUtils.isEmpty(passwd)){
            Toast.makeText(getContext(),REGISTER_EMPTY_MESSAGE,Toast.LENGTH_SHORT).show();
        }
        //尝试注册
        tryRegister(tele,verifycode,passwd);
    }

    /**
     * 尝试注册
     * */
    private void tryRegister(String tele,String verifycode,String passwd){
        //检查网络连接

        //加密发送注册请求
    }

    /**
     * 获取验证码
     * */
    private void GetVerifyCode(){
        //注册手机号
        String tele=mTele.getText().toString();
        //发送验证请求，获取验证码到手机
    }
}
