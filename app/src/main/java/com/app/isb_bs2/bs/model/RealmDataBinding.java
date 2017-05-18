package com.app.isb_bs2.bs.model;

import io.realm.RealmChangeListener;

/**
 * Created by sayi65 on 2017/04/20.
 */

public interface RealmDataBinding {
    interface Factory {
        RealmChangeListener create();
    }

    RealmDataBinding.Factory FACTORY = () -> element -> {
        if(element instanceof RealmDataBinding) {
            ((RealmDataBinding)element).notifyChange();
        }
    };

    void notifyChange();
}
