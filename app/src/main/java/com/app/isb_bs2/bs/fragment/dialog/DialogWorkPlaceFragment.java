package com.app.isb_bs2.bs.fragment.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.app.isb_bs2.bs.R;
import com.app.isb_bs2.bs.rxevent.RxBus;

import io.reactivex.Observable;

/**
 * Created by 003418 on 2017/08/15.
 */

public class DialogWorkPlaceFragment extends DialogFragment {

    private String[] listitems = {"自社","客先"};

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setItems(listitems, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                RxBus.getInstance().send(listitems[which]);
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
