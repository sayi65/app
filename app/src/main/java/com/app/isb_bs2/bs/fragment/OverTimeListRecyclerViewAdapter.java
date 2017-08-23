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
import com.app.isb_bs2.bs.handler.OverTimeRecyclerViewHandler;
import com.app.isb_bs2.bs.realmdata.OverTime;
import com.app.isb_bs2.bs.viewmodel.OverTimeViewModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

/**
 * Created by sayi65 on 2017/08/06.
 */

public class OverTimeListRecyclerViewAdapter extends RecyclerView.Adapter<OverTimeListRecyclerViewAdapter.ViewHolder>  {


    private RealmResults<OverTime> realmResults;
    private Context context;
    private FragmentOvertimeListItemBinding binding;
    private OverTimeRecyclerViewHandler overTimeRecyclerViewHandler;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_LIST = 1;

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
        Calendar today = Calendar.getInstance();
        OverTime overTime = realmResults.get(viewType);
        if(overTime.getCreated() == today.getTime()){

        }


        final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_overtime_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(OverTimeListRecyclerViewAdapter.ViewHolder holder, int position) {
        OverTime overTime = realmResults.get(position);

        OverTimeViewModel overTimeViewModel = new OverTimeViewModel(overTime);
        binding = holder.getBinding();
        if (position == TYPE_HEADER){
//            binding.txtHeader.setVisibility(View.VISIBLE);
//            binding.txtDate.setText("昨日");
        }
        binding.btnDelete.setTag(position);

        binding.setViewModel(overTimeViewModel);
        binding.setHandler(new OverTimeRecyclerViewHandler());
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemViewType(int position) {
        // サンプルコードなので手軽に position が偶数の項目と奇数の項目で view type を分ける。
        if (position == 0){
            return 0;
        } else {
            OverTime firstOverTime = realmResults.get(position-1);
            OverTime secondOverTime = realmResults.get(position);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if(dateFormat.format(firstOverTime.getCreated()).equals(dateFormat.format(secondOverTime.getCreated()))){
                return 1;
            }else {
                return 0;
            }
        }
    }

    @Override
    public int getItemCount() {
        return realmResults.size();
    }
}
