package com.app.isb_bs2.bs.handler;

import android.app.Dialog;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.app.isb_bs2.bs.R;
import com.app.isb_bs2.bs.fragment.dialog.DialogTimeFragment;
import com.app.isb_bs2.bs.fragment.dialog.DialogWorkPlaceFragment;
import com.app.isb_bs2.bs.realmdata.OverTime;
import com.app.isb_bs2.bs.rxbus.RxBus;
import com.app.isb_bs2.bs.rxevent.OverTimeEvent;
import com.app.isb_bs2.bs.viewmodel.OverTimeViewModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;

/**
 * Created by sayi65 on 2017/08/09.
 */

public class OverTimeAddViewHandler {

    private View mRootView;
    public Realm realm;
    private OverTime overTime;
    private FragmentManager manager;
    public Disposable mDisposable;

    private final Integer PLACE_ID = 100;
    private final Integer COME_ID = 200;
    private final Integer LEAVE_ID = 300;

    public OverTimeAddViewHandler(FragmentManager manager){
        this.manager = manager;
    }

    public void onSaveData(View view,OverTimeViewModel overTimeViewModel){
        mRootView = view.getRootView();
        ToggleButton toggleBtn = (ToggleButton)mRootView.findViewById(R.id.btnToggle);
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        overTime = realm.createObject(OverTime.class);
        if(!toggleBtn.isChecked()){
            overTime.setOverTime(false);
        } else {
            overTime.setEmployeeCode(overTimeViewModel.getEmployeeCode());
            overTime.setEmployeeName(overTimeViewModel.getEmployeeName());
            overTime.setEmployeeAffiliation(overTimeViewModel.getEmployeeAffiliation());
            overTime.setProjectCode(overTimeViewModel.getProjectCode());
            overTime.setProjectName(overTimeViewModel.getProjectName());
            overTime.setReason(overTimeViewModel.getReason());
            overTime.setReasonDetail(overTimeViewModel.getReasonDetail());
            overTime.setOverTimePlace(overTimeViewModel.getOverTimePlace());
            overTime.setStartTime(overTimeViewModel.getStartTime());
            overTime.setEndTime(overTimeViewModel.getEndTime());
            overTime.setOverTime(true);
        }
        realm.commitTransaction();

    }

    public void displayReasonText(View view){
        mRootView = view.getRootView();
        View reasonTxt  = mRootView.findViewById(R.id.txt_reason);
        if(((ToggleButton)view).isChecked()){
            reasonTxt.setVisibility(View.VISIBLE);
        } else {
            reasonTxt.setVisibility(View.GONE);
        }
    }

    public void placePopup(View view){
        DialogWorkPlaceFragment dialog = new DialogWorkPlaceFragment();
        dialog.setNum(PLACE_ID);
        dialog.show(this.manager, "title");

        mRootView = view.getRootView();
        TextView placeTxt  = (TextView) mRootView.findViewById(R.id.input_place);

        mDisposable = RxBus.getInstance().toObservable(OverTimeEvent.class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<OverTimeEvent>(){
                    @Override
                    public void accept(OverTimeEvent overTimeEvent) throws Exception {
                        if(overTimeEvent.getCode() == PLACE_ID){
                            placeTxt.setText(overTimeEvent.getMsg());
                        }
                    }
                });
    }


    public void comeTimePopup(View view){
        mRootView = view.getRootView();
        TextView comeTxt  = (TextView) mRootView.findViewById(R.id.input_come);

        DialogTimeFragment timeFragment = new DialogTimeFragment();
        timeFragment.setNum(COME_ID);
        timeFragment.show(this.manager, "comeTimePicker");


        mDisposable = RxBus.getInstance().toObservable(OverTimeEvent.class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<OverTimeEvent>(){
                    @Override
                    public void accept(OverTimeEvent overTimeEvent) throws Exception {
                        Log.d("100", String.valueOf(overTimeEvent.getCode()));
                        if(overTimeEvent.getCode() == COME_ID){
                            comeTxt.setText(overTimeEvent.getMsg());
                        }
                    }
                });
    }

    public void leaveTimePopup(View view){
        mRootView = view.getRootView();
        TextView leaveTxt  = (TextView) mRootView.findViewById(R.id.input_leave);

        DialogTimeFragment timeFragment = new DialogTimeFragment();
        timeFragment.setNum(LEAVE_ID);
        timeFragment.show(this.manager, "leaveTimePicker");

        mDisposable = RxBus.getInstance().toObservable(OverTimeEvent.class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<OverTimeEvent>(){
                    @Override
                    public void accept(OverTimeEvent overTimeEvent) throws Exception {
                        if(overTimeEvent.getCode() == LEAVE_ID){
                            leaveTxt.setText(overTimeEvent.getMsg());
                        }
                    }
                });

    }

}
