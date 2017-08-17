package com.app.isb_bs2.bs.fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.app.isb_bs2.bs.R;
import com.app.isb_bs2.bs.realmdata.OverTime;
import java.util.List;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the
 * interface.
 */
public class OverTimeListFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private Realm realm;

    public OverTimeListFragment() {
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_overtime_list, container, false);

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("残業申請登録");

        View imageButton = toolbar.findViewById(R.id.add_button);
        imageButton.setVisibility(View.VISIBLE);
        imageButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        realm = realm.getDefaultInstance();
        RealmResults<OverTime> overTime =realm.where(OverTime.class).findAll();
        OverTimeListRecyclerViewAdapter adapter = new OverTimeListRecyclerViewAdapter(getContext(), overTime);
        mRecyclerView.setAdapter(adapter);

        return rootView;
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }
}
