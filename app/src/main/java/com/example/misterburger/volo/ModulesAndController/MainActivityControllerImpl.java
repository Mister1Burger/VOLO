package com.example.misterburger.volo.ModulesAndController;

import android.content.Context;

import com.example.misterburger.volo.Fragments.DialogFragment;
import com.example.misterburger.volo.Fragments.FirstFragment;
import com.example.misterburger.volo.Fragments.NewGameFragment;
import com.example.misterburger.volo.ModulesAndController.RealmModule.RealmImpl;
import com.example.misterburger.volo.Player.TmpPlayer;

/**
 * Created by Burge on 15.12.2017.
 */

public class MainActivityControllerImpl implements MainActivityController {
    private DialogFragment dialogFragment;
    private FirstFragment firstFragment;
    private NewGameFragment newGameFragment;
    private RealmImpl realm;
    private GameSetting gameSetting;
    private TmpPlayer tmpPlayer;



    @Override
    public void init(){
        dialogFragment = new DialogFragment();
        firstFragment = new FirstFragment();
        newGameFragment = new NewGameFragment();
        realm = new RealmImpl();
        gameSetting = new GameSetting();
        tmpPlayer = new TmpPlayer();


    }

    @Override
    public TmpPlayer getTmpPlayer() {
        return tmpPlayer;
    }

    @Override
    public GameSetting getGameSetting() {
        return gameSetting;
    }

    @Override
    public DialogFragment getDialogFragment() {
        return dialogFragment;
    }

    @Override
    public FirstFragment getFirstFragment() {
        return firstFragment;
    }

    @Override
    public NewGameFragment getNewGameFragment() {
        return newGameFragment;
    }

    @Override
    public RealmImpl getRealm() {
        return realm;
    }
}


