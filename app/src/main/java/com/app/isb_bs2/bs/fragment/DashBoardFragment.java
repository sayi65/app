package com.app.isb_bs2.bs.fragment;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.app.isb_bs2.bs.R;
import com.app.isb_bs2.bs.databinding.FragmentDashBoardBinding;
import com.app.isb_bs2.bs.realmdata.OverTime;
import com.app.isb_bs2.bs.realmdata.Schedule;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class DashBoardFragment extends BaseFragment {

    private FragmentDashBoardBinding binding;
    private DashBoardListViewAdapter adapter;
    private Realm realm;
    private Schedule schedule;

    public DashBoardFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("予定");

        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_dash_board, container, false);


        try {
            realm = realm.getDefaultInstance();
            realm.beginTransaction();
            schedule = realm.createObject(Schedule.class);
            schedule.setEmployeeCode("11111111111");
            schedule.setEmployeeName("テスト");
            schedule.setCreated(new Date());
            realm.commitTransaction();
        }finally {
            realm.close();
        }
        RealmResults<Schedule> schedules =realm.where(Schedule.class).findAllSorted("created", Sort.DESCENDING);

        adapter = new DashBoardListViewAdapter(getContext());

        adapter.setScheduleList(schedules);
        binding.scheduleView.setAdapter(adapter);

        return binding.getRoot();
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }
}
