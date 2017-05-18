package com.app.isb_bs2.bs.fragment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created by sayi65 on 2017/04/16.
 */

public class BaseFragment extends Fragment {

    @TargetApi(23)
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
//        if (activity instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) activity;
//        } else {
//            throw new RuntimeException(activity.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }
}
