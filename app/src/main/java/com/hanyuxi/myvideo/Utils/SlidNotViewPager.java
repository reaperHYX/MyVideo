package com.hanyuxi.myvideo.Utils;

/**
 * @TODO ViewPager+ViewPager冲突解决
 * @User ${孤狼}
 * @Time 2015/11/14 0014.
 */

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class SlidNotViewPager extends ViewPager {
    //最后的位置
    private float lastX;
    //由左至右，不监听右边的事件
    private boolean slidingLeft;
    //由右至左，不监听左边的事件
    private boolean slidingRight;

    public SlidNotViewPager(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    public SlidNotViewPager(final Context context) {
        super(context);
    }

    @Override
    public boolean onTouchEvent(final MotionEvent ev) {
        //获取事件类型
        final int action = ev.getAction();
        switch (action) {
            //按下
            case MotionEvent.ACTION_DOWN:
                //不允许父ViewPager拦截触摸事件。
                this.getParent().requestDisallowInterceptTouchEvent(true);
                this.lastX = ev.getX();
                break;
            //松开
            case MotionEvent.ACTION_UP:
                //让父ViewPager拦截触摸事件。
                this.getParent().requestDisallowInterceptTouchEvent(false);
                this.lastX = ev.getX();
                this.slidingLeft = false;
                this.slidingRight = false;
                break;
            //滑动
            case MotionEvent.ACTION_MOVE:
                //如果是第一项
                if (this.getCurrentItem() == 0) {
                    //从右边到左边滑动，允许父ViewPager拦截触摸事件
                    if (this.lastX <= ev.getX() && !this.slidingRight) {
                        this.getParent().requestDisallowInterceptTouchEvent(false);
                    } else {
                        //从左到右边滑动，不允许父ViewPager拦截触摸事件
                        this.slidingRight = true;
                        this.lastX = ev.getX();
                        this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    //如果是最后一个item
                } else if (this.getCurrentItem() == this.getAdapter().getCount() - 1) {
                    //从左到右边滑动，不允许父ViewPager拦截触摸事件
                    if (this.lastX >= ev.getX() && !this.slidingLeft) {
                        this.getParent().requestDisallowInterceptTouchEvent(false);
                    } else {
                        //从右边到左边滑动，允许父ViewPager拦截触摸事件
                        this.slidingLeft = true;
                        this.lastX = ev.getX();
                        this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                }
                break;
        }
        super.onTouchEvent(ev);
        return true;
    }

}