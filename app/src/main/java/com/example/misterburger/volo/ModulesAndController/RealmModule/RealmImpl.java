package com.example.misterburger.volo.ModulesAndController.RealmModule;

import android.content.Context;
import android.util.Log;

import com.example.misterburger.volo.Player.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import io.realm.exceptions.RealmMigrationNeededException;

public class RealmImpl implements Realm {

    public RealmImpl() {
    }

    @Override
    public io.realm.Realm init(Context context) {
        io.realm.Realm.init(context);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name( "reminder.realm")
                .modules(new MyLibraryModule())
                .build();

        try {
            return io.realm.Realm.getInstance(realmConfiguration);
        } catch (RealmMigrationNeededException e) {
            try {
                Log.e( "TAG", String.valueOf(e));
                io.realm.Realm.deleteRealm(realmConfiguration);
                //Realm file has been deleted.
                return io.realm.Realm.getInstance(realmConfiguration);
            } catch (Exception ex) {
                //No Realm file to remove.
                Log.e( "TAG", String.valueOf(ex));
            }
        }

        return null;
    }

    @Override
    public List<Player> readPlayers(Context context) {
        io.realm.Realm realm = init(context);
        File realmFile = new File(context.getFilesDir(), "reminder.realm");
        try {
            assert realm != null;
            RealmResults<Player> list = realm.where(Player.class).findAll();
            Log.d( "TAG", String.valueOf(realmFile.length()));
            if (list == null)
                return new ArrayList<>();
            return list;
        } catch (NullPointerException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void savePlayer(Context context, Player player) {

        io.realm.Realm realm = init(context);
        File realmFile = new File(context.getFilesDir(), "reminder.realm");
        assert realm != null;
        try {
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(player);
            Log.d( "TAG", String.valueOf(realmFile.length()));
            realm.commitTransaction();
        } catch (NullPointerException ignore) {
        }
    }

    @Override
    public void removePlayer(Context context,String name) {
        io.realm.Realm realm = init(context);
        File realmFile = new File(context.getFilesDir(), "reminder.realm");
        assert realm != null;
        try {
           Player player = realm.where(Player.class)
                    .equalTo("name", name).findFirst();
            if(player!=null) {
                realm.beginTransaction();
                player.deleteFromRealm();
                realm.commitTransaction();
            }
            Log.d( "TAG", String.valueOf(realmFile.length()));
        } catch (NullPointerException ignore) {
        }
    }

    @Override
    public void onDestroy(Context context) {
        io.realm.Realm realm = init(context);
        assert realm != null;
        realm.close();
    }


}
