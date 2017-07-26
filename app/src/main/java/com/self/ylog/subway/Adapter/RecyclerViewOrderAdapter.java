package com.self.ylog.subway.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.self.ylog.subway.R;
import com.self.ylog.subway.Utils.ItemOrderData;
import java.util.List;
import com.self.ylog.subway.Adapter.RecyclerViewOrderAdapter.RecyclerViewOrderHolder;

/**
 * Created by cylog on 2017/5/8.
 */

public class RecyclerViewOrderAdapter extends RecyclerView.Adapter<RecyclerViewOrderHolder>{
    private List<ItemOrderData> mDataList;
    private LayoutInflater mLayoutInflater;

    public RecyclerViewOrderAdapter(Context context,List<ItemOrderData> mDataList){
        mLayoutInflater=LayoutInflater.from(context);
        this.mDataList=mDataList;
    }

    @Override
    public RecyclerViewOrderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerViewOrderHolder holder=new RecyclerViewOrderHolder(mLayoutInflater.inflate(R.layout.recyclerview_order_style,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewOrderHolder holder, int position) {
        holder.order_type.setText(mDataList.get(position).order_type);
        holder.order_status.setText(mDataList.get(position).order_status);
        holder.order_date.setText(mDataList.get(position).order_date);
        holder.order_time.setText(mDataList.get(position).order_time);
        holder.order_start.setText(mDataList.get(position).order_start);
        holder.order_end.setText(mDataList.get(position).order_end);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    static class RecyclerViewOrderHolder extends RecyclerView.ViewHolder{
        //乘车类型
        public TextView order_type;
        //订单状态
        public TextView order_status;
        //订单日期
        public TextView order_date;
        //订单时间
        public TextView order_time;
        //始发站
        public TextView order_start;
        //终点站
        public TextView order_end;

        public RecyclerViewOrderHolder(View itemView) {
            super(itemView);
            order_type=(TextView) itemView.findViewById(R.id.order_type);
            order_status=(TextView) itemView.findViewById(R.id.order_status);
            order_date=(TextView) itemView.findViewById(R.id.order_date);
            order_time=(TextView) itemView.findViewById(R.id.order_time);
            order_start=(TextView) itemView.findViewById(R.id.order_start);
            order_end=(TextView) itemView.findViewById(R.id.order_end);
        }
    }
}
