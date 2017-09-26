package com.app.isb_bs2.bs.fragment;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.app.isb_bs2.bs.R;
import com.app.isb_bs2.bs.realmdata.Schedule;

import java.util.ArrayList;

import io.realm.RealmResults;

/**
 * Created by 003418 on 2017/09/25.
 */

public class DashBoardListViewAdapter extends BaseAdapter {

    private Context context;
    private RealmResults<Schedule> scheduleRealmResults;
    private LayoutInflater layoutInflater = null;

    public DashBoardListViewAdapter(Context context){
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setScheduleList(RealmResults<Schedule> scheduleList){
        this.scheduleRealmResults = scheduleList;
    }

    @Override
    public int getCount() {
        return this.scheduleRealmResults.size();
    }

    @Override
    public Object getItem(int position) {
        return this.scheduleRealmResults.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(this.context).inflate(R.layout.fragment_dash_board_list_item,parent,false);
//            convertView = this.layoutInflater.inflate(R.layout.fragment_dash_board_list_item,parent,false);
        }


        ((TextView)convertView.findViewById(R.id.code)).setText(this.scheduleRealmResults.get(position).getEmployeeCode());
        ((TextView)convertView.findViewById(R.id.name)).setText(this.scheduleRealmResults.get(position).getEmployeeName());
        return convertView;
    }
}
