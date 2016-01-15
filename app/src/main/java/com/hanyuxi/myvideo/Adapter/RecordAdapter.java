package com.hanyuxi.myvideo.Adapter;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.reflect.TypeToken;
import com.hanyuxi.myvideo.Activity.VideoPlayActivity;
import com.hanyuxi.myvideo.Bean.RecordListBean;
import com.hanyuxi.myvideo.Bean.RecordListInfoBean;
import com.hanyuxi.myvideo.Bean.VedioPlayBean;
import com.hanyuxi.myvideo.R;
import com.hanyuxi.myvideo.Utils.Url;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Created by hanyu on 2015/12/25.
 */
public class RecordAdapter extends BaseAdapter {
    private String url = "";
    private String url1 = "";
    private String url2 = "";
    private String url3 = "";
    private String url4 = "";
    private String url5 = "";
    private String urlTest = "http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2015/10/8/1444275804344_649.jpg";
    private ArrayList<RecordListInfoBean.DataEntity.ItemListEntity> itemListEntityArrayList = new ArrayList<>();
    private ArrayList<RecordListInfoBean.DataEntity.BigImgEntity> bigImgEntityArrayList = new ArrayList<>();
    private FragmentActivity activity;

    private ArrayList<RecordListBean.DataEntity.ColumnListEntity> list_column = new ArrayList<>();
    private VedioPlayBean bean;


    public RecordAdapter(FragmentActivity activity, ArrayList<RecordListBean.DataEntity.ColumnListEntity> list_column) {
        this.activity = activity;
        this.list_column = list_column;
    }

    @Override
    public int getCount() {
        return list_column.size();
    }

    @Override
    public Object getItem(int position) {
        return list_column.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //使用viewHold优化listView
        ViewHolder holder = null;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater mInflater = LayoutInflater.from(activity);
            convertView = mInflater.inflate(R.layout.item_reco, null);
            holder.textView0 = (TextView) convertView.findViewById(R.id.tv_name);
            holder.textView1 = (TextView) convertView.findViewById(R.id.tv_title1);
            holder.textView2 = (TextView) convertView.findViewById(R.id.tv_title2);
            holder.textView3 = (TextView) convertView.findViewById(R.id.tv_title3);
            holder.textView4 = (TextView) convertView.findViewById(R.id.tv_title4);
            holder.textView5 = (TextView) convertView.findViewById(R.id.tv_title5);
            holder.imageView1 = (ImageView) convertView.findViewById(R.id.iv_vedio1);
            holder.imageView2 = (ImageView) convertView.findViewById(R.id.iv_vedio2);
            holder.imageView3 = (ImageView) convertView.findViewById(R.id.iv_vedio3);
            holder.imageView4 = (ImageView) convertView.findViewById(R.id.iv_vedio4);
            holder.imageView5 = (ImageView) convertView.findViewById(R.id.iv_vedio5);
            convertView.setTag(holder);//设置tag
        } else {
            holder = (ViewHolder) convertView.getTag();//获取tag
        }
        holder.textView0.setText(list_column.get(position).getTitle());
        //使用ion加载item中的数据
        url = list_column.get(position).getTemplateUrl();
        final ViewHolder finalHolder = holder;
        Ion.with(activity).load(url).as(new TypeToken<RecordListInfoBean>() {
        })
                .setCallback(new FutureCallback<RecordListInfoBean>() {
                    @Override
                    public void onCompleted(Exception e, RecordListInfoBean result) {
                        if (result == null) {
                            Log.e("is empty", "is empty");
                        } else {
                            itemListEntityArrayList = new ArrayList<>();
                            bigImgEntityArrayList = new ArrayList<>();
                            bigImgEntityArrayList.addAll(result.getData().getBigImg());
                            itemListEntityArrayList.addAll(result.getData().getItemList());//获取图片内容集合
                            //使用ion加载图片
                            if (bigImgEntityArrayList.get(0).getImgUrl() == urlTest) {
                                Log.e("wrong", null);
                                finalHolder.imageView1.setVisibility(View.GONE);
                                finalHolder.textView1.setVisibility(View.GONE);
                            } else {
                                Ion.with(finalHolder.imageView1).error(R.drawable.list_big).placeholder(R.drawable.list_big)
                                        .load(bigImgEntityArrayList.get(0).getImgUrl());
                                finalHolder.textView1.setText(bigImgEntityArrayList.get(0).getTitle());

                            }
                            Ion.with(finalHolder.imageView2).error(R.drawable.list_normai).placeholder(R.drawable.list_normai)
                                    .load(itemListEntityArrayList.get(0).getImgUrl());
                            Ion.with(finalHolder.imageView3).error(R.drawable.list_normai).placeholder(R.drawable.list_normai)
                                    .load(itemListEntityArrayList.get(1).getImgUrl());
                            Ion.with(finalHolder.imageView4).error(R.drawable.list_normai).placeholder(R.drawable.list_normai)
                                    .load(itemListEntityArrayList.get(2).getImgUrl());
                            Ion.with(finalHolder.imageView5).error(R.drawable.list_normai).placeholder(R.drawable.list_normai)
                                    .load(itemListEntityArrayList.get(3).getImgUrl());
                            //加载标题
                            finalHolder.textView2.setText(itemListEntityArrayList.get(0).getTitle());
                            finalHolder.textView3.setText(itemListEntityArrayList.get(1).getTitle());
                            finalHolder.textView4.setText(itemListEntityArrayList.get(2).getTitle());
                            finalHolder.textView5.setText(itemListEntityArrayList.get(3).getTitle());
                            //设置监听播放
                            finalHolder.imageView1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    url1 = Url.URL_V + bigImgEntityArrayList.get(0).getVid();
                                    sendData(url1);
                                }
                            });
                            finalHolder.imageView2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    url2 = Url.URL_V + itemListEntityArrayList.get(0).getVid();
                                    sendData(url2);

                                }
                            });
                            finalHolder.imageView3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    url3 = Url.URL_V + itemListEntityArrayList.get(1).getVid();
                                    sendData(url3);
                                }
                            });
                            finalHolder.imageView4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    url4 = Url.URL_V + itemListEntityArrayList.get(2).getVid();
                                    sendData(url4);
                                }
                            });
                            finalHolder.imageView5.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    url5 = Url.URL_V + itemListEntityArrayList.get(3).getVid();
                                    sendData(url5);
                                }
                            });

                        }
                    }
                });


        return convertView;
    }

    //viewHold类
    class ViewHolder {
        public TextView textView0;
        public TextView textView1;
        public TextView textView2;
        public TextView textView3;
        public TextView textView4;
        public TextView textView5;
        public ImageView imageView1;
        public ImageView imageView2;
        public ImageView imageView3;
        public ImageView imageView4;
        public ImageView imageView5;


    }

    //跳转界面，传递数据
    private void sendData(String url) {
        Ion.with(activity).load(url).as(new TypeToken<VedioPlayBean>() {
        })
                .setCallback(new FutureCallback<VedioPlayBean>() {
                    @Override
                    public void onCompleted(Exception e, VedioPlayBean result) {
                        if (result == null) {
                            Log.e("视频播放", null);
                        } else {
                            bean = new VedioPlayBean();
                            bean = result;
                            //跳转界面传递数据
                            Intent intent = new Intent(activity, VideoPlayActivity.class);
                            intent.putExtra("videoBean", bean);
                            activity.startActivity(intent);
                        }
                    }
                });
    }
}
