package com.app.isb_bs2.bs.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.isb_bs2.bs.R;
import com.app.isb_bs2.bs.realmdata.OverTime;
import com.app.isb_bs2.bs.viewmodel.OverTimeViewModel;

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
    private RecyclerView mRecyclerView;
    private Realm realm;

//    private OverTimeViewModel overTimeViewModel;
    OverTime overTime;


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

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);



        realm = realm.getDefaultInstance();
        RealmResults<OverTime> overTime =realm.where(OverTime.class).findAll();
//        ArrayList<OverTimeViewModel> overTime = new ArrayList(realm.where(OverTime.class).findAll());
        OverTimeListRecyclerViewAdapter adapter = new OverTimeListRecyclerViewAdapter(getContext(), overTime);
        mRecyclerView.setAdapter(adapter);



//
//        OverTimeListRecyclerViewAdapter ovetTimeAdapter = new OverTimeListRecyclerViewAdapter(getContext(), overTime);
//        overTimeView.setAdapter(ovetTimeAdapter);
//        overTimeViewModel = new OverTimeViewModel(realm.where(OverTime.class).findFirst());

//        RealmSearchView realmSearchView = (RealmSearchView)rootView.findViewById(R.id.search_view);
//        realm = Realm.getDefaultInstance();
//        OverTimeListRecyclerViewAdapter adapter = new OverTimeListRecyclerViewAdapter(getContext(), realm, "title");


        // Set the adapter
       // if (rootView instanceof RecyclerView) {
            //if (mColumnCount <= 1) {
//        mRecyclerView = binding.recyclerView;
//        mRecyclerView.setHasFixedSize(true);
//
//
//
            //}
            //else {
               // mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), mColumnCount));
            //}
//            mRecyclerView.setAdapter(new OverTimeListRecyclerViewAdapter(mWeapons, mListener));
        //}

        return rootView;
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
