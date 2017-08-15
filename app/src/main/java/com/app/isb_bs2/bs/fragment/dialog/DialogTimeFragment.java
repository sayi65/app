package com.app.isb_bs2.bs.fragment.dialog;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.app.isb_bs2.bs.R;
import com.app.isb_bs2.bs.databinding.FragmentOvertimeAddBinding;
import com.app.isb_bs2.bs.databinding.PopupTimepickerBinding;
import com.app.isb_bs2.bs.rxevent.RxBus;

import java.util.Calendar;

import butterknife.BindView;

/**
 * Created by 003418 on 2017/08/15.
 */

public class DialogTimeFragment extends DialogFragment{

    private PopupTimepickerBinding binding;

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
                            hour = String.valueOf(binding.inputTime.getHour());
                            minute = String.valueOf(binding.inputTime.getMinute());
                        } else {
                            hour = String.valueOf(binding.inputTime.getCurrentHour());
                            minute = String.valueOf(binding.inputTime.getCurrentMinute());
                        }

                        RxBus.getInstance().send(hour + ":" + minute);
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

//    @Override
//    public View onCreateView(LayoutInflater i, ViewGroup c, Bundle b)
//    {
//        getDialog().setTitle("My Dialog Title");
//
//        binding = DataBindingUtil.inflate(
//                i, R.layout.popup_timepicker, c, false);
//
//        binding.inputTime.setIs24HourView(true);
//
//        return  binding.getRoot();
//    }

}
