package com.app.isb_bs2.bs.handler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.app.isb_bs2.bs.ListActivity;
import com.app.isb_bs2.bs.MainActivity;
import com.app.isb_bs2.bs.R;
import com.app.isb_bs2.bs.fragment.DashBoardFragment;
import com.app.isb_bs2.bs.fragment.HomeFragment;
import com.app.isb_bs2.bs.fragment.OverTimeFragment;

import static android.app.PendingIntent.getActivity;

/**
 * Created by sayi65 on 2017/04/15.
 */

public class MainHandler {

    private MainActivity mActivity;

    public MainHandler(MainActivity mActivity){
        this.mActivity = mActivity;
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_home:

                fragment = new HomeFragment();
                break;
            case R.id.navigation_dashboard:
                fragment = new DashBoardFragment();
                break;
            case R.id.navigation_notifications:
                fragment = new OverTimeFragment();
                break;
        }

        if (fragment != null) {
            FragmentTransaction ft = mActivity.getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content, fragment);
            ft.commit();
        }

        return true;
    }

}


