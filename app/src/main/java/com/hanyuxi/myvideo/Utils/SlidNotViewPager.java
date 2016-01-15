package com.hanyuxi.myvideo.Utils;

/**
 * @TODO ViewPager+ViewPager��ͻ���
 * @User ${����}
 * @Time 2015/11/14 0014.
 */

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class SlidNotViewPager extends ViewPager {
    //����λ��
    private float lastX;
    //�������ң��������ұߵ��¼�
    private boolean slidingLeft;
    //�������󣬲�������ߵ��¼�
    private boolean slidingRight;

    public SlidNotViewPager(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    public SlidNotViewPager(final Context context) {
        super(context);
    }

    @Override
    public boolean onTouchEvent(final MotionEvent ev) {
        //��ȡ�¼�����
        final int action = ev.getAction();
        switch (action) {
            //����
            case MotionEvent.ACTION_DOWN:
                //������ViewPager���ش����¼���
                this.getParent().requestDisallowInterceptTouchEvent(true);
                this.lastX = ev.getX();
                break;
            //�ɿ�
            case MotionEvent.ACTION_UP:
                //�ø�ViewPager���ش����¼���
                this.getParent().requestDisallowInterceptTouchEvent(false);
                this.lastX = ev.getX();
                this.slidingLeft = false;
                this.slidingRight = false;
                break;
            //����
            case MotionEvent.ACTION_MOVE:
                //����ǵ�һ��
                if (this.getCurrentItem() == 0) {
                    //���ұߵ���߻���������ViewPager���ش����¼�
                    if (this.lastX <= ev.getX() && !this.slidingRight) {
                        this.getParent().requestDisallowInterceptTouchEvent(false);
                    } else {
                        //�����ұ߻�����������ViewPager���ش����¼�
                        this.slidingRight = true;
                        this.lastX = ev.getX();
                        this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    //��������һ��item
                } else if (this.getCurrentItem() == this.getAdapter().getCount() - 1) {
                    //�����ұ߻�����������ViewPager���ش����¼�
                    if (this.lastX >= ev.getX() && !this.slidingLeft) {
                        this.getParent().requestDisallowInterceptTouchEvent(false);
                    } else {
                        //���ұߵ���߻���������ViewPager���ش����¼�
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