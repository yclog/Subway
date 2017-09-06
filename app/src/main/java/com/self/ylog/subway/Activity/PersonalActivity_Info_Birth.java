package com.self.ylog.subway.Activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bigkoo.pickerview.TimePickerView;
import com.self.ylog.subway.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by cylog on 2017/4/23.
 */

public class PersonalActivity_Info_Birth extends AppCompatActivity implements View.OnClickListener{
    private Context mContext=this;
    /**
     * 定义控件item
     * @control titlebar内控件
     * */
    private ImageView mIcon_Back;

    private Button mPersonal_Info_Birth_btn;
    private TimePickerView mTimePickerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info_birth);
        init_view();
        initTimePicker();
    }

    public void init_view(){
        mPersonal_Info_Birth_btn =(Button) findViewById(R.id.personal_info_birth_btn);
        mPersonal_Info_Birth_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTimePickerView.show(v);
            }
        });
        mIcon_Back=(ImageView) findViewById(R.id.icon_back);
        mIcon_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonalActivity_Info_Birth.this.finish();
            }
        });
    }

    @Override
    public void onClick(View v) {

    }

    /**
     * 重写返回键
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            PersonalActivity_Info_Birth.this.finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     *  初始化TimePicker控件参数0
     * */
    public void initTimePicker(){
        //获取当前时间
        long time=System.currentTimeMillis();
        Calendar currentDate=Calendar.getInstance();
        currentDate.setTimeInMillis(time);
        //控制时间范围(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
        //因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        startDate.set(1900,0,00);
        Calendar endDate = Calendar.getInstance();
        endDate.set(currentDate.get(Calendar.YEAR),currentDate.get(Calendar.MONTH),currentDate.get(Calendar.DAY_OF_MONTH));
        //时间选择器
        mTimePickerView = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                // 这里回调过来的v,就是show()方法里面所添加的 View 参数，如果show的时候没有添加参数，v则为null
                Button button = (Button) v;
                button.setText(getTime(date));
            }
        })
                .setType(TimePickerView.Type.YEAR_MONTH_DAY)
                .setLabel("年", "月", "日", "", "", "") //设置空字符串以隐藏单位提示   hide label
                .setDividerColor(Color.DKGRAY)
                .setContentSize(20)
                .setDate(selectedDate)
                .setRangDate(startDate,endDate)
                .build();
    }

    private String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    /**
     * 获取Context
     * */
    public Context getContext(){
        mContext=this;
        return mContext;
    }
}
