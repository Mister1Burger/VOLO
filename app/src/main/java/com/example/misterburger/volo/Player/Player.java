package com.example.misterburger.volo.Player;

import io.realm.RealmObject;

/**
 * Created by Burge on 14.12.2017.
 */

public class Player extends RealmObject{
    String name;
    int gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }


}
