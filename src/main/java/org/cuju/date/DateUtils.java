package org.cuju.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
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

    /**
     * @Description : 获取指定日期时间
     * DateUtils
     * @Return :
     * @Author : Uoolo
     * @Date : 2020/5/19 14:09
    */
    public static Date getCalendar(int year,int month,int day){
        Calendar c1 = Calendar.getInstance();
        c1.set(year,month-1,day,0,0,0);
        return c1.getTime();
    }

    /**
     * @Description : 获取时间字符串
     * DateUtils
     * @Return :
     * @Author : Uoolo
     * @Date : 2020/5/19 14:22
    */
    public static String getDateStr(Date date, String pattern){
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }

    /**
     * @Description : 日期（yyyy-MM-dd）转LocalDateTime
     *
     * @param object
     * @Return :
     * @Author : Uoolo
     * @Date : 2020/9/9 17:20
    */
    public static LocalDateTime parseLocalDateTime(Object object){
        if(object == null)
            return null;
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(object.toString() + " 00:00:00",df);
    }

    /**
     * @Description : LocalDateTime转字符串时间
     *
     * @param localDateTime
     * @Return :
     * @Author : Uoolo
     * @Date : 2020/9/9 17:21
    */
    public static String localDateTimeToString(LocalDateTime localDateTime){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return df.format(localDateTime);
    }

   /**
    * @Description : 根据生日计算当前周岁数
    * 参考：https://www.jianshu.com/p/7a9f62e6db50
    * @param birthday,targetDate
    * @Return : 周岁
    * @Author : Uoolo
    * @Date : 2020/9/21 09:42
   */
    public int getCurrentAge(Date birthday,Date targetDate) {
        // 当前时间
        Calendar curr = Calendar.getInstance();
        if(targetDate != null){
            curr.setTime(targetDate);
        }
        // 生日
        Calendar born = Calendar.getInstance();
        born.setTime(birthday);
        // 年龄 = 当前年 - 出生年
        int age = curr.get(Calendar.YEAR) - born.get(Calendar.YEAR);
        if (age <= 0) {
            return 0;
        }
        // 如果当前月份小于出生月份: age-1
        // 如果当前月份等于出生月份, 且当前日小于出生日: age-1
        int currMonth = curr.get(Calendar.MONTH);
        int currDay = curr.get(Calendar.DAY_OF_MONTH);
        int bornMonth = born.get(Calendar.MONTH);
        int bornDay = born.get(Calendar.DAY_OF_MONTH);
        if ((currMonth < bornMonth) || (currMonth == bornMonth && currDay <= bornDay)) {
            age--;
        }
        return age < 0 ? 0 : age;
    }


}
