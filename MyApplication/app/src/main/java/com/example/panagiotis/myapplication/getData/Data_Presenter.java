package com.example.panagiotis.myapplication.getData;

import com.example.panagiotis.myapplication.database.AdvertInfo;

import io.realm.Realm;
import io.realm.RealmResults;


public class Data_Presenter implements IContract_GetData.IPresenter_GetData {
    @Override
    public void start() {
        iView_getData.setPresenter(this);
    }


    IContract_GetData.IView_GetData iView_getData;
    private Realm realm;

    public Data_Presenter(IContract_GetData.IView_GetData iView_getData) {
        this.iView_getData = iView_getData;
    }

    @Override
    public void getDataFromDatabase() {
        realm = Realm.getDefaultInstance();
        RealmResults<AdvertInfo> results = realm.where(AdvertInfo.class).findAll();
        iView_getData.displayData(results);
    }

    @Override
    public void addDatatoDatabase() {
        realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                AdvertInfo advertInfo = realm.createObject(AdvertInfo.class);
                advertInfo.setTitle("Title");
                advertInfo.setAddress("Random address");
                advertInfo.setAdCount(2);
                advertInfo.setDate("30/02/2000");
                advertInfo.setDescription("Description of the Product");
                advertInfo.setPrice("$1.000.000");
            }
        });
    }

    @Override
    public void clearDatabase() {
        realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.delete(AdvertInfo.class);
            }
        });
    }
}
