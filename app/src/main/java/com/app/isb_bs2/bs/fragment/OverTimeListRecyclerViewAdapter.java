package com.app.isb_bs2.bs.fragment;

import android.content.ClipData;
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
import com.app.isb_bs2.bs.fragment.OverTimeListFragment.OnListFragmentInteractionListener;
import com.app.isb_bs2.bs.fragment.dummy.DummyContent.DummyItem;
import com.app.isb_bs2.bs.model.OverTime;

import java.util.List;

import io.realm.RealmList;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class OverTimeListRecyclerViewAdapter extends RecyclerView.Adapter<OverTimeListRecyclerViewAdapter.ViewHolder> {

    private final List<OverTime> mValues;
    private final OnListFragmentInteractionListener mListener;
    private FragmentOvertimeListItemBinding binding;

    public OverTimeListRecyclerViewAdapter(List<OverTime> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.fragment_overtime_list_item, parent, false);


        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        OverTime overTime = mValues.get(position);
        //binding.setOverTime(overTime);
        holder.getBinding().setVariable(BR.OverTime, overTime);
//        holder.getBinding().setVariable(BR.OverTime, overTime);
        holder.getBinding().executePendingBindings();



//        holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (null != mListener) {
//                    // Notify the active callbacks interface (the activity, if the
//                    // fragment is attached to one) that an item has been selected.
//                    mListener.onListFragmentInteraction(holder.mItem);
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private FragmentOvertimeListItemBinding binding;

        public ViewHolder(FragmentOvertimeListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public ViewDataBinding getBinding() {
            return DataBindingUtil.getBinding(itemView);
        }

    }
}
