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
 * Created by ����ɭ on 2015/11/13.
 */
public class RecommendViewPagerAdapter extends PagerAdapter {

    private FragmentActivity activity;
    private ArrayList<View> viewArrayList;

    public RecommendViewPagerAdapter(FragmentActivity activity, ArrayList<View> viewArrayList) {
        this.activity = activity;
        this.viewArrayList = viewArrayList;
    }

    @Override//�������ݵ�����
    public int getCount() {
        return viewArrayList.size();
    }

    //����view���ؼ���
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = viewArrayList.get(position);
        container.addView(view);//�����������view
        return view;
    }

    //�жϵ�ǰ��view�Ƿ���������Ӷ���
    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }

    //����item
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewArrayList.get(position));
    }
}
