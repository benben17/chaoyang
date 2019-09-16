package com.bank.manager.common;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {

    public static Date strToDateLong(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    public static String getNowTime() {
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }

    public static String getYearMonth() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMM");
        return df.format(new Date());
    }

    public static String getDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }


    public static String encoding() {
        return "utf-8";
    }
}
