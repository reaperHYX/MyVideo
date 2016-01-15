package com.hanyuxi.myvideo.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hanyuxi.myvideo.Adapter.MainFragmentAdapter;
import com.hanyuxi.myvideo.Fragment.MyFragment;
import com.hanyuxi.myvideo.Fragment.NavigationFragment;
import com.hanyuxi.myvideo.Fragment.RankFragment;
import com.hanyuxi.myvideo.Fragment.RecommendFragment;
import com.hanyuxi.myvideo.R;
import com.hanyuxi.myvideo.Utils.SlidNotViewPager;

import java.util.ArrayList;

/**
 * Created by ï¿½ï¿½ï¿½ï¿½É­ on 2015/11/13.
 */
public class MainActivity extends FragmentActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private SlidNotViewPager viewPager;
    private AlertDialog dialog;
    private RelativeLayout rl_title;
    private TextView tv_title;
    private ImageView iv_recommend;
    private ImageView iv_navigation;
    private ImageView iv_discover;
    private ImageView iv_my;
    private TextView tv_dis_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avtivity_mian);
        viewPager = (SlidNotViewPager) findViewById(R.id.view_pager);
        ArrayList<Fragment> list = new ArrayList<>();
        RecommendFragment recommendFragment = new RecommendFragment();
        NavigationFragment navigationFragment = new NavigationFragment();
        RankFragment rankFragment = new RankFragment();
        MyFragment myFragment = new MyFragment();
        list.add(recommendFragment);
        list.add(navigationFragment);
        list.add(rankFragment);
        list.add(myFragment);
        FragmentManager fragmentManager = getSupportFragmentManager();
        MainFragmentAdapter adapter = new MainFragmentAdapter(fragmentManager, list);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(this);
        findView();
        iv_recommend.setOnClickListener(MainActivity.this);
        iv_navigation.setOnClickListener(MainActivity.this);
        iv_discover.setOnClickListener(MainActivity.this);
        iv_my.setOnClickListener(MainActivity.this);
        exit();
    }

    private void findView() {
        rl_title = (RelativeLayout) findViewById(R.id.rl_title);
        tv_title = (TextView) findViewById(R.id.tv_title);
        iv_recommend = (ImageView) findViewById(R.id.iv_reco);
        iv_navigation = (ImageView) findViewById(R.id.iv_navi);
        iv_discover = (ImageView) findViewById(R.id.iv_disc);
        iv_my = (ImageView) findViewById(R.id.iv_my);
        tv_dis_add = (TextView) findViewById(R.id.tv_disc_add);
    }

    private void initRecommend() {
        rl_title.setVisibility(View.GONE);
        iv_recommend.setImageResource(R.drawable.menu_tuijian_selected);
    }

    private void initNavigation() {
        rl_title.setVisibility(View.VISIBLE);
        tv_title.setText(R.string.daohang);
        iv_navigation.setImageResource(R.drawable.menu_daohang_selected);
    }

    private void initDiscover() {
        rl_title.setVisibility(View.VISIBLE);
        tv_title.setText(R.string.find);
        iv_discover.setImageResource(R.drawable.menu_find_selected);
        tv_dis_add.setTextColor(getResources().getColor(R.color.bottom_select));
    }

    private void initMy() {
        rl_title.setVisibility(View.VISIBLE);
        tv_title.setText(R.string.mine);
        iv_my.setImageResource(R.drawable.menu_my_selected);
    }

    //Í¼±êÖØÖÃ
    private void reset() {
        rl_title.setVisibility(View.GONE);
        iv_recommend.setImageResource(R.drawable.menu_tuijian);
        iv_navigation.setImageResource(R.drawable.menu_daohang);
        iv_discover.setImageResource(R.drawable.menu_find);
        iv_my.setImageResource(R.drawable.menu_my);
        tv_dis_add.setTextColor(getResources().getColor(R.color.bottom_normal));
    }

    //ÍË³ö·½·¨
    private void exit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.dialog_tishi);
        builder.setMessage(R.string.dialog_ask);
        builder.setIcon(R.drawable.tip_icon);
        builder.setPositiveButton(R.string.dialog_exit, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton(R.string.dialog_watchmore, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        dialog = builder.create();
    }

    @Override
    public void onBackPressed() {
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        reset();
        switch (v.getId()) {
            case R.id.iv_reco:
                viewPager.setCurrentItem(0);
                initRecommend();
                break;
            case R.id.iv_navi:
                viewPager.setCurrentItem(1);
                initNavigation();
                break;
            case R.id.iv_disc:
                viewPager.setCurrentItem(2);
                initDiscover();
                break;
            case R.id.iv_my:
                viewPager.setCurrentItem(3);
                initMy();
                break;
        }
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    //ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ñ¡ï¿½ï¿½fragment
    @Override
    public void onPageSelected(int i) {
        reset();
        viewPager.setCurrentItem(i);
        switch (i) {
            case 0:
                initRecommend();
                break;
            case 1:
                initNavigation();
                break;
            case 2:
                initDiscover();
                break;
            case 3:
                initMy();
                break;
        }

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
