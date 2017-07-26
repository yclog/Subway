package com.self.ylog.subway.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.self.ylog.subway.R;
import com.self.ylog.subway.Utils.ItemStationData;
import com.self.ylog.subway.View.CircleImageView;

import java.util.List;

/**
 * Created by cylog on 2017/5/14.
 */

public class RecyclerViewTicketAdapter extends RecyclerView.Adapter<RecyclerViewTicketAdapter.RecyclerViewTicketHolder>{
    private List<ItemStationData> mDateList;
    private LayoutInflater mLayoutInflater;

    public RecyclerViewTicketAdapter(Context context, List<ItemStationData> mDateList) {
        mLayoutInflater=LayoutInflater.from(context);
        this.mDateList = mDateList;
    }

    @Override
    public RecyclerViewTicketHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerViewTicketHolder holder=new RecyclerViewTicketHolder(mLayoutInflater.inflate(R.layout.recyclerview_station_style,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewTicketHolder holder, int position) {
        holder.station_status.setText(mDateList.get(position).getStation_status());
        holder.station_state.setText(mDateList.get(position).getStation_state());
        holder.line_up.setVisibility(mDateList.get(position).getIshow_up() ? View.VISIBLE: View.INVISIBLE);
        holder.line_dowm.setVisibility(mDateList.get(position).getIshow_dowm() ? View.VISIBLE: View.INVISIBLE);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mDateList.size();
    }

    static class RecyclerViewTicketHolder extends RecyclerView.ViewHolder{
        //地铁站状态
        private TextView station_status;
        //地铁站
        private TextView station_state;
        //上部分线View
        private View line_up;
        //线上的点
        private CircleImageView line_dot;
        //下部分线View
        private View line_dowm;

        public RecyclerViewTicketHolder(View itemView) {
            super(itemView);
            station_status=(TextView) itemView.findViewById(R.id.station_status);
            station_state=(TextView) itemView.findViewById(R.id.station_state);
            line_up=(View) itemView.findViewById(R.id.line_up);
            line_dot=(CircleImageView) itemView.findViewById(R.id.line_dot);
            line_dowm=(View) itemView.findViewById(R.id.line_dowm);
        }
    }
}
