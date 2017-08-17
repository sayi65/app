package com.app.isb_bs2.bs.fragment.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.app.isb_bs2.bs.rxbus.RxBus;
import com.app.isb_bs2.bs.rxevent.OverTimeEvent;

/**
 * Created by 003418 on 2017/08/15.
 */

public class DialogWorkPlaceFragment extends DialogFragment {

    private String[] listitems = {"自社","客先"};

    private int mNum;

    public void setNum(int num){
        mNum = num;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setItems(listitems, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                RxBus.getInstance().send(new OverTimeEvent(mNum, listitems[which]));
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("閉じる", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        Dialog dialog = builder.create();
        return dialog;
    }
}
