package com.hanyuxi.myvideo.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.reflect.TypeToken;
import com.hanyuxi.myvideo.Adapter.VideoRankAdapter;
import com.hanyuxi.myvideo.Bean.RankBean;
import com.hanyuxi.myvideo.R;
import com.hanyuxi.myvideo.Utils.Url;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 韩先森 on 2015/11/13.
 */
public class RankFragment extends Fragment {
    private View view;
    private List<RankBean.ResultsEntity> list1 = new ArrayList();
    private List<RankBean.ResultsEntity> list2 = new ArrayList();
    private List<RankBean.ResultsEntity> list3 = new ArrayList();
    private List<RankBean.ResultsEntity> list4 = new ArrayList();

    private ListView listView_tvplay;
    private ListView listView_movie;
    private ListView listView_variety;
    private ListView listView_animation;
    private TextView tv_rank_title_tvplay;
    private TextView tv_rank_title_movie;
    private TextView tv_rank_title_animation;
    private TextView tv_rank_title_variety;
    private VideoRankAdapter adapter1, adapter2, adapter3, adapter4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_rank, null);
        initView();//加载控件
        //准备数据
        getData(Url.RANK_URL_HEAD + "97" + Url.RANK_URL_BEHIND, list1, adapter1);
        getData(Url.RANK_URL_HEAD + "96" + Url.RANK_URL_BEHIND, list2, adapter2);
        getData(Url.RANK_URL_HEAD + "85" + Url.RANK_URL_BEHIND, list3, adapter3);
        getData(Url.RANK_URL_HEAD + "100" + Url.RANK_URL_BEHIND, list4, adapter4);

        return view;
    }

    //获取数据的方法
    private void getData(String url, final List<RankBean.ResultsEntity> list, final VideoRankAdapter adapter) {
        Ion.with(getActivity()).load(url).as(new TypeToken<RankBean>() {
        })
                .setCallback(new FutureCallback<RankBean>() {
                    @Override
                    public void onCompleted(Exception e, RankBean result) {
                        if (result == null) {
                            Log.e("is empty", "null");
                        } else {
                            list.addAll(result.getResults());
                            adapter.notifyDataSetChanged();
                        }
                    }
                });
    }

    private void initView() {
        //查找控件
        listView_tvplay = (ListView) view.findViewById(R.id.listView_tvplay);
        listView_movie = (ListView) view.findViewById(R.id.listView_movie);
        listView_variety = (ListView) view.findViewById(R.id.listView_variety);
        listView_animation = (ListView) view.findViewById(R.id.listView_animation);
        adapter1 = new VideoRankAdapter(getActivity(), list1);
        adapter2 = new VideoRankAdapter(getActivity(), list2);
        adapter3 = new VideoRankAdapter(getActivity(), list3);
        adapter4 = new VideoRankAdapter(getActivity(), list4);

        listView_tvplay.setAdapter(adapter1);
        listView_movie.setAdapter(adapter2);
        listView_variety.setAdapter(adapter3);
        listView_animation.setAdapter(adapter4);
        //查找控件
        tv_rank_title_tvplay = (TextView) view.findViewById(R.id.tv_rank_title_tvplay);
        tv_rank_title_movie = (TextView) view.findViewById(R.id.tv_rank_title_movie);
        tv_rank_title_variety = (TextView) view.findViewById(R.id.tv_rank_title_variety);
        tv_rank_title_animation = (TextView) view.findViewById(R.id.tv_rank_title_animation);
        //设置监听事件显示隐藏listView
        tv_rank_title_tvplay.setOnClickListener(new View.OnClickListener() {
            //重置标题颜色，加载不同的url
            @Override
            public void onClick(View v) {
                resetTitleColor();
                listView_tvplay.setVisibility(View.VISIBLE);
                listView_animation.setVisibility(View.GONE);
                listView_movie.setVisibility(View.GONE);
                listView_variety.setVisibility(View.GONE);
                tv_rank_title_tvplay.setTextColor(getResources().getColor(R.color.title_select));
            }
        });
        tv_rank_title_movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTitleColor();
                listView_movie.setVisibility(View.VISIBLE);
                listView_animation.setVisibility(View.GONE);
                listView_tvplay.setVisibility(View.GONE);
                listView_variety.setVisibility(View.GONE);
                tv_rank_title_movie.setTextColor(getResources().getColor(R.color.title_select));
            }
        });
        tv_rank_title_variety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                resetTitleColor();
                listView_variety.setVisibility(View.VISIBLE);
                listView_animation.setVisibility(View.GONE);
                listView_movie.setVisibility(View.GONE);
                listView_tvplay.setVisibility(View.GONE);
                tv_rank_title_variety.setTextColor(getResources().getColor(R.color.title_select));
            }
        });
        tv_rank_title_animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTitleColor();
                listView_animation.setVisibility(View.VISIBLE);
                listView_tvplay.setVisibility(View.GONE);
                listView_movie.setVisibility(View.GONE);
                listView_variety.setVisibility(View.GONE);
                tv_rank_title_animation.setTextColor(getResources().getColor(R.color.title_select));
            }
        });
    }

    //重置标题颜色
    private void resetTitleColor() {
        tv_rank_title_tvplay.setTextColor(getResources().getColor(R.color.black));
        tv_rank_title_movie.setTextColor(getResources().getColor(R.color.black));
        tv_rank_title_animation.setTextColor(getResources().getColor(R.color.black));
        tv_rank_title_variety.setTextColor(getResources().getColor(R.color.black));
    }
}
