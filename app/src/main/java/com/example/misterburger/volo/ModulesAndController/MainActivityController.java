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

public interface MainActivityController {
    void init();

    TmpPlayer getTmpPlayer();

    GameSetting getGameSetting();

    DialogFragment getDialogFragment();

    FirstFragment getFirstFragment();

    NewGameFragment getNewGameFragment();

    RealmImpl getRealm();

}
