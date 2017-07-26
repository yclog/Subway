package com.self.ylog.subway.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.self.ylog.subway.Activity.SubwayActivity_ByTrain;
import com.self.ylog.subway.Activity.SubwayActivity_Info;
import com.self.ylog.subway.Activity.SubwayActivity_Law;
import com.self.ylog.subway.Activity.SubwayActivity_News;
import com.self.ylog.subway.Activity.SubwayActivity_Price;
import com.self.ylog.subway.Activity.SubwayActivity_Secure;
import com.self.ylog.subway.Adapter.RecyclerViewCardViewAdapter;
import com.self.ylog.subway.R;
import com.self.ylog.subway.Utils.ItemNewsData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by boy on 2017/4/12.
 */

public class SubwayFragment extends android.support.v4.app.Fragment implements View.OnClickListener{
    /**
     * 定义控件item
     * @control subheader内控件
     * */
    private RelativeLayout mSubway_News;
    private RelativeLayout mSubway_Info;
    private RelativeLayout mSubway_Price;
    private RelativeLayout mSubway_Law;
    private RelativeLayout mSubway_Secure;
    private RelativeLayout mSubway_Bytrain;
    //Recyclerview定义
    private RecyclerView mSubwayRecyclerView;
    private RecyclerViewCardViewAdapter mSubwayRecyclerViewAdaper;
    private List<ItemNewsData> mDataList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_subway,container,false);
        initView(view);
        init_RecyclerView(view);
        return view;
    }

    public void initView(View view){
        mSubway_News=(RelativeLayout) view.findViewById(R.id.subway_news);
        mSubway_News.setOnClickListener(this);
        mSubway_Price=(RelativeLayout) view.findViewById(R.id.subway_price);
        mSubway_Price.setOnClickListener(this);
        mSubway_Info=(RelativeLayout) view.findViewById(R.id.subway_info);
        mSubway_Info.setOnClickListener(this);
        mSubway_Law=(RelativeLayout) view.findViewById(R.id.subway_law);
        mSubway_Law.setOnClickListener(this);
        mSubway_Secure=(RelativeLayout) view.findViewById(R.id.subway_secure);
        mSubway_Secure.setOnClickListener(this);
        mSubway_Bytrain=(RelativeLayout) view.findViewById(R.id.subway_bytrain);
        mSubway_Bytrain.setOnClickListener(this);
    }

    public void init_RecyclerView(View view){
        initDataList();
        mSubwayRecyclerView=(RecyclerView) view.findViewById(R.id.Subway_RecyclerView);
        mSubwayRecyclerViewAdaper=new RecyclerViewCardViewAdapter(getContext(),mDataList);
        mSubwayRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mSubwayRecyclerView.setAdapter(mSubwayRecyclerViewAdaper);
    }

    public void initDataList(){
        mDataList=new ArrayList<ItemNewsData>();
        for (int i = 0; i <5 ; i++) {
            mDataList.add(new ItemNewsData(R.color.colorPrimary,"Test","50","50","05-07","23:33",false,"unknow"));
        }
    }

    @Override
    public void onClick(View view) {
        Intent mIntent;
        switch (view.getId()){
            case R.id.subway_news:
                mIntent=new Intent(getContext(), SubwayActivity_News.class);
                startActivity(mIntent);
                break;
            case R.id.subway_price:
                mIntent=new Intent(getContext(), SubwayActivity_Price.class);
                startActivity(mIntent);
                break;
            case R.id.subway_info:
                mIntent=new Intent(getContext(), SubwayActivity_Info.class);
                startActivity(mIntent);
                break;
            case R.id.subway_law:
                mIntent=new Intent(getContext(), SubwayActivity_Law.class);
                startActivity(mIntent);
                break;
            case R.id.subway_secure:
                mIntent=new Intent(getContext(), SubwayActivity_Secure.class);
                startActivity(mIntent);
                break;
            case R.id.subway_bytrain:
                mIntent=new Intent(getContext(), SubwayActivity_ByTrain.class);
                startActivity(mIntent);
                break;
        }
    }
}
