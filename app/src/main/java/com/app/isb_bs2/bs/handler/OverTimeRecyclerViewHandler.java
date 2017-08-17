package com.app.isb_bs2.bs.handler;

import android.util.Log;
import android.view.View;

import com.app.isb_bs2.bs.databinding.FragmentOvertimeListItemBinding;
import com.app.isb_bs2.bs.fragment.OverTimeListRecyclerViewAdapter;
import com.app.isb_bs2.bs.realmdata.OverTime;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by 003418 on 2017/08/17.
 */

public class OverTimeRecyclerViewHandler {

    private RealmResults<OverTime> realmResults;
    public Realm realm;
    private FragmentOvertimeListItemBinding binding;
    private View mRootView;

    public void onDeleteData(View v){
        mRootView = v.getRootView();
        realmResults = (RealmResults<OverTime>)mRootView.getTag();
        int position = (int)v.getTag();
        Log.d("position", String.valueOf(position));
//        realm = Realm.getDefaultInstance();
//        realm.beginTransaction();
//        OverTime overTime = realmResults.get(position);
//        overTime.deleteFromRealm();
//        realm.commitTransaction();

    }
}
