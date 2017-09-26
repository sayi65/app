package com.app.isb_bs2.bs.realmdata;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by 003418 on 2017/09/25.
 */

public class Schedule extends RealmObject {

    // 社員コード
    private String employeeCode;
    // 社員名
    private String employeeName;
    //　タイトル
    private String title;
    // 内容
    private String content;
    // 開始時間
    private Date startDate;
    //　終了時間
    private Date endDate;
    //作成日
    private Date created;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
