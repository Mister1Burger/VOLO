package com.example.misterburger.volo.Player;

import io.realm.RealmObject;

/**
 * Created by Burge on 14.12.2017.
 */

public class Player extends RealmObject{
    String name;
    int gender;
    int number;

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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
