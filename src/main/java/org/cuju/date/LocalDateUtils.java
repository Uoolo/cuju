package org.cuju.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Locale;

/**
 * @Author: Uoolo
 * @Description: LocalDate处理
 * @Date: Create in 16:16 2020/10/10
 */
public class LocalDateUtils {
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter DATETIME_FORMATTER =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取当前系统时间
     * @return
     */
    public static LocalTime getLocalTime() {
        return LocalTime.now();
    }

    /**
     * 获取当前系统日期
     * @return
     */
    public static LocalDate getLocalDate() {
        return LocalDate.now();
    }

    /**
     * 获取当前系统日期时间
     * @return
     */
    public static LocalDateTime getLocalDateTime() {
        return LocalDateTime.now();
    }

    /**
     * 获取当前系统时间字符串
     * @return
     */
    public static String getLocalDateString(String pattern) {
        return LocalTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 获取当前系统时间字符串
     * @return
     */
    public static String getLocalTimeString() {
        return LocalTime.now().format(TIME_FORMATTER);
    }


    /**
     * 获取当前系统日期字符串
     * @return
     */
    public static String getLocalDateString() {
        return LocalDate.now().format(DATE_FORMATTER);
    }

    /**
     * 获取当前系统日期时间字符串
     * @return
     */
    public static String getLocalDateTimeString() {
        return LocalDateTime.now().format(DATETIME_FORMATTER);
    }

    /**
     * 格式化日期字符串
     * @return
     */
    public static String formatDate(LocalDate localDate) {
        if (localDate == null) {
            return null;
        }
        return localDate.format(DATE_FORMATTER);
    }

    /**
     * 格式化日期字符串
     * @return
     */
    public static String formatDate(LocalDate localDate, String pattern) {
        if (localDate == null) {
            return null;
        }
        if (pattern == null) {
            return localDate.format(DATE_FORMATTER);
        } else {
            return localDate.format(DateTimeFormatter.ofPattern(pattern));
        }
    }

    /**
     * 格式化日期时间字符串
     * @return
     */
    public static String formatDateTime(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        return localDateTime.format(DATETIME_FORMATTER);
    }

    /**
     * 格式化日期时间字符串
     * @return
     */
    public static String formatDateTime(LocalDateTime localDateTime, String pattern) {
        if (localDateTime == null) {
            return null;
        }
        if (pattern == null) {
            return localDateTime.format(DATETIME_FORMATTER);
        } else {
            return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
        }
    }

    /**
     * 格式化时间字符串
     * @return
     */
    public static String formatTime(LocalTime localTime) {
        if (localTime == null) {
            return null;
        }
        return localTime.format(TIME_FORMATTER);
    }

    /**
     * 格式化时间字符串
     * @return
     */
    public static String formatTime(LocalTime localTime, String pattern) {
        if (localTime == null) {
            return null;
        }
        if (pattern == null) {
            return localTime.format(TIME_FORMATTER);
        } else {
            return localTime.format(DateTimeFormatter.ofPattern(pattern));
        }
    }

    /**
     * 格式化时间字符串
     * @return
     */
    public static String formatTime(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        return localDateTime.format(TIME_FORMATTER);
    }

    /**
     * 格式化时间字符串
     * @return
     */
    public static String formatTime(LocalDateTime localDateTime, String pattern) {
        if (localDateTime == null) {
            return null;
        }
        if (pattern == null) {
            return localDateTime.format(TIME_FORMATTER);
        } else {
            return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
        }
    }

    /**
     * 格式化日期
     * @return
     */
    public static LocalDateTime formatLocalDate(long timestamp) {
        return LocalDateTime.ofEpochSecond(timestamp,0,ZoneOffset.ofHours(8));
    }

    /**
     * 格式化日期
     * @return
     */
    public static LocalDateTime formatLocalDate(long timestamp, String pattern) {
        return LocalDateTime.ofEpochSecond(timestamp,0,ZoneOffset.ofHours(8));
    }

    /**
     * 格式化日期时间字符串
     * @return
     */
    public static String formatLocalDateStr(long timestamp) {
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(timestamp,0,ZoneOffset.ofHours(8));
        return localDateTime.format(DATE_FORMATTER);
    }

    /**
     * 格式化日期时间字符串
     * @return
     */
    public static String formatLocalDateStr(long timestamp, String pattern) {
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(timestamp,0,ZoneOffset.ofHours(8));
        if (pattern == null) {
            return localDateTime.format(DATE_FORMATTER);
        } else {
            return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
        }
    }

    /**
     * 格式化日期时间
     * @return
     */
    public static LocalDateTime formatLocalDateTime(long timestamp) {
        return LocalDateTime.ofEpochSecond(timestamp / 1000,0,ZoneOffset.ofHours(8));
    }

    /**
     * 格式化日期时间
     * @return
     */
    public static LocalDateTime formatLocalDateTime(long timestamp, String pattern) {
        return LocalDateTime.ofEpochSecond(timestamp / 1000,0,ZoneOffset.ofHours(8));
    }

    /**
     * 格式化日期时间字符串
     * @return
     */
    public static String formatLocalDateTimeStr(long timestamp) {
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(timestamp / 1000,0,ZoneOffset.ofHours(8));
        return localDateTime.format(DATETIME_FORMATTER);
    }

    /**
     * 格式化日期时间字符串
     * @return
     */
    public static String formatLocalDateTimeStr(long timestamp, String pattern) {
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(timestamp / 1000,0,ZoneOffset.ofHours(8));
        if (pattern == null) {
            return localDateTime.format(DATETIME_FORMATTER);
        } else {
            return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
        }
    }
    /**
     * 获取系统时间戳
     * @return Long
     */
    public static Long getTimestampMilli() {
        return LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 获取指定日期的毫秒时间戳
     * @param localDate
     * @return
     */
    public static Long getTimestampMilli(LocalDate localDate) {
        return localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 获取指定日期的秒时间戳
     * @param localDate
     * @return
     */
    public static Long getTimestampSeconds(LocalDate localDate) {
        return localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    /**
     * 获取指定日期时间的毫秒时间戳
     * @param localDateTime
     * @return
     */
    public static Long getTimestampMilli(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 获取指定日期时间的秒时间戳
     * @param localDateTime
     * @return
     */
    public static Long getTimestampSeconds(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    /**
     * 字符串转LocalTime
     * @param time
     * @return
     */
    public static LocalTime  parseLocalTime(String time) {
        return LocalTime.parse(time, TIME_FORMATTER);
    }

    /**
     * 字符串转LocalTime
     * @param time
     * @return
     */
    public static LocalTime  parseLocalTime(String time, String pattern) {
        if (pattern != null && !"".equals(pattern)) {
            return LocalTime.parse(time, DateTimeFormatter.ofPattern(pattern));
        }
        return LocalTime.parse(time, TIME_FORMATTER);
    }

    /**
     * 字符串转LocalDate
     * @param date
     * @return
     */
    public static LocalDate  parseLocalDate(String date) {
        return LocalDate.parse(date, DATE_FORMATTER);
    }

    /**
     * 字符串转LocalDate
     * @param date
     * @return
     */
    public static LocalDate  parseLocalDate(String date, String pattern) {
        if (pattern != null && !"".equals(pattern)) {
            return LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
        }
        return LocalDate.parse(date, DATE_FORMATTER);
    }

    /**
     * 字符串转LocalDateTime
     * @param dateTime
     * @return
     */
    public static LocalDateTime parseLocalDateTime(String dateTime) {
        return LocalDateTime.parse(dateTime, DATETIME_FORMATTER);
    }

    /**
     * 字符串转LocalDate
     * @param date
     * @return
     */
    public static LocalDateTime  parseLocalDateTime(String date, String pattern) {
        if (pattern != null && !"".equals(pattern)) {
            return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern));
        }
        return LocalDateTime.parse(date, DATETIME_FORMATTER);
    }

    /**
     * Date转LocalDateTime
     * @param date
     * @return
     */
    public static LocalDateTime date2LocalDateTime(Date date) {
        Instant instant = date.toInstant();//An instantaneous point on the time-line.(时间线上的一个瞬时点。)
        ZoneId zoneId = ZoneId.systemDefault();//A time-zone ID, such as {@code Europe/Paris}.(时区)
        return instant.atZone(zoneId).toLocalDateTime();
    }

    /**
     * Date转LocalDate
     * @param date
     * @return
     */
    public static LocalDate date2LocalDate(Date date) {
        Instant instant = date.toInstant();//An instantaneous point on the time-line.(时间线上的一个瞬时点。)
        ZoneId zoneId = ZoneId.systemDefault();//A time-zone ID, such as {@code Europe/Paris}.(时区)
        return instant.atZone(zoneId).toLocalDate();
    }

    /**
     * Date转LocalDate
     * @param date
     * @return
     */
    public static LocalTime date2LocalTime(Date date) {
        Instant instant = date.toInstant();//An instantaneous point on the time-line.(时间线上的一个瞬时点。)
        ZoneId zoneId = ZoneId.systemDefault();//A time-zone ID, such as {@code Europe/Paris}.(时区)
        return instant.atZone(zoneId).toLocalTime();
    }

    /**
     * LocalDateTime转换为Date
     * @param localDateTime
     */
    public static Date localDateTime2Date(LocalDateTime localDateTime){
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);//Combines this date-time with a time-zone to create a  ZonedDateTime.
        return Date.from(zdt.toInstant());
    }

    /**
     * 获取指定日期星期
     * @return
     */
    public static Integer getWeek(){
        return LocalDate.now().getDayOfWeek().getValue();
    }

    /**
     * 获取指定日期星期
     * @param localDate
     * @return
     */
    public static Integer getWeek(LocalDate localDate){
        if (localDate == null) {
            return null;
        }
        return localDate.getDayOfWeek().getValue();
    }

    /**
     * 获取指定当前日期星期
     * textStyle
     */
    public static String getWeek(TextStyle textStyle, Locale locale){
        return LocalDate.now().getDayOfWeek().getDisplayName(textStyle, locale);
    }

    /**
     * 获取今天的00:00:00
     * @return
     */
    public static String getDayStart() {
        return getDayStart(LocalDateTime.now());
    }

    /**
     * 获取今天的23:59:59
     * @return
     */
    public static String getDayEnd() {
        return getDayEnd(LocalDateTime.now());
    }

    /**
     * 获取某天的00:00:00
     * @param dateTime
     * @return
     */
    public static String getDayStart(LocalDateTime dateTime) {
        return formatDateTime(dateTime.with(LocalTime.MIN));
    }

    /**
     * 获取某天的23:59:59
     * @param dateTime
     * @return
     */
    public static String getDayEnd(LocalDateTime dateTime) {
        return formatDateTime(dateTime.with(LocalTime.MAX));
    }

    /**
     * 获取本月第一天的00:00:00
     *
     * @return
     */
    public static String getFirstDayOfMonth() {
        return getFirstDayOfMonth(LocalDateTime.now());
    }

    /**
     * 获取本月最后一天的23:59:59
     *
     * @return
     */
    public static String getLastDayOfMonth() {
        return getLastDayOfMonth(LocalDateTime.now());
    }

    /**
     * 获取某月第一天的00:00:00
     *
     * @param dateTime
     *            LocalDateTime对象
     * @return
     */
    public static String getFirstDayOfMonth(LocalDateTime dateTime) {
        return formatDateTime(dateTime.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN));
    }

    /**
     * 获取某月最后一天的23:59:59
     *
     * @param dateTime
     *            LocalDateTime对象
     * @return
     */
    public static String getLastDayOfMonth(LocalDateTime dateTime) {
        return formatDateTime(dateTime.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX));
    }

    /**
     * 指定日期时间增加秒，负数减秒
     * @param localDateTime
     * @param seconds
     * @return
     */
    public static LocalDateTime addSeconds(LocalDateTime localDateTime, int seconds) {
        return localDateTime.plus(seconds, ChronoUnit.SECONDS);
    }
    /**
     * 指定日期时间增加分钟，负数减分钟
     * @param localDateTime
     * @param minutes
     * @return
     */
    public static LocalDateTime addMinutes(LocalDateTime localDateTime, int minutes) {
        return localDateTime.plus(minutes, ChronoUnit.MINUTES);
    }
    /**
     * 指定日期时间增加小时，负数减小时
     * @param localDateTime
     * @param hours
     * @return
     */
    public static LocalDateTime addHours(LocalDateTime localDateTime, int hours) {
        return localDateTime.plus(hours, ChronoUnit.HOURS);
    }

    /**
     * 指定日期时间增加天，负数减天
     * @param localDate
     * @param days
     * @return
     */
    public static LocalDate addDays(LocalDate localDate, int days) {
        return localDate.plus(days, ChronoUnit.DAYS);
    }

    /**
     * 指定日期时间增加天，负数减天
     * @param localDateTime
     * @param days
     * @return
     */
    public static LocalDateTime addDays(LocalDateTime localDateTime, int days) {
        return localDateTime.plus(days, ChronoUnit.DAYS);
    }

    /**
     * 指定日期时间增加月，负数减月
     * @param localDate
     * @param months
     * @return
     */
    public static LocalDate addMonths(LocalDate localDate, int months) {
        return localDate.plus(months, ChronoUnit.MONTHS);
    }

    /**
     * 指定日期时间增加月，负数减月
     * @param localDateTime
     * @param months
     * @return
     */
    public static LocalDateTime addMonths(LocalDateTime localDateTime, int months) {
        return localDateTime.plus(months, ChronoUnit.MONTHS);
    }

    /**
     * 指定日期时间增加年，负数减年
     * @param localDate
     * @param years
     * @return
     */
    public static LocalDate addYears(LocalDate localDate, int years) {
        return localDate.plus(years, ChronoUnit.YEARS);
    }

    /**
     * 指定日期时间增加年，负数减年
     * @param localDateTime
     * @param years
     * @return
     */
    public static LocalDateTime addYears(LocalDateTime localDateTime, int years) {
        return localDateTime.plus(years, ChronoUnit.YEARS);
    }

    /**
     * 获取两个日期相差的秒
     * @param startTime
     * @param endTime
     * @return
     */
    public static long diffSeconds(LocalDateTime startTime, LocalDateTime endTime) {
        return diffDateTime(startTime, endTime, ChronoUnit.SECONDS);
    }

    /**
     * 获取两个日期相差的分
     * @param startTime
     * @param endTime
     * @return
     */
    public static long diffMinutes(LocalDateTime startTime, LocalDateTime endTime) {
        return diffDateTime(startTime, endTime, ChronoUnit.MINUTES);
    }

    /**
     * 获取两个日期相差的小时
     * @param startTime
     * @param endTime
     * @return
     */
    public static long diffHours(LocalDateTime startTime, LocalDateTime endTime) {
        return diffDateTime(startTime, endTime, ChronoUnit.HOURS);
    }

    /**
     * 获取两个日期相差的天
     * @param startTime
     * @param endTime
     * @return
     */
    public static long diffDays(LocalDateTime startTime, LocalDateTime endTime) {
        return diffDateTime(startTime, endTime, ChronoUnit.DAYS);
    }

    /**
     * 获取两个日期相差的月
     * @param startTime
     * @param endTime
     * @return
     */
    public static long diffMonths(LocalDateTime startTime, LocalDateTime endTime) {
        return diffDateTime(startTime, endTime, ChronoUnit.MONTHS);
    }

    /**
     * 获取两个日期相差的年
     * @param startTime
     * @param endTime
     * @return
     */
    public static long diffYears(LocalDateTime startTime, LocalDateTime endTime) {
        return diffDateTime(startTime, endTime, ChronoUnit.YEARS);
    }

    /**
     * 获取两个日期相差的天
     * @param startTime
     * @param endTime
     * @return
     */
    public static long diffDays(LocalDate startTime, LocalDate endTime) {
        return endTime.until(startTime).getDays();
    }

    /**
     * 获取两个日期相差的月
     * @param startTime
     * @param endTime
     * @return
     */
    public static long diffMonths(LocalDate startTime, LocalDate endTime) {
        return endTime.until(startTime).getMonths();
    }

    /**
     * 获取两个日期相差的年
     * @param startTime
     * @param endTime
     * @return
     */
    public static long diffYears(LocalDate startTime, LocalDate endTime) {
        return endTime.until(startTime).getYears();
    }

    /**
     * 获取两个日期的差  field参数为ChronoUnit.*
     * @param startTime
     * @param endTime
     * @param field  单位(年月日)
     * @return
     */
    public static long diffDate(LocalDate startTime, LocalDate endTime, ChronoUnit field) {
        Period period = Period.between(startTime, endTime);
        if (field == ChronoUnit.YEARS) {
            return period.getYears();
        }
        if (field == ChronoUnit.MONTHS) {
            return period.getYears() * 12 + period.getMonths();
        }
        return field.between(startTime, endTime);
    }

    /**
     * 获取两个日期的差  field参数为ChronoUnit.*
     * @param startTime
     * @param endTime
     * @param field  单位(年月日时分秒)
     * @return
     */
    public static long diffDateTime(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit field) {
        Period period = Period.between(LocalDate.from(startTime), LocalDate.from(endTime));
        if (field == ChronoUnit.YEARS) {
            return period.getYears();
        }
        if (field == ChronoUnit.MONTHS) {
            return period.getYears() * 12 + period.getMonths();
        }
        return field.between(startTime, endTime);
    }

    /**
     * 计算年龄
     * @param birthday 出生日期
     * @return
     */
    public static long getAge(String birthday) {
        return parseLocalDate(birthday).until(LocalDate.now()).getYears();
    }


    /**
     * 计算年龄
     * @param birthday 出生日期
     * @return
     */
    public static long getAge(LocalDate birthday) {
        return birthday.until(LocalDate.now()).getYears();
    }

    /**
     * 计算年龄
     * @param birthday 出生日期
     * @return
     */
    public static long getAge(LocalDateTime birthday) {
        return diffDateTime(birthday, LocalDateTime.now(), ChronoUnit.YEARS);
    }

    /**
     * 计算年龄
     * @param birthday 出生日期
     * @param now 截止日期
     * @return
     */
    public static long getAge(LocalDate birthday, LocalDate now) {
        return birthday.until(now).getYears();
    }

    /**
     * 计算年龄
     * @param birthday 出生日期
     * @param now 截止日期
     * @return
     */
    public static long getAge(LocalDateTime birthday, LocalDateTime now) {
        return diffDateTime(birthday, now, ChronoUnit.YEARS);
    }

    public static String formatLocalDateTime(LocalDateTime localDateTime, String pattern) {
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static Date localDate2Date(LocalDate localDate) {
        if (localDate == null) {
            return null;
        }
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date localDateTime2Date2(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date localTime2Date(LocalTime localTime) {
        if (localTime == null) {
            return null;
        }
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), localTime);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date localTime2Date(LocalDate localDate, LocalTime localTime) {
        if (localTime == null) {
            return null;
        }
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
