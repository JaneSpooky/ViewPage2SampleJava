package com.example.viewpager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class BlueFragment extends Fragment {

    private static final String KEY_INDEX = "key_index";
    private static final int[] BACKGROUND_COLORS = {android.R.color.holo_blue_bright, android.R.color.holo_blue_light, android.R.color.holo_blue_dark};

    public static Fragment newInstance(int index) {
        BlueFragment fragment = new BlueFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_INDEX, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blue, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int index = getArguments() == null ? 0 : getArguments().getInt(KEY_INDEX, 0);
        view.findViewById(R.id.rootView).setBackgroundColor(ContextCompat.getColor(getActivity(), BACKGROUND_COLORS[index]));
        ((TextView) view.findViewById(R.id.textView)).setText(String.valueOf(index));
    }
}
