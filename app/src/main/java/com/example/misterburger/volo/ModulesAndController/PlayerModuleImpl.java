package com.example.misterburger.volo.ModulesAndController;

import android.content.Context;

import com.example.misterburger.volo.ModulesAndController.RealmModule.Realm;
import com.example.misterburger.volo.Player.Player;

import java.util.List;

/**
 * Created by Burge on 15.12.2017.
 */

public class PlayerModuleImpl implements PlayerModule {
    Realm realm;
    Context context;


    public PlayerModuleImpl(Realm realm, Context context) {
        this.realm = realm;
        this.context = context;
    }

    @Override
    public List<Player> getPlayers(){
        return realm.readPlayers(context);
    }

    @Override
    public void removePlayer(Player player){
        realm.removePlayer(context, player.getName());
    }
    @Override
    public void addPlayer(Player player) {
        realm.savePlayer(context,player);
    }
}

