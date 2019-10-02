package com.bank.manager.common;

import com.bank.manager.domain.sys.Device;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    public static  String getBeforeTime(int minute){
        Calendar nowBefore = Calendar.getInstance();
        nowBefore.add(Calendar.MINUTE, minute );
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(nowBefore.getTimeInMillis());

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



    public static String getStartTime(long type) {
        String  startTime=null;
        if (type == 0) { // 5分钟
            startTime= CommonUtils.getBeforeTime(-5);
        } else if (type == 1) { //1小时
            startTime=  CommonUtils.getBeforeTime(-60);
        } else if (type == 2) { //2小时
            startTime = CommonUtils.getBeforeTime(-120);
        } else if (type == 3) {  //4小时
            startTime= CommonUtils.getBeforeTime(-240);
        }
        return startTime;
    }


}
