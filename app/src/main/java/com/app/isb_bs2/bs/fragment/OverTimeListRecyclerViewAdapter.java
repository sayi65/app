package com.app.isb_bs2.bs.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.isb_bs2.bs.BR;
import com.app.isb_bs2.bs.R;
import com.app.isb_bs2.bs.databinding.FragmentOvertimeListItemBinding;
import com.app.isb_bs2.bs.realmdata.OverTime;
import com.app.isb_bs2.bs.viewmodel.OverTimeViewModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;

/**
 * Created by sayi65 on 2017/08/06.
 */

public class OverTimeListRecyclerViewAdapter extends RecyclerView.Adapter<OverTimeListRecyclerViewAdapter.ViewHolder> {

    private RealmResults<OverTime> realmResults;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private final FragmentOvertimeListItemBinding binding;

        public ViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public FragmentOvertimeListItemBinding getBinding(){
            return binding;
        }
    }

    public OverTimeListRecyclerViewAdapter(Context context, RealmResults<OverTime> realmResults){
        this.context = context;
        this.realmResults = realmResults;
    }


    @Override
    public OverTimeListRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_overtime_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(OverTimeListRecyclerViewAdapter.ViewHolder holder, int position) {
        OverTime overTime = realmResults.get(position);

        OverTimeViewModel overTimeViewModel = new OverTimeViewModel(overTime);

        FragmentOvertimeListItemBinding itemBinding = holder.getBinding();
        itemBinding.setViewModel(overTimeViewModel);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return realmResults.size();
    }
}
