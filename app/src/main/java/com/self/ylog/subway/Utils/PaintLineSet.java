package com.self.ylog.subway.Utils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cylog on 2017/5/23.
 * 初始化地铁线路图内各线路点坐标
 */

public class PaintLineSet {
    private List<PathNode> mDataList;
    private PaintLineSet mPaintLineSet;

    //获取当前类实例
    public PaintLineSet getInstance(){
        if (mPaintLineSet == null) {
            return mPaintLineSet =new PaintLineSet();
        }
        return mPaintLineSet;
    }

    //获取数据集
    public List<PathNode> getDataList(int index){
        if (mDataList == null) {
            mDataList=new ArrayList<PathNode>();
        }
        initDataList(index,mDataList);
        return mDataList;
    }

    private void initDataList(int index,List<PathNode> mDataList){
        switch (index){
            case 1:
                initLineOne(mDataList);
                break;
            case 2:
                initLineTwo(mDataList);
                break;
            case 3:
                initLineThree(mDataList);
                break;
            case 4:
                initLineFour(mDataList);
                break;
        }
    }

    private void initLineOne(List<PathNode> mDataList){
        if (mDataList.size() != 0){
            mDataList.clear();
        }
        mDataList.add(new PathNode(80,140));
        mDataList.add(new PathNode(160,220));
        mDataList.add(new PathNode(240,300));
        mDataList.add(new PathNode(360,300));
        mDataList.add(new PathNode(360,300));
        mDataList.add(new PathNode(420,300));
        mDataList.add(new PathNode(500,300));
        mDataList.add(new PathNode(600,300));
        mDataList.add(new PathNode(700,300));
        mDataList.add(new PathNode(800,250));
        mDataList.add(new PathNode(900,200));
    }

    private void initLineTwo(List<PathNode> mDataList){
        if (mDataList.size() != 0){
            mDataList.clear();
        }
        mDataList.add(new PathNode(500,100));
        mDataList.add(new PathNode(500,200));
        mDataList.add(new PathNode(500,300));
        mDataList.add(new PathNode(500,400));
        mDataList.add(new PathNode(500,500));
        mDataList.add(new PathNode(500,600));
        mDataList.add(new PathNode(500,700));
        mDataList.add(new PathNode(500,800));
        mDataList.add(new PathNode(500,900));
        mDataList.add(new PathNode(500,1000));
    }

    private void initLineThree(List<PathNode> mDataList){
        if (mDataList.size() != 0){
            mDataList.clear();
        }
        mDataList.add(new PathNode(100,750));
        mDataList.add(new PathNode(200,800));
        mDataList.add(new PathNode(300,800));
        mDataList.add(new PathNode(400,800));
        mDataList.add(new PathNode(500,800));
        mDataList.add(new PathNode(600,800));
        mDataList.add(new PathNode(700,800));
        mDataList.add(new PathNode(800,800));
        mDataList.add(new PathNode(900,800));
    }

    private void initLineFour(List<PathNode> mDataList){
        if (mDataList.size() != 0){
            mDataList.clear();
        }
        mDataList.add(new PathNode(300,500));
        mDataList.add(new PathNode(400,500));
        mDataList.add(new PathNode(600,500));
        mDataList.add(new PathNode(700,500));
        mDataList.add(new PathNode(700,600));
        mDataList.add(new PathNode(700,700));
        mDataList.add(new PathNode(700,800));
        mDataList.add(new PathNode(700,900));
        mDataList.add(new PathNode(800,900));
    }
}
