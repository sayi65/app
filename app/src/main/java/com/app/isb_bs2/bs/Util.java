package com.app.isb_bs2.bs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by 003418 on 2017/08/22.
 */

public class Util {

    public String dateToYYYYMMDDHHSS(Date date){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        return df.format(date);
    }

    public static String parseDate(Date date) {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String formattedDate = "";
        formattedDate = df.format(date);
        return formattedDate;
    }
}
