package com.example.misterburger.volo.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.misterburger.volo.MainActivity;
import com.example.misterburger.volo.R;
import com.example.misterburger.volo.R2;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Burge on 14.12.2017.
 */

public class FirstFragment extends Fragment {
    @BindView(R2.id.continue_btn)
    Button continue_btn;
    @BindView(R2.id.new_game_btn)
    Button new_game_btn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container,false);
        ButterKnife.bind(this,view);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        new_game_btn.setOnClickListener(view1 -> ((MainActivity)getActivity()).getFragment(FlagOfFragment.NEW_GAME_FRAGMENT));
    }
}
