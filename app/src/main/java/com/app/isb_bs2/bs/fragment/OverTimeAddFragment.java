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
import com.app.isb_bs2.bs.viewmodel.OverTimeViewModel;

/**
 * Created by sayi65 on 2017/08/09.
 */

public class OverTimeAddFragment extends BaseFragment {

    private FragmentOvertimeAddBinding binding;

public OverTimeAddFragment(){

}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_overtime_add, container, false);
        binding.setViewModel(new OverTimeViewModel(new OverTime()));
        binding.setOverTimeHandler(new OverTimeViewHandler());

        return binding.getRoot();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
