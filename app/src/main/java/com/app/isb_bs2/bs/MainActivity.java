package com.app.isb_bs2.bs;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.app.isb_bs2.bs.databinding.ActivityMainBinding;
import com.app.isb_bs2.bs.fragment.DashBoardFragment;
import com.app.isb_bs2.bs.fragment.HomeFragment;
import com.app.isb_bs2.bs.handler.MainHandler;
import com.app.isb_bs2.bs.handler.OverTimeHandler;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    private static final String STATE_TITLE = "title";

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Realm.init(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setHandler(new MainHandler(this));

        HomeFragment fragment = new HomeFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.content, fragment);
        ft.commit();



    }

}
