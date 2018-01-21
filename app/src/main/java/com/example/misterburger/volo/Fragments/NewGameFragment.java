package com.example.misterburger.volo.Fragments;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import com.example.misterburger.volo.MainActivity;
import com.example.misterburger.volo.ModulesAndController.MainActivityController;
import com.example.misterburger.volo.Player.AdapterForPlayer;
import com.example.misterburger.volo.Player.Player;
import com.example.misterburger.volo.R;
import com.example.misterburger.volo.R2;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Burge on 14.12.2017.
 */

public class NewGameFragment extends Fragment {
    @BindView(R2.id.players_list)
    RecyclerView players_list;
    @BindView(R2.id.add_player_btn)
    Button add_player;
    @BindView(R2.id.digits_spinner)
    Spinner digits_spinner;
    @BindView(R2.id.type_volo_spinner)
    Spinner volo_spinner;
    @BindView(R2.id.start_btn)
    Button start;
    MainActivityController mainActivityController;
    List<Player> players;
    AdapterForPlayer adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_game_fragment, container,false);
        ButterKnife.bind(this,view);
        mainActivityController = ((MainActivity)getActivity()).getMainActivityController();
        return  view;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        players_list.setLayoutManager(llm);
                add_player.setOnClickListener(view1 -> ((MainActivity)getActivity()).getFragment(FlagOfFragment.ADD_PLAYER_DIALOG));
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onStart() {
        super.onStart();
        players = mainActivityController.getRealm().readPlayers(getContext());
        adapter = new AdapterForPlayer(players,player -> {mainActivityController.getTmpPlayer().setPlayer(player); ((MainActivity)getActivity()).getFragment(FlagOfFragment.ADD_PLAYER_DIALOG);});
    }
}
