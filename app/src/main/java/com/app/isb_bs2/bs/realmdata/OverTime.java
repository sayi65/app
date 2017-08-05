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
//    private boolean isOverTime;

//    public OverTime(String employeeCode, String employeeName, boolean isOverTime) {
//        this.employeeCode = employeeCode;
//        this.employeeName = employeeName;
//        this.isOverTime = isOverTime;
//    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;

    }

//    public boolean isOverTime() {
//        return isOverTime;
//    }


    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

//    public void setOverTime(boolean overTime) {
//        isOverTime = overTime;
//    }
}


