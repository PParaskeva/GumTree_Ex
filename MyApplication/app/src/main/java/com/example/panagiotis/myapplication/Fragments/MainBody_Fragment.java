package com.example.panagiotis.myapplication.Fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.panagiotis.myapplication.R;
import com.example.panagiotis.myapplication.adapters.RecyclerAdapter;
import com.example.panagiotis.myapplication.database.AdvertInfo;
import com.example.panagiotis.myapplication.getData.IContract_GetData;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;

import static com.google.common.base.Preconditions.checkNotNull;

public class MainBody_Fragment extends Fragment implements
        IContract_GetData.IView_GetData {

    private IContract_GetData.IPresenter_GetData iPresenter_getData;
    private ProgressDialog pDialog;
    @BindView(R.id.Main_RecycleView) RecyclerView MainrecyclerView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_main_body_, container, false);
        ButterKnife.bind(this,v);
        iPresenter_getData.clearDatabase();
        iPresenter_getData.getDataFromDatabase();
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        iPresenter_getData.start();
    }

    @Override
    public void displayData(RealmResults<AdvertInfo> results) {
        MainrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        MainrecyclerView.setItemAnimator(new DefaultItemAnimator());
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(R.layout.main_recycleview_row,results);
        MainrecyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public void showProgressDialog() {
        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.show();
    }

    @Override
    public void dismissProgressDialog() {
        if(pDialog.isShowing() || pDialog!=null){
            pDialog.dismiss();
        }
    }

    @Override
    public void setPresenter(IContract_GetData.IPresenter_GetData presenter) {
        this.iPresenter_getData=checkNotNull(presenter);
    }
}
