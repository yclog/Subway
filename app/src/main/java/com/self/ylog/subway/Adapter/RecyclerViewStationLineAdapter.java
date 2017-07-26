package com.self.ylog.subway.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.self.ylog.subway.Activity.HomeActivity_Ticket_Content;
import com.self.ylog.subway.Adapter.RecyclerViewStationLineAdapter.RecyclerViewStationLineViewHolder;
import com.self.ylog.subway.R;
import com.self.ylog.subway.Utils.ItemStationLineData;

import java.util.List;

/**
 * Created by cylog on 2017/5/17.
 */

public class RecyclerViewStationLineAdapter extends RecyclerView.Adapter<RecyclerViewStationLineViewHolder>{
    private List<ItemStationLineData> mdatalist;
    private LayoutInflater mLayoutInflater;

    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    @Override
    public RecyclerViewStationLineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerViewStationLineViewHolder holder=new RecyclerViewStationLineViewHolder(
                mLayoutInflater.inflate(R.layout.recyclerview_home_stationline,parent,false));
        return holder;
    }

    public RecyclerViewStationLineAdapter(Context context, List<ItemStationLineData> mdatalist) {
        mLayoutInflater=LayoutInflater.from(context);
        this.mdatalist = mdatalist;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewStationLineViewHolder holder, int position) {
        holder.mLine_Text.setText(mdatalist.get(position).getLine_text());

        // 如果设置了回调，则设置点击事件
        if (mOnItemClickLitener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mdatalist.size();
    }

    static class RecyclerViewStationLineViewHolder extends RecyclerView.ViewHolder{
        private TextView mLine_Text;

        public RecyclerViewStationLineViewHolder(View itemView) {
            super(itemView);
            mLine_Text=(TextView) itemView.findViewById(R.id.stationline_text);
        }
    }
}
