package com.hanyuxi.myvideo.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.reflect.TypeToken;
import com.hanyuxi.myvideo.Adapter.RecommendViewPagerAdapter;
import com.hanyuxi.myvideo.Adapter.RecordAdapter;
import com.hanyuxi.myvideo.Bean.RecordListBean;
import com.hanyuxi.myvideo.R;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;


/**
 * Created by ����ɭ on 2015/11/13.
 */
public class RecommendFragment extends Fragment {
    private View view;
    private ArrayList<RecordListBean.DataEntity.BigImgEntity> list_head = new ArrayList();
    private ArrayList<RecordListBean.DataEntity.ColumnListEntity> list_column = new ArrayList();
    private ArrayList<View> viewArrayList = new ArrayList<>();
    private String url = "";
    private TextView tv_list_view_head_title;
    private ImageView iv_list_head_image;
    private ViewPager reco_viewpager;
    private ListView reco_listview;
    private RecordAdapter adapter;
    private RecommendViewPagerAdapter adapter1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_reco, null);
        initListView();
        getData();
        return view;
    }

    //��ȡ����
    private void getData() {
        url = "http://cbox.cntv.cn/json2015/shouye/tuijian/index.json";
        Ion.with(getActivity())
                .load(url)
                .as(new TypeToken<RecordListBean>() {
                })
                .setCallback(new FutureCallback<RecordListBean>() {
                    @Override
                    public void onCompleted(Exception e, RecordListBean result) {
                        if (result.getData().getBigImg() == null) {
                        } else {
                            list_head.addAll(result.getData().getBigImg());
                            Log.e("here has wrong", result.getData().getBigImg().size() + "");
                            list_column.addAll(result.getData().getColumnList());
                            adapter.notifyDataSetChanged();//ˢ��������
                            adapter1.notifyDataSetChanged();//ˢ��������
                        }
                    }
                });
    }

    //���listView
    private void initListView() {
        reco_listview = (ListView) view.findViewById(R.id.reco_listview);
        View headView = View.inflate(getActivity(), R.layout.viewpager_reco, null);
        reco_viewpager = (ViewPager) headView.findViewById(R.id.reco_viewpager);
        //׼������
        for (int i = 0; i < list_head.size(); i++) {
            View view1 = View.inflate(getActivity(), R.layout.inflate_view_pager, null);
            iv_list_head_image = (ImageView) view1.findViewById(R.id.iv_list_head_image);//�ҵ�viewpager
            tv_list_view_head_title = (TextView) view1.findViewById(R.id.tv_list_view_head_title);//�ҵ�����
            tv_list_view_head_title.setText(list_head.get(i).getTitle());
            Ion.with(iv_list_head_image)
                    .error(R.drawable.viewpager_img)
                    .placeholder(R.drawable.viewpager_img).load(list_head.get(i).getBigImgUrl());
            viewArrayList.add(view1);
        }
        // ViewPager������
        adapter1 = new RecommendViewPagerAdapter(getActivity(), viewArrayList);
        reco_viewpager.setAdapter(adapter1);
        reco_listview.addHeaderView(headView); //���ͷ��
        //����listView������
        adapter = new RecordAdapter(getActivity(), list_column);
        reco_listview.setAdapter(adapter);

    }

}
