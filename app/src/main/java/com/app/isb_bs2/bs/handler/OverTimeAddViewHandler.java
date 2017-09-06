package com.app.isb_bs2.bs.handler;

import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.app.isb_bs2.bs.R;
import com.app.isb_bs2.bs.fragment.OverTimeListFragment;
import com.app.isb_bs2.bs.fragment.dialog.DialogTimeFragment;
import com.app.isb_bs2.bs.fragment.dialog.DialogWorkPlaceFragment;
import com.app.isb_bs2.bs.realmdata.OverTime;
import com.app.isb_bs2.bs.rxbus.RxBus;
import com.app.isb_bs2.bs.rxevent.OverTimeEvent;
import com.app.isb_bs2.bs.viewmodel.OverTimeViewModel;

import java.util.Calendar;
import java.util.Date;

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
    private Date mDate;
    private Calendar mCalendar;

    private final Integer PLACE_ID = 100;
    private final Integer COME_ID = 200;
    private final Integer LEAVE_ID = 300;

    public OverTimeAddViewHandler(FragmentManager manager){
        this.manager = manager;
    }

    public void checkedData(View view){
    }

    public void onSaveData(View view,OverTimeViewModel overTimeViewModel){
        mRootView = view.getRootView();
        ToggleButton toggleBtn = (ToggleButton)mRootView.findViewById(R.id.btnToggle);

        CheckBox fridayBox = (CheckBox)mRootView.findViewById(R.id.checkbox_friday);
        CheckBox saturdayBox = (CheckBox)mRootView.findViewById(R.id.checkbox_saturday);
        CheckBox sundayBox = (CheckBox)mRootView.findViewById(R.id.checkbox_sunday);

        mDate = new Date();
        mCalendar = Calendar.getInstance();
        mCalendar.setTime(mDate);

        // 水曜日の場合
        if (mCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
                if (!toggleBtn.isChecked()) {
                    saveToData(overTimeViewModel, mDate, false);
                } else {
                    saveToData(overTimeViewModel, mDate, true);
            }
        }

        //　金曜日の場合
        if (mCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
            if (fridayBox.isChecked()) {
                saveToData(overTimeViewModel, mDate, true);
            } else {
                saveToData(overTimeViewModel, mDate, false);
            }
            mCalendar.add(Calendar.DATE, 1);
            if (saturdayBox.isChecked()) {

                saveToData(overTimeViewModel, mCalendar.getTime(), true);
            } else {
                saveToData(overTimeViewModel, mCalendar.getTime(), false);
            }
            mCalendar.add(Calendar.DATE, 1);
            if (sundayBox.isChecked()) {

                saveToData(overTimeViewModel, mCalendar.getTime(), true);
            }else {
                saveToData(overTimeViewModel, mCalendar.getTime(), false);
            }
        }

        Fragment mFragment = new OverTimeListFragment();
        manager.beginTransaction().replace(R.id.content, mFragment).commit();

    }

    private void saveToData(OverTimeViewModel overTimeViewModel, Date createdDate, boolean isChecked){
        realm = Realm.getDefaultInstance();
        try{
            realm.beginTransaction();
            overTime = realm.createObject(OverTime.class);
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
            overTime.setOverTime(isChecked);
            overTime.setCreated(createdDate);
            realm.commitTransaction();
        } finally {
            realm.close();
        }

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
