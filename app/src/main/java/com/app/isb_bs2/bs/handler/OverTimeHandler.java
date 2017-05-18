package com.app.isb_bs2.bs.handler;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.app.isb_bs2.bs.ListActivity;
import com.app.isb_bs2.bs.MainActivity;
import com.app.isb_bs2.bs.R;
import com.app.isb_bs2.bs.fragment.OverTimeListFragment;

/**
 * Created by sayi65 on 2017/04/16.
 */

public class OverTimeHandler {

    private FragmentActivity mActivity;

    public OverTimeHandler(FragmentActivity mActivity){
        this.mActivity = mActivity;
    }


    public void onClicktoList(View view){
        Intent intent = new Intent(mActivity, ListActivity.class);
        mActivity.startActivity(intent);

    }
}
