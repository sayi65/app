package com.app.isb_bs2.bs;

import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.app.isb_bs2.bs.databinding.ActivityListBinding;
import com.app.isb_bs2.bs.fragment.OverTimeListFragment;

import io.realm.Realm;

public class ListActivity extends AppCompatActivity {

    private static final String STATE_TITLE = "title";

    private ActivityListBinding binding;

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list);

        realm = Realm.getDefaultInstance();

//        realm.beginTransaction();
//        OverTime mWeapons = realm.createObject(OverTime.class); // Create a new object
//        mWeapons.setEmployeeCode("111111");
//        mWeapons.setEmployeeName("aaaaaaa");
//
//
//        OverTime mWeapons1 = realm.createObject(OverTime.class); // Create a new object
//        mWeapons1.setEmployeeCode("2222222");
//        mWeapons1.setEmployeeName("bbbbbbb");
//
//
//        RealmList<OverTime> mWeaponsList = new RealmList<>();
//        mWeaponsList.add(mWeapons);
//        mWeaponsList.add(mWeapons1);
//        realm.commitTransaction();
//        realm.close();

        FragmentManager fragmentManager = getSupportFragmentManager();
        OverTimeListFragment fragment = new OverTimeListFragment();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.content, fragment);
        transaction.commit();
    }
}
