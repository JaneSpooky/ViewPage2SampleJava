package com.example.viewpager2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private ViewPager2Adapter viewPager2Adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        initLayout();
    }

    private void initLayout() {
        initViewPager2();
        initTabLayout();
    }

    private void initViewPager2() {
        viewPager2Adapter = new ViewPager2Adapter(this);
        ViewPager2 viewPager2 = findViewById(R.id.viewPager2);
        viewPager2.setAdapter(viewPager2Adapter);
        viewPager2.setOffscreenPageLimit(viewPager2Adapter.getItemCount());
    }

    private void initTabLayout() {
        new TabLayoutMediator((TabLayout) findViewById(R.id.tabLayout), (ViewPager2) findViewById(R.id.viewPager2), new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(viewPager2Adapter.getTitleId(position));
            }
        }).attach();
    }
}
