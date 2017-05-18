package com.app.isb_bs2.bs.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;
import android.os.Trace;

import com.android.databinding.library.baseAdapters.BR;

import io.realm.RealmChangeListener;
import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by sayi65 on 2017/04/16.
 */

//public class OverTime extends RealmObject implements Observable {
public class OverTime extends RealmObject implements Observable,RealmDataBinding {

    public OverTime() {

    }

    private String employeeCode;
    private String employeeName;
    private boolean isOverTime;

    public OverTime(String employeeCode, String employeeName, boolean isOverTime) {
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.isOverTime = isOverTime;
    }

    @Bindable
    public String getEmployeeCode() {
        return employeeCode;
    }

    @Bindable
    public String getEmployeeName() {
        return employeeName;

    }

    @Bindable
    public boolean isOverTime() {
        return isOverTime;
    }


    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
        if (!isValid()) {
            notifyPropertyChanged(BR.employeeCode);
        }

    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
        if (!isValid()) {
            notifyPropertyChanged(BR.employeeName);
        }
    }

    public void setOverTime(boolean overTime) {
        isOverTime = overTime;
        if (!isValid()) {
            notifyPropertyChanged(BR.overTime);
        }
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback) {
        if (mCallbacks == null) {
            mCallbacks = new PropertyChangeRegistry();
        }
        mCallbacks.add(onPropertyChangedCallback);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback) {
        if (mCallbacks != null) {
            mCallbacks.remove(onPropertyChangedCallback);
        }
    }

    @Ignore
    private transient PropertyChangeRegistry mCallbacks;

    /**
     * Notifies listeners that all properties of this instance have changed.
     * Inherited from RealmDataBinding interface (along with it coming from BaseObservable)
     */
    public synchronized void notifyChange() {
        if (mCallbacks != null) {
            mCallbacks.notifyCallbacks(this, 0, null);
        }
    }

    /**
     * Notifies listeners that a specific property has changed. The getter for the property
     * that changes should be marked with {@link Bindable} to generate a field in
     * <code>BR</code> to be used as <code>fieldId</code>.
     *
     * @param fieldId The generated BR id for the Bindable field.
     */
    public void notifyPropertyChanged(int fieldId) {
        if (mCallbacks != null) {
            mCallbacks.notifyCallbacks(this, fieldId, null);
        }
    }
}


