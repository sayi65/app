package com.app.isb_bs2.bs;

import android.text.format.DateUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by 003418 on 2017/08/22.
 */

public class Util {

    public static Calendar today = Calendar.getInstance();

    public String dateToYYYYMMDDHHSS(Date date){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        return df.format(date);
    }

    public static String dateToMMDD(Date date){
        DateFormat df = new SimpleDateFormat("MM/dd");
        Date today = Calendar.getInstance().getTime();
        return df.format(date);
    }


    public static boolean isYesterday(long date) {
        Calendar now = Calendar.getInstance();
        Calendar cdate = Calendar.getInstance();
        cdate.setTimeInMillis(date);

        now.add(Calendar.DATE,-1);

        return now.get(Calendar.YEAR) == cdate.get(Calendar.YEAR)
                && now.get(Calendar.MONTH) == cdate.get(Calendar.MONTH)
                && now.get(Calendar.DATE) == cdate.get(Calendar.DATE);
    }

    public static String getWeekday(Date date){

        String[] weekList = { "日曜日", "月曜日", "火曜日", "水曜日",
                "木曜日", "金曜日", "土曜日"};
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        return weekList[dayOfWeek - 1];

    }

    public static boolean isFriday(){
        Calendar today = Calendar.getInstance();
        int now = today.get(Calendar.DAY_OF_WEEK);
//        if(now == Calendar.FRIDAY){
//            return true;
//        } else {
//            return false;
//        }
        return true;
    }
}
