package com.hanyuxi.myvideo.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hanyuxi.myvideo.Activity.LoginActivity;
import com.hanyuxi.myvideo.R;

/**
 * Created by 韩先森 on 2015/11/13.
 */
public class MyFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_my,null);
        login();
        return view;
    }
    //跳转登陆界面
    public void login() {
        TextView textViewLogin= (TextView) view.findViewById(R.id.tv_not_login);
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                getActivity().startActivity(intent);
            }
        });

    }
}
