package com.jrsm.android.realmexample;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by joseroberto on 02/08/16.
 */
public class Usuario extends RealmObject {

    private String name;
    private String password;
    @PrimaryKey
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
