package com.app.isb_bs2.bs;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.app.isb_bs2.bs.databinding.ActivityMainBinding;
import com.app.isb_bs2.bs.fragment.HomeFragment;
import com.app.isb_bs2.bs.handler.MainHandler;
import com.app.isb_bs2.bs.realmdata.OverTime;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    private static final String STATE_TITLE = "title";

    private ActivityMainBinding binding;
//    private OverTimeViewModel overTimeViewModel;

    protected Realm realm;
    OverTime overTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        realm = Realm.getDefaultInstance();


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //////////////
        realm.beginTransaction();
        overTime = realm.createObject(OverTime.class);
        overTime.setEmployeeCode("003418");
        overTime.setEmployeeName("sai");
        realm.commitTransaction();

        ///////////////
        binding.setHandler(new MainHandler(this));

        HomeFragment fragment = new HomeFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.content, fragment);
        ft.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
//        if (overTime != null) {
//            if (overTime.isValid()) {
//                overTime.removeChangeListeners();
//            }
//        }

    }
}
