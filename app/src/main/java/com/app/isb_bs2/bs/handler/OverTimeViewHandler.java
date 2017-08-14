package com.app.isb_bs2.bs.handler;

import android.databinding.BindingMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import com.app.isb_bs2.bs.MainActivity;
import com.app.isb_bs2.bs.R;
import com.app.isb_bs2.bs.realmdata.OverTime;
import com.app.isb_bs2.bs.viewmodel.OverTimeViewModel;

import io.realm.Realm;

/**
 * Created by sayi65 on 2017/08/09.
 */

public class OverTimeViewHandler {

    private MainActivity mActivity;
    private Realm realm;
    private OverTime overTime;

    public void onSaveData(OverTimeViewModel overTimeViewModel){
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        overTime = realm.createObject(OverTime.class);
        overTime.setEmployeeCode(overTimeViewModel.getEmployeeCode());
        overTime.setEmployeeName(overTimeViewModel.getEmployeeName());
        overTime.setOverTime(true);
        overTime.setReason(overTimeViewModel.getReason());
        realm.commitTransaction();
    }

    public void displayReasonText(View view){
        View rootView = view.getRootView();
        View reasonTxt  = rootView.findViewById(R.id.txt_reason);
        if(((ToggleButton)view).isChecked()){
            reasonTxt.setVisibility(View.VISIBLE);
        } else {
            reasonTxt.setVisibility(View.GONE);
        }
    }

}
