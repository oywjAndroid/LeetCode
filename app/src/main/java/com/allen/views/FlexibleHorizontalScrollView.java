package com.allen.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import java.util.List;

/**
 * <pre>
 *     author : allenjones
 *     e-mail : weijunouyang@lerke.cn
 *     time   : 2023/12/16
 *     desc   : 基于 HorizontalScrollView 拓展的水平滚动控件，它可以在用户滑动后自适应滚动到相应的ChildView.
 *     version: 1.0
 * </pre>
 */
public class FlexibleHorizontalScrollView extends HorizontalScrollView {
    private LinearLayout mParentView;
    private int mChildWidth;
    private FlexibleAdapter<?> mAdapter;
    private int mFirstVisiblePosition = 0;

    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        init();
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FlexibleHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setHorizontalScrollBarEnabled(false);
        mParentView = new LinearLayout(getContext());
        mParentView.setOrientation(LinearLayout.HORIZONTAL);
        addView(mParentView);
    }

    /**
     * 设置适配器
     *
     * @param adapter FlexibleAdapter
     */
    public void setAdapter(FlexibleAdapter<?> adapter) {
        mAdapter = adapter;
        updateViews();
    }

    /**
     * 跳转到指定位置的ChildView
     *
     * @param position childView position
     */
    public void scrollToPosition(int position) {
        if (position < 0 || position >= mParentView.getChildCount()) {
            return;
        }

        position = Math.max(0, Math.min(position, mParentView.getChildCount() - 1));
        int scrollToX = position * mChildWidth;
        scrollTo(scrollToX, 0);
        //mFirstVisiblePosition = getFirstVisiblePosition();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        // 计算子视图的平均宽度
        if (mParentView.getChildCount() == 1) {
            mChildWidth = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
        } else {
            mChildWidth = (getMeasuredWidth() - getPaddingLeft() - getPaddingRight()) / 3;
        }

        // 设置每个子视图的宽度
        for (int i = 0; i < mParentView.getChildCount(); i++) {
            View child = mParentView.getChildAt(i);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) child.getLayoutParams();
            layoutParams.width = mChildWidth;
            layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
            child.setLayoutParams(layoutParams);
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        boolean isConsume = super.onTouchEvent(ev);
        if (ev.getAction() == MotionEvent.ACTION_UP) {
            // 用户手指抬起时，处理滑动位置
            handleScrollPosition();
        }
        return isConsume;
    }

    @Override
    public void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        // 当滚动位置发生变化时，更新第一个可见 childView 的 position
        mFirstVisiblePosition = calcFirstVisiblePosition();
    }

    private int calcFirstVisiblePosition() {
        int firstVisibleX = getScrollX() + getPaddingLeft();
        return firstVisibleX / mChildWidth;
    }


    public int getFirstVisiblePosition() {
        return mFirstVisiblePosition;
    }

    private void updateViews() {
        mParentView.removeAllViews();
        for (int i = 0; i < mAdapter.getCount(); i++) {
            View child = mAdapter.getView(i, mParentView);
            mParentView.addView(child);
        }
    }

    private void handleScrollPosition() {
        int scrollX = getScrollX();
        int newPosition = scrollX / mChildWidth;
        int remainder = scrollX % mChildWidth;

        // 判断当前滚动位置是否超过 childView 宽度的一半
        if (remainder > mChildWidth / 3) {
            newPosition += 1;
        }

        // 限制 newPosition 不超过子视图的数量
        newPosition = Math.max(0, Math.min(newPosition, mParentView.getChildCount() - 1));

        int scrollToX = newPosition * mChildWidth;
        smoothScrollTo(scrollToX, 0);
    }

    /**
     * 适配器
     */
    public static abstract class FlexibleAdapter<T> {
        private final List<T> mData;

        public FlexibleAdapter(List<T> data) {
            mData = data;
        }

        public abstract View getView(int position, ViewGroup parent);

        public T getItem(int position) {
            return mData.get(position);
        }

        public int getCount() {
            return mData != null ? mData.size() : 0;
        }
    }
}
