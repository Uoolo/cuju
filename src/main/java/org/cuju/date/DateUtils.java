package org.cuju.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @Author: Uoolo
 * @Description: 时间处理
 * @Date: Create in 10:32 2020/4/7
 */
public class DateUtils {

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 某个日期date增加count个自然月
     * @param date     某个日期(yyyy-MM-dd格式)
     * @param count    相加的月数
     * @return
     * @throws ParseException
     */
    public static String addMonth(String date, int count) throws ParseException {
        int year = Integer.parseInt(date.split("-")[0]);
        int month = Integer.parseInt(date.split("-")[1]);
        int day = Integer.parseInt(date.split("-")[2]);
        int addY=count/12;
        int addM=count%12;
        if (addM + month > 12) {
            year  = year+addY+1;
            month =(month+addM)%12;
        } else {
            year+=addY;
            month += addM;
        }
        if (day >=28) {
            if(day>=getDayByMonth(year + "-" + Integer.parseInt(date.split("-")[1]))) {  //为月底或大于月底
                day=getDayByMonth(year + "-" + month);  //日期变为对应月月底
            }
        }
        return sdf.format(sdf.parse(year + "-" + month + "-" + day));
    }

    /**
     * 获取当前月份的天数
     *
     * @param date
     * @return
     */
    public static int getDayByMonth(String date) {
        int year = Integer.parseInt(date.split("-")[0]);
        int month = Integer.parseInt(date.split("-")[1]);
        int days[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (2 == month && 0 == (year % 4) && (0 != (year % 100) || 0 == (year % 400))) {
            days[1] = 29;
        }
        return Integer.valueOf(days[month - 1]);
    }

    /**
     * 日期格式转换yyyy-MM-dd'T'HH:mm:ss.SSSXXX  (yyyy-MM-dd'T'HH:mm:ss.SSSZ) TO  yyyy-MM-dd HH:mm:ss
     * @throws ParseException
     */
    public static String dealDateFormat(String oldDateStr) throws ParseException{
        try {
            //此格式只有  jdk 1.7才支持  yyyy-MM-dd'T'HH:mm:ss.SSSXXX
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");  //yyyy-MM-dd'T'HH:mm:ss.SSSZ
            Date date = df.parse(oldDateStr);
            SimpleDateFormat df1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
            Date date1 = df1.parse(date.toString());
            DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //  Date date3 =  df2.parse(date1.toString());
            return df2.format(date1);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws ParseException {

        String date="2020-02-29";
        Integer i=1;
        System.out.println("获得"+date+"加"+i+"个自然月时间："+addMonth(date,i));
    }


}
