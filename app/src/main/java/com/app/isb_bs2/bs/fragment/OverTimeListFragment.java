package com.app.isb_bs2.bs.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.isb_bs2.bs.BR;
import com.app.isb_bs2.bs.R;
import com.app.isb_bs2.bs.databinding.FragmentOvertimeListBinding;
import com.app.isb_bs2.bs.model.OverTime;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class OverTimeListFragment extends BaseFragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private FragmentOvertimeListBinding binding;
    private RecyclerView mRecyclerView;
    private Realm realm;


    private List<OverTime> mWeapons;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public OverTimeListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static OverTimeListFragment newInstance(int columnCount) {
        OverTimeListFragment fragment = new OverTimeListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_overtime_list, container, false);

        binding = FragmentOvertimeListBinding.bind(rootView);
        binding.setVariable(BR.OverTime, BR.OverTime);

        //mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);


        mWeapons = new ArrayList<>();

        mWeapons.add(new OverTime("113231", "aaaa", true));
        mWeapons.add(new OverTime("22222", "bbbb", true));
        mWeapons.add(new OverTime("33333", "cccc", true));
        mWeapons.add(new OverTime("44444", "dddd", true));

        OverTime overTime = new OverTime();
        overTime.setEmployeeCode("aaaaaa");
        overTime.setEmployeeName("bbbb");
        overTime.setOverTime(true);

        binding.setVariable(BR.OverTime, overTime);




        // Set the adapter
       // if (rootView instanceof RecyclerView) {
            //if (mColumnCount <= 1) {
        mRecyclerView = binding.recyclerView;
        mRecyclerView.setHasFixedSize(true);

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                mRecyclerView.setLayoutManager(linearLayoutManager);
            //}
            //else {
               // mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), mColumnCount));
            //}
            mRecyclerView.setAdapter(new OverTimeListRecyclerViewAdapter(mWeapons, mListener));
        //}

        return binding.getRoot();
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction();
    }
}
