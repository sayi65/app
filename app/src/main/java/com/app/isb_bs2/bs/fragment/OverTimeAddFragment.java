package com.app.isb_bs2.bs.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.isb_bs2.bs.R;
import com.app.isb_bs2.bs.databinding.FragmentOvertimeAddBinding;
import com.app.isb_bs2.bs.handler.OverTimeViewHandler;
import com.app.isb_bs2.bs.realmdata.OverTime;
import com.app.isb_bs2.bs.rxevent.RxBus;
import com.app.isb_bs2.bs.viewmodel.OverTimeViewModel;

import io.reactivex.internal.subscriptions.ArrayCompositeSubscription;

/**
 * Created by sayi65 on 2017/08/09.
 */

public class OverTimeAddFragment extends BaseFragment {

    private FragmentOvertimeAddBinding binding;
    private OverTimeViewHandler overTimeViewHandler;

    public OverTimeAddFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_overtime_add, container, false);
        binding.setViewModel(new OverTimeViewModel(new OverTime()));
        binding.setOverTimeHandler(new OverTimeViewHandler(getFragmentManager()));

        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (binding.getOverTimeHandler().mDisposable != null) {
            binding.getOverTimeHandler().mDisposable.dispose();
        }
    }
}
