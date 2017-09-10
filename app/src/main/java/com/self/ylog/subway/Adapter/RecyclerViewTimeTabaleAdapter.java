package com.self.ylog.subway.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.self.ylog.subway.R;
import com.self.ylog.subway.Utils.ItemNewsData;

import java.util.List;

/**
 * Created by cylog on 2017/5/7.
 */

public class RecyclerViewTimeTabaleAdapter extends RecyclerView.Adapter<RecyclerViewTimeTabaleAdapter.RecyclerViewHolder> {

    private List<ItemNewsData> mDataList;
    private LayoutInflater mInflater;

    //设置header
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;

    private View mHeaderView;

    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }

    public View getHeaderView() {
        return mHeaderView;
    }

    public RecyclerViewTimeTabaleAdapter(Context context, List<ItemNewsData> mDataList){
        mInflater = LayoutInflater.from(context);
        this.mDataList = mDataList;
    }

    @Override
    public int getItemViewType(int position) {
        if(mHeaderView == null) return TYPE_NORMAL;
        if(position == 0) return TYPE_HEADER;
        return TYPE_NORMAL;
    }

    @Override
    public RecyclerViewTimeTabaleAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mHeaderView != null && viewType == TYPE_HEADER) return new RecyclerViewHolder(mHeaderView);
        RecyclerViewHolder holder=new RecyclerViewHolder(mInflater.inflate(R.layout.recyclerview_news_style,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewTimeTabaleAdapter.RecyclerViewHolder holder, int position) {
        //判断为首部
        if(getItemViewType(position) == TYPE_HEADER) return;
        final int realposition = getRealPosition(holder);
        //判断为RecyclerView
        holder.mNews_Src.setImageResource(mDataList.get(realposition).news_src);
        holder.mNews_Title.setText(mDataList.get(realposition).news_title);
        holder.mNews_Thumb_Num.setText(mDataList.get(realposition).news_thumb_num);
        holder.mNews_Comment_Num.setText(mDataList.get(realposition).news_comment_num);
        holder.mNews_Date.setText(mDataList.get(realposition).news_date);
        holder.mNews_Time.setText(mDataList.get(realposition).news_time);
        holder.isStared=mDataList.get(realposition).isStared;
        if(holder.isStared){
            //已经点赞过，点赞按钮设置为已经点击格式
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.mNews_Thumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thumb_num=Integer.parseInt(holder.mNews_Thumb_Num.getText().toString())+1;
                holder.mNews_Thumb_Num.setText(thumb_num+"");
            }
        });
        holder.mNews_Comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thumb_num=Integer.parseInt(holder.mNews_Comment_Num.getText().toString())+1;
                holder.mNews_Comment_Num.setText(thumb_num+"");
            }
        });
    }

    public int getRealPosition(RecyclerViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;
    }

    @Override
    public int getItemCount() {
        return mHeaderView == null ? mDataList.size() : mDataList.size() + 1;
    }

    @Override
    public void onViewRecycled(RecyclerViewHolder holder) {
        super.onViewRecycled(holder);
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        //标题主照片
        ImageView mNews_Src;
        //标题
        TextView mNews_Title;
        //点赞按钮
        ImageView mNews_Thumb;
        //点赞数目
        TextView mNews_Thumb_Num;
        //评论按钮
        ImageView mNews_Comment;
        //评论数目
        TextView mNews_Comment_Num;
        //消息日期
        TextView mNews_Date;
        //消息时间
        TextView mNews_Time;
        //是否已经点赞
        Boolean isStared;

        public RecyclerViewHolder(View itemView){
            super(itemView);
            mNews_Src=(ImageView) itemView.findViewById(R.id.news_src);
            mNews_Title=(TextView) itemView.findViewById(R.id.news_title_text);
            mNews_Thumb=(ImageView) itemView.findViewById(R.id.news_thumb);
            mNews_Thumb_Num=(TextView) itemView.findViewById(R.id.news_thumb_text);
            mNews_Comment=(ImageView) itemView.findViewById(R.id.news_comment);
            mNews_Comment_Num=(TextView) itemView.findViewById(R.id.news_comment_text);
            mNews_Date=(TextView) itemView.findViewById(R.id.news_date);
            mNews_Time=(TextView) itemView.findViewById(R.id.news_time);
        }
    }
}
