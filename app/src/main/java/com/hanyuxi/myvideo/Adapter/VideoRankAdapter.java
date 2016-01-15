package com.hanyuxi.myvideo.Adapter;

import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hanyuxi.myvideo.Bean.RankBean;
import com.hanyuxi.myvideo.R;
import com.koushikdutta.ion.Ion;

import java.util.List;


/**
 * Created by hanyu on 2015/12/27.
 */
public class VideoRankAdapter extends BaseAdapter {
    private FragmentActivity activity;
    private List<RankBean.ResultsEntity> list;

    public VideoRankAdapter(FragmentActivity activity, List<RankBean.ResultsEntity> list) {
        this.activity=activity;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(activity);
            convertView = inflater.inflate(R.layout.item_rank, null);
            holder.tv_rank_num = (TextView) convertView.findViewById(R.id.tv_rank_num);
            holder.tv_rank_vedio_name= (TextView) convertView.findViewById(R.id.tv_rank_vedio_name);
            holder.tv_rank_video_info= (TextView) convertView.findViewById(R.id.tv_rank_video_info);
            holder.iv_rank_cover= (ImageView) convertView.findViewById(R.id.iv_rank_cover);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_rank_num.setText(position+1+"");
        holder.tv_rank_vedio_name.setText(list.get(position).getName());
        holder.tv_rank_video_info.setText(list.get(position).getTotal_vv());
        Ion.with(holder.iv_rank_cover).error(R.drawable.list_normai)
                .placeholder(R.drawable.list_normai).load(list.get(position).getShow_thumburl());
        return convertView;
    }

    public static class ViewHolder {
        private TextView tv_rank_num;
        private TextView tv_rank_vedio_name;
        private TextView tv_rank_video_info;
        private ImageView iv_rank_cover;

    }
}
