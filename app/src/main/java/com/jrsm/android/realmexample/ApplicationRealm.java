package com.jrsm.android.realmexample;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by joseroberto on 02/08/16.
 */
public class ApplicationRealm extends android.app.Application{
    @Override
    public void onCreate() {

        super.onCreate();
        RealmConfiguration config = new RealmConfiguration.Builder(this)
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(config);
    }
}
