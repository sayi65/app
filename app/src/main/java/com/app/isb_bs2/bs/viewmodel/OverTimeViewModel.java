package com.app.isb_bs2.bs.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.app.isb_bs2.bs.BR;
import com.app.isb_bs2.bs.realmdata.OverTime;

/**
 * Created by sayi65 on 2017/08/05.
 */

public class OverTimeViewModel extends BaseObservable {

    private final OverTime rOverTime;

    public OverTimeViewModel(OverTime rOverTime) {
        this.rOverTime = rOverTime;
    }

    @Bindable
    public String getEmployeeCode(){
        if(rOverTime.isValid()){
            return rOverTime.getEmployeeCode();
        }
        return "";
    }

    @Bindable
    public String getEmployeeName(){
        if(rOverTime.isValid()){
            return rOverTime.getEmployeeName();
        }
        return "";
    }

    public void setEmployeeCode(String employeeCode){
        rOverTime.setEmployeeCode(employeeCode);
        notifyPropertyChanged(BR.employeeCode);
    }

    public void setEmployeeName(String employeeName){
        rOverTime.setEmployeeName(employeeName);
        notifyPropertyChanged(BR.employeeName);
    }
}
