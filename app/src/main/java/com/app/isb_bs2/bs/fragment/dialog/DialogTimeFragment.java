package com.app.isb_bs2.bs.fragment.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;

import com.app.isb_bs2.bs.R;
import com.app.isb_bs2.bs.databinding.PopupTimepickerBinding;
import com.app.isb_bs2.bs.rxbus.RxBus;
import com.app.isb_bs2.bs.rxevent.OverTimeEvent;
import io.reactivex.disposables.Disposable;

/**
 * Created by 003418 on 2017/08/15.
 */

public class DialogTimeFragment extends DialogFragment{

    private PopupTimepickerBinding binding;

    private int mNum;

    public void setNum(int num){
        mNum = num;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        FragmentActivity activity = getActivity();

        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()),
                R.layout.popup_timepicker, null, false);

        binding.inputTime.setIs24HourView(true);

        return new AlertDialog.Builder(activity)
                .setView(binding.getRoot())
                .setPositiveButton("保存", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String hour;
                        String minute;
                        if (Build.VERSION.SDK_INT >= 23 ){
                            hour = String.format("%02d",binding.inputTime.getHour());
                            minute = String.format("%02d",binding.inputTime.getMinute());
                        } else {
                            hour = String.format("%02d",binding.inputTime.getCurrentHour());
                            minute = String.format("%02d",binding.inputTime.getCurrentMinute());
                        }

                        RxBus.getInstance().send(new OverTimeEvent(mNum, hour + ":" + minute));
                    }
                })
                .setNegativeButton("キャンセル", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
