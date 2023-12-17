package com.allen;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.allen.leetcode.R;

public class MainActivity2 extends AppCompatActivity {
    private static final String TAG = MainActivity2.class.getSimpleName();


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        for (int i = 0; i < 1; i++) {
            View rootView = LayoutInflater.from(this).inflate(R.layout.view_tab, null, false);
            ImageView image = rootView.findViewById(R.id.image_view);
            TextView text = rootView.findViewById(R.id.text_view);
            text.setText("第" + (i + 1) + "个Tab");
            TabLayout.Tab tab = tabLayout.newTab();
            tab.setCustomView(rootView);
            View customView = tab.getCustomView();
            Log.i(TAG, "customView = " + customView);

            tabLayout.addTab(tab);
        }

        int tabCount = tabLayout.getTabCount();


    }

}