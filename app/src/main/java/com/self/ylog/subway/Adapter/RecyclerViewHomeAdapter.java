package com.self.ylog.subway.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import com.self.ylog.subway.Adapter.RecyclerViewHomeAdapter.RecyclerViewHolder;
import com.self.ylog.subway.R;
import com.self.ylog.subway.Utils.ItemHomeData;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by cylog on 2017/4/22.
 */

public class RecyclerViewHomeAdapter extends Adapter<RecyclerViewHolder>{

    private List<ItemHomeData> mDataList;
    private LayoutInflater mInflater;

    public RecyclerViewHomeAdapter(Context context, List<ItemHomeData> mDataList){
        mInflater = LayoutInflater.from(context);
        this.mDataList = mDataList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerViewHolder holder=new RecyclerViewHolder(mInflater.inflate(R.layout.recyclerview_home_style,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
        holder.mHome_Src.setImageResource(mDataList.get(position).home_src);
        holder.mHome_Title.setText(mDataList.get(position).home_title);
        holder.mHome_Thumb_Num.setText(mDataList.get(position).home_thumb_text);
        holder.mHome_Date.setText(mDataList.get(position).home_date);
        holder.mHome_Time.setText(mDataList.get(position).home_time);
        holder.isStared=mDataList.get(position).isStared;
        if(holder.isStared){
            //已经点赞过，点赞按钮设置为已经点击格式
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int posistion=holder.getLayoutPosition();
//                    mOnItemClickLitener.onItemClick(holder.itemView,posistion);
            }
        });
        //点赞事件监听
        holder.mHome_Thumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thumb_num=Integer.parseInt(holder.mHome_Thumb_Num.getText().toString())+1;
                holder.mHome_Thumb_Num.setText(thumb_num+"");
            }
        });
    }

    @Override
    public void onViewRecycled(RecyclerViewHolder holder) {
        super.onViewRecycled(holder);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    static class RecyclerViewHolder extends ViewHolder{
        //标题主照片
        ImageView mHome_Src;
        //标题
        TextView mHome_Title;
        //点赞按钮
        ImageView mHome_Thumb;
        //点赞数目
        TextView mHome_Thumb_Num;
        //消息日期
        TextView mHome_Date;
        //消息时间
        TextView mHome_Time;
        //是否已经点赞
        Boolean isStared;

        public RecyclerViewHolder(View itemView){
            super(itemView);
            mHome_Src=(ImageView) itemView.findViewById(R.id.home_src);
            mHome_Thumb=(ImageView) itemView.findViewById(R.id.home_thumb);
            mHome_Title=(TextView) itemView.findViewById(R.id.home_title);
            mHome_Thumb_Num =(TextView) itemView.findViewById(R.id.home_thumb_text);
            mHome_Date=(TextView) itemView.findViewById(R.id.home_date);
            mHome_Time=(TextView) itemView.findViewById(R.id.home_time);
        }
    }
}
