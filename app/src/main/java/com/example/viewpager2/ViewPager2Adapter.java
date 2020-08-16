package com.example.viewpager2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPager2Adapter extends FragmentStateAdapter {

    private Fragment[] fragments = {new BlueFragment(), BlueFragment.newInstance(1), BlueFragment.newInstance(2)};
    private int[] titles = {R.string.title_0, R.string.title_1, R.string.title_2};

    public ViewPager2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments[position];
    }

    @Override
    public int getItemCount() {
        return fragments.length;
    }

    public int getTitleId(int position) {
        return titles[position >= titles.length ? 0 : position];
    }
}
