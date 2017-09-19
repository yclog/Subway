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

public class PersonalActivity_Info_nickname extends AppCompatActivity{
    private Context mContext=this;
    /**
     * @control titlebar内控件
     * */
    private ImageView mIconBack;
    /**
     * @control 界面内控件
     * */
    private EditText mInfoNickName;
    private Button mInfoConfirm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info_nickname);
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
                PersonalActivity_Info_nickname.this.finish();
            }
        });
        mInfoNickName =(EditText) findViewById(R.id.edittext_personal_info_nickname);
        mInfoConfirm =(Button) findViewById(R.id.button_personal_confirm);
        mInfoConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNickName();
            }
        });
    }
    /**
     * 重写返回键
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            PersonalActivity_Info_nickname.this.finish();
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
     * 设置用户名
     * */
    private void saveNickName(){
        //用户昵称
        String nickname;
        nickname= mInfoNickName.getText().toString();
        //保存并同步网络

    }
}
