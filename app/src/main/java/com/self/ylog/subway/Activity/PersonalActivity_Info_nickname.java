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
    private ImageView mIcon_Back;
    /**
     * @control 界面内控件
     * */
    private EditText mInfo_Nickname;
    private Button mInfo_Confirm;

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
        mIcon_Back=(ImageView) findViewById(R.id.icon_back);
        mIcon_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonalActivity_Info_nickname.this.finish();
            }
        });
        mInfo_Nickname=(EditText) findViewById(R.id.edittext_personal_info_nickname);
        mInfo_Confirm=(Button) findViewById(R.id.button_personal_confirm);
        mInfo_Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save_NickName();
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
    private void Save_NickName(){
        //用户昵称
        String nickname;
        nickname=mInfo_Nickname.getText().toString();
        //保存并同步网络

    }
}
