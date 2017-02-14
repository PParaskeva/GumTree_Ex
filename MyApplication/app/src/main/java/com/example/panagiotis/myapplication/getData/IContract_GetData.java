package com.example.panagiotis.myapplication.getData;

import com.example.panagiotis.myapplication.MVP.BasedPresenter;
import com.example.panagiotis.myapplication.MVP.BasedView;
import com.example.panagiotis.myapplication.database.AdvertInfo;

import io.realm.RealmResults;


public interface IContract_GetData {
    public interface IPresenter_GetData extends BasedPresenter {
        public void getDataFromDatabase();
        public void addDatatoDatabase();
        public void clearDatabase();
    }

    public interface IView_GetData extends BasedView<IPresenter_GetData> {

//        public void displayEventsNextToMe(Example_songkick example_songkick);
//        public void displayArtistCalendar(Example_ArtistCalendar example_artistCalendar);
        public void displayData(RealmResults<AdvertInfo> results);
        public void showProgressDialog();
        public void dismissProgressDialog();
    }
}
