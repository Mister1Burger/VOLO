package com.example.misterburger.volo.ModulesAndController.RealmModule;

import android.content.Context;

import com.example.misterburger.volo.ModulesAndController.GameSetting;
import com.example.misterburger.volo.Player.Player;

import java.util.List;

/**
 * Created by java on 13.11.2017.
 */

public interface Realm {
    io.realm.Realm init(Context context);

    List<Player> readPlayers(Context context);

    void savePlayer(Context context, Player player);

    void removePlayer(Context context, String name);

    void onDestroy(Context context);

    void removeSetting(Context context);

    void saveSetting(Context context, GameSetting setting);
}

