package com.allen.views;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * <pre>
 *     author : allenjones
 *     e-mail : weijunouyang@lerke.cn
 *     time   : 2023/12/17
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class CustomTabLayout extends TabLayout {

    public CustomTabLayout(Context context) {
        super(context);
    }

    public CustomTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        // 控制Tab的宽度
        for (int i = 0; i < getTabCount(); i++) {
            View tab = getTabAt(i).view;
            tab.setMinimumWidth(0);
            tab.getLayoutParams().width = calculateTabWidth();
        }
    }

    private int calculateTabWidth() {
        // 根据需要自定义计算Tab的宽度的逻辑
        int tabWidth = getWidth() / 3;
        Log.i("Test", "tabWidth = " + tabWidth);
        return tabWidth;
    }
}

