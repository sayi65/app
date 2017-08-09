package com.app.isb_bs2.bs.realmdata;

import android.databinding.Bindable;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

/**
 * Created by sayi65 on 2017/04/16.
 */

//public class OverTime extends RealmObject {
@RealmClass
public class OverTime extends RealmObject{

    private String employeeCode;
    private String employeeName;
    private boolean isOverTime;
    private String reason;


    public String getEmployeeCode() {
        return employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;

    }

    public boolean isOverTime() {
        return isOverTime;
    }

    public String getReason(){
        return reason;
    }


    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setOverTime(boolean isOverTime){
        this.isOverTime = isOverTime;
    }

    public void setReason(String reason){
        this.reason = reason;
    }
}


