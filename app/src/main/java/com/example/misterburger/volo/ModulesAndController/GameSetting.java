package com.example.misterburger.volo.ModulesAndController;

import io.realm.RealmObject;

/**
 * Created by 40505 on 25.12.2017.
 */

public class GameSetting extends RealmObject {
    int digits;
    int typeOfVolo;

    public int getDigits() {
        return digits;
    }

    public void setDigits(int digits) {
        this.digits = digits;
    }

    public int getTypeOfVolo() {
        return typeOfVolo;
    }

    public void setTypeOfVolo(int typeOfVolo) {
        this.typeOfVolo = typeOfVolo;
    }
}
