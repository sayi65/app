package com.app.isb_bs2.bs;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.app.isb_bs2.bs.databinding.ActivityMainBinding;
import com.app.isb_bs2.bs.fragment.HomeFragment;
import com.app.isb_bs2.bs.handler.MainHandler;
import com.app.isb_bs2.bs.realmdata.OverTime;

import io.realm.Realm;
import io.realm.SyncConfiguration;
import io.realm.SyncUser;

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

        Toolbar toolbar = binding.toolbar;
        toolbar.setTitle("test");

        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        View imageButton = toolbar.findViewById(R.id.add_button);
        imageButton.setVisibility(View.GONE);

        binding.setHandler(new MainHandler(this));


        HomeFragment fragment = new HomeFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.content, fragment);
        ft.commit();
    }

    @Override
    protected void onDestroy() {
        if (realm != null && !realm.isClosed()) {
            realm.close();
        }
        super.onDestroy();
    }
}
