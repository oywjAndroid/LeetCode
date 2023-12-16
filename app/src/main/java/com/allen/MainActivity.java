package com.allen;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.allen.leetcode.R;
import com.allen.views.FlexibleHorizontalScrollView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FlexibleHorizontalScrollView flexibleHorizontalScrollView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flexibleHorizontalScrollView = findViewById(R.id.chs_view);

        List<String> list = new ArrayList<>();
        list.add("第1个View");
        list.add("第2个View");
        list.add("第3个View");
        list.add("第4个View");
        list.add("第5个View");
        flexibleHorizontalScrollView.setAdapter(new MyAdapter(list));
    }

    public void onClickScrollToChildView(View view){
        flexibleHorizontalScrollView.scrollToPosition(3);
    }

    public class MyAdapter extends FlexibleHorizontalScrollView.FlexibleAdapter<String>{

        public MyAdapter(List<String> data) {
            super(data);
        }

        @SuppressLint("SetTextI18n")
        @Override
        public View getView(int position, ViewGroup parent) {
            TextView textView = new TextView(parent.getContext());
            textView.setText(getItem(position));
            textView.setTextColor(Color.parseColor("#ff0000"));
            textView.setGravity(Gravity.CENTER);
            if (position == 0) {
                textView.setBackgroundColor(getColor(R.color.black));
            } else if (position == 1) {
                textView.setBackgroundColor(getColor(R.color.teal_200));
            } else if (position == 2) {
                textView.setBackgroundColor(getColor(R.color.purple_500));
            } else if (position == 3) {
                textView.setBackgroundColor(getColor(R.color.teal_700));
            } else {
                textView.setBackgroundColor(getColor(R.color.purple_700));
            }
            return textView;
        }
    }
}