package com.app.isb_bs2.bs.handler;

import android.util.Log;
import android.view.View;

import com.app.isb_bs2.bs.databinding.FragmentOvertimeListItemBinding;
import com.app.isb_bs2.bs.fragment.OverTimeListRecyclerViewAdapter;
import com.app.isb_bs2.bs.realmdata.OverTime;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by 003418 on 2017/08/17.
 */

public class OverTimeRecyclerViewHandler {

    public Realm realm;
    private View mRootView;
    private OverTimeListRecyclerViewAdapter mAdapter;

    public void onDeleteData(View v){
        mRootView = v.getRootView();
        realm = realm.getDefaultInstance();
        RealmResults<OverTime> resultOverTime =realm.where(OverTime.class).findAllSorted("created", Sort.DESCENDING);;
        int position = (int)v.getTag();

        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        resultOverTime.deleteFromRealm(position);
        realm.commitTransaction();
    }
}
