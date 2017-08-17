package com.app.isb_bs2.bs.fragment;

import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.isb_bs2.bs.R;
import com.app.isb_bs2.bs.databinding.FragmentOverTimeBinding;
import com.app.isb_bs2.bs.realmdata.OverTime;
import com.app.isb_bs2.bs.viewmodel.OverTimeViewModel;

import io.realm.Realm;
import io.realm.RealmResults;

public class OverTimeFragment extends BaseFragment {

    private FragmentOverTimeBinding binding;
    protected Realm realm;
    private OverTimeViewModel overTimeViewModel;

    public OverTimeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_over_time, container, false);

        realm = Realm.getDefaultInstance();

        RealmResults<OverTime> overTime =realm.where(OverTime.class).findAll();

        overTimeViewModel = new OverTimeViewModel(realm.where(OverTime.class).findFirst());

        binding.setViewModel(overTimeViewModel);


        return binding.getRoot();
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }
}
