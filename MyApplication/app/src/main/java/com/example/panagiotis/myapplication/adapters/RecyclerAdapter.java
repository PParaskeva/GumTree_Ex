package com.example.panagiotis.myapplication.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.panagiotis.myapplication.database.AdvertInfo;

import butterknife.ButterKnife;
import io.realm.RealmResults;

/**
 * Created by Panagiotis on 12/02/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private int row;
    RealmResults<AdvertInfo> results;

    public RecyclerAdapter(int row, RealmResults<AdvertInfo> results) {
        this.row = row;
        this.results = results;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(row,parent,false);
        return new RecyclerAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        //holder.items.setText(results.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
//        @BindView(R.id.items) TextView items;
//        imageView2
//                textView3;
//        textView4
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
