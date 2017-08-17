package com.app.isb_bs2.bs.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.app.isb_bs2.bs.BR;
import com.app.isb_bs2.bs.realmdata.OverTime;

import butterknife.BindView;

/**
 * Created by sayi65 on 2017/08/05.
 */

public class OverTimeViewModel extends BaseObservable {

    private final OverTime rOverTime;

    public OverTimeViewModel(OverTime rOverTime) {
        this.rOverTime = rOverTime;
    }


    @Bindable
    public boolean isOverTime(){
        if (rOverTime.isValid()){
            return rOverTime.isOverTime();
        }
        return false;
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

    @Bindable
    public String getEmployeeAffiliation(){
        if(rOverTime.isValid()){
            return rOverTime.getEmployeeAffiliation();
        }
        return "";
    }

    @Bindable
    public String getProjectName(){
        if(rOverTime.isValid()){
            return rOverTime.getProjectName();
        }
        return "";
    }

    @Bindable
    public String getProjectCode(){
        if(rOverTime.isValid()){
            return rOverTime.getProjectCode();
        }
        return "";
    }

    @Bindable
    public String getReason(){
        if(rOverTime.isValid()){
            return rOverTime.getReason();
        }
        return "";
    }

    @Bindable
    public String getReasonDetail(){
        if(rOverTime.isValid()){
            return rOverTime.getReasonDetail();
        }
        return "";
    }

    @Bindable
    public String getOverTimePlace(){
        if(rOverTime.isValid()){
            return rOverTime.getOverTimePlace();
        }
        return "";
    }

    @Bindable
    public String getStartTime(){
        if(rOverTime.isValid()){
            return rOverTime.getStartTime();
        }
        return "";
    }

    @Bindable
    public String getEndTime(){
        if(rOverTime.isValid()){
            return rOverTime.getEndTime();
        }
        return "";
    }

    public void setOverTime(boolean isOverTime){
        rOverTime.setOverTime(isOverTime);
        notifyPropertyChanged(BR.overTime);
    }

    public void setEmployeeCode(String employeeCode){
        rOverTime.setEmployeeCode(employeeCode);
        notifyPropertyChanged(BR.employeeCode);
    }

    public void setEmployeeName(String employeeName){
        rOverTime.setEmployeeName(employeeName);
        notifyPropertyChanged(BR.employeeName);
    }

    public void setEmployeeAffiliation(String employeeAffiliation){
        rOverTime.setEmployeeAffiliation(employeeAffiliation);
        notifyPropertyChanged(BR.employeeAffiliation);
    }

    public void setProjectName(String projectName){
        rOverTime.setProjectName(projectName);
        notifyPropertyChanged(BR.projectName);
    }

    public void setProjectCode(String projectCode){
        rOverTime.setProjectCode(projectCode);
        notifyPropertyChanged(BR.projectCode);
    }

    public void setReason(String reason){
        rOverTime.setReason(reason);
        notifyPropertyChanged(BR.reason);
    }

    public void setReasonDetail(String reasonDetail){
        rOverTime.setReasonDetail(reasonDetail);
        notifyPropertyChanged(BR.reasonDetail);
    }

    public void setOverTimePlace(String overTimePlace){
        rOverTime.setOverTimePlace(overTimePlace);
        notifyPropertyChanged(BR.overTimePlace);
    }

    public void setStartTime(String startTime){
        rOverTime.setStartTime(startTime);
        notifyPropertyChanged(BR.startTime);
    }

    public void setEndTime(String endTime){
        rOverTime.setEndTime(endTime);
        notifyPropertyChanged(BR.endTime);
    }

}
