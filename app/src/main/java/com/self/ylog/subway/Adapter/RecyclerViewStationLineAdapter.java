package com.self.ylog.subway.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.self.ylog.subway.Adapter.RecyclerViewStationLineAdapter.RecyclerViewStationLineViewHolder;
import com.self.ylog.subway.R;
import com.self.ylog.subway.Utils.itemStationLineData;

import java.util.List;

/**
 * Created by cylog on 2017/5/17.
 */

public class RecyclerViewStationLineAdapter extends RecyclerView.Adapter<RecyclerViewStationLineViewHolder>{
    private List<itemStationLineData> mSataList;
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

    public RecyclerViewStationLineAdapter(Context context, List<itemStationLineData> mSataList) {
        mLayoutInflater=LayoutInflater.from(context);
        this.mSataList = mSataList;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewStationLineViewHolder holder, int position) {
        holder.mLine_Text.setText(mSataList.get(position).getLine_text());

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
        return mSataList.size();
    }

    static class RecyclerViewStationLineViewHolder extends RecyclerView.ViewHolder{
        private TextView mLine_Text;

        public RecyclerViewStationLineViewHolder(View itemView) {
            super(itemView);
            mLine_Text=(TextView) itemView.findViewById(R.id.stationline_text);
        }
    }
}
