package com.example.misterburger.volo.Player;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.misterburger.volo.R;
import java.util.List;

public class AdapterForPlayer extends RecyclerView.Adapter<AdapterForPlayer.UserListViewHolder> {
    List<Player> players;
    PlayerListener listener;


    public static class UserListViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        TextView name_tv;
        TextView number_tv;

        UserListViewHolder(View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.player_ll);
            name_tv = itemView.findViewById(R.id.name_tv);
            number_tv = itemView.findViewById(R.id.number_tv);
        }
    }

    public AdapterForPlayer(List<Player> players, PlayerListener listener) {
        this.players = players;
        this.listener = listener;
    }

    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public UserListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_view, parent, false);
        UserListViewHolder pvh = new UserListViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(UserListViewHolder holder,final int position) {
     holder.name_tv.setText(getPlayers().get(position).getName());
     holder.number_tv.setText(getPlayers().get(position).getNumber());
     holder.linearLayout.setOnClickListener(view -> listener.getPlayerFromListener(getPlayers().get(position)));
    }

    public void addPlayer(Player player){
        getPlayers().add(player);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}


