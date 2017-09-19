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

import com.self.ylog.subway.Activity.LifeActivity_City;
import com.self.ylog.subway.Activity.LifeActivity_Favour;
import com.self.ylog.subway.Activity.LifeActivity_Gourmet;
import com.self.ylog.subway.Activity.LifeActivity_Literature;
import com.self.ylog.subway.Activity.LifeActivity_Travel;
import com.self.ylog.subway.Adapter.RecyclerViewLifeAndSubwayAdapter;
import com.self.ylog.subway.R;
import com.self.ylog.subway.Utils.ItemNewsData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by boy on 2017/4/12.
 */

public class LifeFragment extends android.support.v4.app.Fragment implements View.OnClickListener{
    /**
     * 定义控件item
     * @control subheader内控件
     * */
    private RelativeLayout mLifeFavour;
    private RelativeLayout mLifeLiterature;
    private RelativeLayout mLifeTravel;
    private RelativeLayout mLifeGourmet;
    private RelativeLayout mLifeCity;
    //recyclerview
    private RecyclerView mLifeRecyclerView;
    private RecyclerViewLifeAndSubwayAdapter mLifeRecyclerViewAdapter;
    private List<ItemNewsData> mDataList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_life,container,false);
        initRecyclerView(view);
        return view;
    }

    public void initRecyclerView(View view){
        initDataList();
        mLifeRecyclerView=(RecyclerView) view.findViewById(R.id.Life_RecyclerView);
        mLifeRecyclerViewAdapter =new RecyclerViewLifeAndSubwayAdapter(getContext(),mDataList);
        mLifeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mLifeRecyclerView.setAdapter(mLifeRecyclerViewAdapter);
        setHeader(mLifeRecyclerView);
    }

    private void setHeader(RecyclerView view) {
        View header = LayoutInflater.from(getContext()).inflate(R.layout.recyclerview_header_life, view, false);
        mLifeRecyclerViewAdapter.setHeaderView(header);
        initView(header);
    }

    public void initDataList(){
        mDataList=new ArrayList<ItemNewsData>();
        for (int i = 0; i <5 ; i++) {
            mDataList.add(new ItemNewsData(R.color.colorPrimary,"RecyclerView","50","50","05-08","20:03",true,"unknow"));
        }
    }

    public void initView(View view){
        mLifeFavour =(RelativeLayout) view.findViewById(R.id.life_favour);
        mLifeFavour.setOnClickListener(this);
        mLifeLiterature =(RelativeLayout) view.findViewById(R.id.life_literature);
        mLifeLiterature.setOnClickListener(this);
        mLifeTravel =(RelativeLayout) view.findViewById(R.id.life_travel);
        mLifeTravel.setOnClickListener(this);
        mLifeGourmet =(RelativeLayout) view.findViewById(R.id.life_gourmet);
        mLifeGourmet.setOnClickListener(this);
        mLifeCity =(RelativeLayout) view.findViewById(R.id.life_city);
        mLifeCity.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent mIntent;
        switch (view.getId()){
            case R.id.life_favour:
                mIntent=new Intent(getContext(), LifeActivity_Favour.class);
                startActivity(mIntent);
                break;
            case R.id.life_literature:
                mIntent=new Intent(getContext(), LifeActivity_Literature.class);
                startActivity(mIntent);
                break;
            case R.id.life_travel:
                mIntent=new Intent(getContext(), LifeActivity_Travel.class);
                startActivity(mIntent);
                break;
            case R.id.life_gourmet:
                mIntent=new Intent(getContext(), LifeActivity_Gourmet.class);
                startActivity(mIntent);
                break;
            case R.id.life_city:
                mIntent=new Intent(getContext(), LifeActivity_City.class);
                startActivity(mIntent);
                break;
        }
    }
}
