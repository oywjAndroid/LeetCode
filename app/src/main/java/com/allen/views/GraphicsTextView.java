package com.allen.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.allen.leetcode.R;

/**
 * <pre>
 *     author : allenjones
 *     e-mail : weijunouyang@lerke.cn
 *     time   : 2023/12/16
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class GraphicsTextView extends ConstraintLayout {

    public GraphicsTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initViews(context);
    }

    private void initViews(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_graphics_text, this, true);
    }
}
