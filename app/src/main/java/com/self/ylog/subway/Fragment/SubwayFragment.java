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
import com.self.ylog.subway.Adapter.RecyclerViewLifeAndSubwayAdapter;
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
    private RelativeLayout mSubwayNews;
    private RelativeLayout mSubwayInfo;
    private RelativeLayout mSubwayPrice;
    private RelativeLayout mSubwayLaw;
    private RelativeLayout mSubwaySecure;
    private RelativeLayout mSubwayByTrain;
    //Recyclerview定义
    private RecyclerView mSubwayRecyclerView;
    private RecyclerViewLifeAndSubwayAdapter mSubwayRecyclerViewAdaper;
    private List<ItemNewsData> mDataList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_subway,container,false);
        initRecyclerView(view);
        return view;
    }

    public void initView(View view){
        mSubwayNews =(RelativeLayout) view.findViewById(R.id.subway_news);
        mSubwayNews.setOnClickListener(this);
        mSubwayPrice =(RelativeLayout) view.findViewById(R.id.subway_price);
        mSubwayPrice.setOnClickListener(this);
        mSubwayInfo =(RelativeLayout) view.findViewById(R.id.subway_info);
        mSubwayInfo.setOnClickListener(this);
        mSubwayLaw =(RelativeLayout) view.findViewById(R.id.subway_law);
        mSubwayLaw.setOnClickListener(this);
        mSubwaySecure =(RelativeLayout) view.findViewById(R.id.subway_secure);
        mSubwaySecure.setOnClickListener(this);
        mSubwayByTrain =(RelativeLayout) view.findViewById(R.id.subway_bytrain);
        mSubwayByTrain.setOnClickListener(this);
    }

    public void initRecyclerView(View view){
        initDataList();
        mSubwayRecyclerView=(RecyclerView) view.findViewById(R.id.Subway_RecyclerView);
        mSubwayRecyclerViewAdaper=new RecyclerViewLifeAndSubwayAdapter(getContext(),mDataList);
        mSubwayRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mSubwayRecyclerView.setAdapter(mSubwayRecyclerViewAdaper);
        setHeader(mSubwayRecyclerView);
    }

    private void setHeader(RecyclerView view) {
        View header = LayoutInflater.from(getContext()).inflate(R.layout.recyclerview_header_subway, view, false);
        mSubwayRecyclerViewAdaper.setHeaderView(header);
        initView(header);
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
