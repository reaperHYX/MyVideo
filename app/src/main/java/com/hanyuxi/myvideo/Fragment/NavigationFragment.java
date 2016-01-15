package com.hanyuxi.myvideo.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hanyuxi.myvideo.R;


/**
 * Created by º«ÏÈÉ­ on 2015/11/13.
 */
public class NavigationFragment extends Fragment {
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_navi,null);
        return view;
    }
}
