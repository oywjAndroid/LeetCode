package com.allen.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import java.lang.reflect.Field;

/**
 * <pre>
 *     author : allenjones
 *     e-mail : weijunouyang@lerke.cn
 *     time   : 2023/12/17
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class SlidingTabLayout extends TabLayout {

    public SlidingTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        post(this::resetTabParams);
    }

    private void resetTabParams() {
        LinearLayout tabStrip = getTabStrip();
        if (tabStrip == null) {
            return;
        }

        int tabWidth = getMeasuredWidth() / 3;

        for (int i = 0; i < tabStrip.getChildCount(); i++) {
            LinearLayout tabView = (LinearLayout) tabStrip.getChildAt(i);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(tabWidth, LinearLayout.LayoutParams
                    .WRAP_CONTENT);
            tabView.setLayoutParams(params);
        }
    }

    //反射拿到TabLayout里的mTabStrip（mTabStrip是TabView的父容器）
    @Nullable
    public LinearLayout getTabStrip() {
        Class<?> tabLayout = TabLayout.class;
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        llTab.setClipChildren(false);
        return llTab;
    }
}
