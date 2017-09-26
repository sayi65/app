package com.app.isb_bs2.bs.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.app.isb_bs2.bs.BR;
import com.app.isb_bs2.bs.realmdata.OverTime;
import com.app.isb_bs2.bs.realmdata.Schedule;

import java.util.Date;

/**
 * Created by 003418 on 2017/09/25.
 */

public class ScheduleViewModel extends BaseObservable {


    private final Schedule rSchedule;

    public ScheduleViewModel(Schedule rSchedule) {
        this.rSchedule = rSchedule;
    }

    @Bindable
    public String getEmployeeCode(){
        if(rSchedule.isValid()){
            return rSchedule.getEmployeeCode();
        }
        return "";
    }

    @Bindable
    public String getEmployeeName(){
        if(rSchedule.isValid()){
            return rSchedule.getEmployeeName();
        }
        return "";
    }

    @Bindable
    public String getTitle(){
        if(rSchedule.isValid()){
            return rSchedule.getTitle();
        }
        return "";
    }

    @Bindable
    public String getContent(){
        if(rSchedule.isValid()){
            return rSchedule.getContent();
        }
        return "";
    }

    @Bindable
    public Date getStartDate(){
        if(rSchedule.isValid()){
            return rSchedule.getStartDate();
        }
        return null;
    }

    @Bindable
    public Date getEndDate(){
        if(rSchedule.isValid()){
            return rSchedule.getEndDate();
        }
        return null;
    }

    @Bindable
    public Date getCreated(){
        if(rSchedule.isValid()){
            return rSchedule.getCreated();
        }
        return null;
    }

    public void setEmployeeCode(String employeeCode){
        rSchedule.setEmployeeCode(employeeCode);
        notifyPropertyChanged(BR.employeeCode);
    }

    public void setEmployeeName(String employeeName){
        rSchedule.setEmployeeName(employeeName);
        notifyPropertyChanged(BR.employeeName);
    }

    public void setTitle(String title){
        rSchedule.setTitle(title);
        notifyPropertyChanged(BR.title);
    }

    public void setContent(String content){
        rSchedule.setContent(content);
        notifyPropertyChanged(BR.content);
    }

    public void setStartDate(Date startDate){
        rSchedule.setStartDate(startDate);
        notifyPropertyChanged(BR.startDate);
    }

    public void setEndDate(Date endDate){
        rSchedule.setEndDate(endDate);
        notifyPropertyChanged(BR.endDate);
    }

    public void setCreated(Date created){
        rSchedule.setCreated(created);
        notifyPropertyChanged(BR.created);
    }
}
