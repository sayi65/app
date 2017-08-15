package com.app.isb_bs2.bs.handler;

import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.app.isb_bs2.bs.MainActivity;
import com.app.isb_bs2.bs.R;
import com.app.isb_bs2.bs.fragment.dialog.DialogTimeFragment;
import com.app.isb_bs2.bs.fragment.dialog.DialogWorkPlaceFragment;
import com.app.isb_bs2.bs.realmdata.OverTime;
import com.app.isb_bs2.bs.rxevent.RxBus;
import com.app.isb_bs2.bs.viewmodel.OverTimeViewModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;

/**
 * Created by sayi65 on 2017/08/09.
 */

public class OverTimeViewHandler {

    private View mRootView;
    private Realm realm;
    private OverTime overTime;
    private FragmentManager manager;
    public Disposable mDisposable;

    public OverTimeViewHandler(FragmentManager manager){
        this.manager = manager;
    }

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
        dialog.show(this.manager, "title");

        mRootView = view.getRootView();
        TextView place  = (TextView) mRootView.findViewById(R.id.input_place);

        mDisposable = RxBus.getInstance().toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>(){
                    @Override
                    public void accept(Object object) throws Exception {
                        String msg = object.toString();
                        place.setText(msg);
                    }
                });
    }

    public void comeTimePopup(View view){
        mRootView = view.getRootView();
        TextView comeTxt  = (TextView) mRootView.findViewById(R.id.input_come);

        DialogTimeFragment timeFragment = new DialogTimeFragment();
        timeFragment.show(this.manager, "comeTimePicker");

        mDisposable = RxBus.getInstance().toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>(){
                    @Override
                    public void accept(Object object) throws Exception {
                        String msg = object.toString();
                        comeTxt.setText(msg);
                    }
                });

    }

    public void leaveTimePopup(View view){
        mRootView = view.getRootView();
        TextView leaveTxt  = (TextView) mRootView.findViewById(R.id.input_leave);

        DialogTimeFragment timeFragment = new DialogTimeFragment();
        timeFragment.show(this.manager, "leaveTimePicker");

        mDisposable = RxBus.getInstance().toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>(){
                    @Override
                    public void accept(Object object) throws Exception {
                        String msg = object.toString();
                        leaveTxt.setText(msg);
                    }
                });

    }

}
