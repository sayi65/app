package com.app.isb_bs2.bs.realmdata;

import android.databinding.Bindable;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

/**
 * Created by sayi65 on 2017/04/16.
 */

//public class OverTime extends RealmObject {
@RealmClass
public class OverTime extends RealmObject{

    //残業ステータス
    private boolean isOverTime;
    // 社員コード
    private String employeeCode;
    // 社員名
    private String employeeName;
    // 所属部署
    private String employeeAffiliation;
    // 業務名
    private String projectName;
    // PJコード
    private String projectCode;
    // 不可避事由
    private String reason;
    // 理由詳細
    private String reasonDetail;
    // 作業場所
    private String overTimePlace;
    // 出社
    private String startTime;
    // 退社
    private String endTime;
    //作成日
    private Date created;


    public boolean isOverTime() {
        return isOverTime;
    }

    public void setOverTime(boolean overTime) {
        isOverTime = overTime;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAffiliation() {
        return employeeAffiliation;
    }

    public void setEmployeeAffiliation(String employeeAffiliation) {
        this.employeeAffiliation = employeeAffiliation;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReasonDetail() {
        return reasonDetail;
    }

    public void setReasonDetail(String reasonDetail) {
        this.reasonDetail = reasonDetail;
    }

    public String getOverTimePlace() {
        return overTimePlace;
    }

    public void setOverTimePlace(String overTimePlace) {
        this.overTimePlace = overTimePlace;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

}


