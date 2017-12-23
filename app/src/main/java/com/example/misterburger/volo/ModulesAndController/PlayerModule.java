package com.example.misterburger.volo.ModulesAndController;

import com.example.misterburger.volo.Player.Player;

import java.util.List;

/**
 * Created by Burge on 15.12.2017.
 */

public interface PlayerModule {
    List<Player> getPlayers();

    void removePlayer(Player player);

    void addPlayer(Player player);
}
