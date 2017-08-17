package com.app.isb_bs2.bs.rxevent;

import com.app.isb_bs2.bs.realmdata.OverTime;

/**
 * Created by 003418 on 2017/08/17.
 */

public class OverTimeEvent {

    private int code;
    private String msg;

    public OverTimeEvent(){}

    public OverTimeEvent(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
