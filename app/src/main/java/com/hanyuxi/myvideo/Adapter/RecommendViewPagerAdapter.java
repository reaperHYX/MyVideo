package com.hanyuxi.myvideo.Adapter;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hanyuxi.myvideo.Bean.RecordListBean;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

/**
 * Created by 韩先森 on 2015/11/13.
 */
public class RecommendViewPagerAdapter extends PagerAdapter {

    private FragmentActivity activity;
    private ArrayList<View> viewArrayList;

    public RecommendViewPagerAdapter(FragmentActivity activity, ArrayList<View> viewArrayList) {
        this.activity = activity;
        this.viewArrayList = viewArrayList;
    }

    @Override//加载数据的数量
    public int getCount() {
        return viewArrayList.size();
    }

    //加载view到控件中
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = viewArrayList.get(position);
        container.addView(view);//往容器中添加view
        return view;
    }

    //判断当前的view是否来自于添加对象
    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }

    //销毁item
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewArrayList.get(position));
    }
}
