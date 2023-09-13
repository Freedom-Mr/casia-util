package casia.isiteam.api.toolutil.time;

import casia.isiteam.api.toolutil.regex.CasiaRegexUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * ClassName: CasiaTimeUtil
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/4/22
 * Email: zhiyou_wang@foxmail.com
 */
public class CasiaTimeUtil extends CasiaTimeFormat{
    /**
     * 获取当前时间
     * @return 默认返回格式 YYYY-MM-dd HH:mm:ss
     */
    public static synchronized String getNowDateTime(){
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(YYYY_MM_dd_HH_mm_ss);
        String format = ldt.format(dtf);
        return format;
    }
    /**
     * 获取当前时间
     * @param pattern 格式
     * @return 根据自定义格式返回
     */
    public static synchronized String getNowDateTime(String pattern){
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        String format = ldt.format(dtf);
        return format;
    }
    /**
     * Date转String
     * @param dateTime 待处理时间
     * @param pattern 时间格式
     * @return 根据自定义格式返回
     */
    public static synchronized String dateTimeToString(Date dateTime,String pattern){
        Instant instant = Instant.ofEpochMilli(dateTime.getTime());
        ZoneId zone = ZoneId.systemDefault();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        String format = dtf.format(LocalDateTime.ofInstant(instant, zone));
        return format;
    }
    /**
     * 转换时间格式
     * @param dateTime 待处理时间
     * @param startPattern 初始时间格式
     * @param endPattern 转换的时间格式
     * @return 根据自定义格式返回
     */
    public static synchronized String transafeDateTime(String dateTime,String startPattern,String endPattern){
        DateTimeFormatter start_df = DateTimeFormatter.ofPattern(startPattern);
        DateTimeFormatter end_df = DateTimeFormatter.ofPattern(endPattern);
        try {
            LocalDateTime date_time = LocalDateTime.parse(dateTime,start_df);
            return end_df.format(date_time);
        }catch (Exception E){
            try {
                LocalDate date = LocalDate.parse(dateTime,start_df);
                LocalDateTime localDateTime = LocalDateTime.of(date,LocalTime.of(0,0,0));
                return end_df.format(localDateTime);
            }catch (Exception e){
                LocalTime time = LocalTime.parse(dateTime,start_df);
                LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(),time);
                return end_df.format(localDateTime);
            }
        }
    }
    /**
     * 比较两个字符串时间差
     * @param firstDateTime 第一个时间
     * @param secondDateTime 第二个时间
     * @param pattern 时间格式，特殊格式除外
     * @return 返回毫秒差值( firstDateTime - secondDateTime)
     */
    public static synchronized long compareToDateTime(String firstDateTime,String secondDateTime,String pattern){
        DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
        try {
            LocalDateTime first_dateTime = LocalDateTime.parse(firstDateTime,df);
            LocalDateTime second_dateTime = LocalDateTime.parse(secondDateTime, df);
            long firstLong = first_dateTime.toInstant(ZoneOffset_Add_8).toEpochMilli();
            long secondLong = second_dateTime.toInstant(ZoneOffset_Add_8).toEpochMilli();
            return firstLong-secondLong;
        } catch (Exception e){
            try {
                LocalDate first_Date = LocalDate.parse(firstDateTime,df);
                LocalDate second_Date = LocalDate.parse(secondDateTime, df);
                Date date1 = Date.from(first_Date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant() );
                Date date2 = Date.from(second_Date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant() );
                return date1.getTime()-date2.getTime();
            } catch (Exception E){
                LocalTime first_time = LocalTime.parse(firstDateTime,df);
                LocalTime second_time = LocalTime.parse(secondDateTime, df);

                LocalDate localDate = LocalDate.now();
                LocalDateTime first_dateTime = LocalDateTime.of(localDate, first_time);
                LocalDateTime second_dateTime = LocalDateTime.of(localDate, second_time);

                Date date1 = Date.from( first_dateTime.atZone(ZoneId.systemDefault()).toInstant() );
                Date date2 = Date.from( second_dateTime.atZone(ZoneId.systemDefault()).toInstant() );
                return date1.getTime()-date2.getTime();
            }
        }
    }

    /**
     * 时间加减
     * @param dateTime 待处理时间
     * @param pattern 时间格式，特殊格式除外
     * @param parmNum 加减时间数
     * @param chronoUnit  加减时间域 （例如小时：ChronoUnit.HOURS）
     * @return 返回毫秒差值( firstDateTime - secondDateTime)
     */
    public static synchronized String addSubtractDateTime(String dateTime,String pattern,long parmNum,TemporalUnit chronoUnit){
        DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
        try {
            LocalDateTime date_time = LocalDateTime.parse(dateTime,df);
            return df.format(date_time.plus(parmNum, chronoUnit));
        }catch (Exception E){
            try {
                LocalDate date = LocalDate.parse(dateTime,df);
                return df.format( date.plus(parmNum, chronoUnit) );
            }catch (Exception e){
                LocalTime time = LocalTime.parse(dateTime,df);
                return df.format( time.plus(parmNum, chronoUnit)) ;
            }
        }
    }
    /**
     * 刻度时间转换毫秒，例如：input 1m , return 60000
     * @param dhmStr dhmStr
     * @return 返回毫秒值
     */
    public static synchronized long dhmToMill(String dhmStr) {
        if (dhmStr != null && !"".equals(dhmStr)) {
            int number = Integer.valueOf(CasiaRegexUtil.matchFirst(dhmStr,"^\\d+"));
            if (dhmStr.contains("d")) {
                return number * 86400000L;
            } else if (dhmStr.contains("h")) {
                return number * 3600000L;
            } else if (dhmStr.contains("m")) {
                return number * 60000L;
            } else if (dhmStr.contains("s")) {
                return number * 1000L;
            }
        }
        return 0L;
    }
    /**
     * 时间戳格式化为字符串，例如：input 1632273833625 , return 2021-09-22 09:23:53
     * @param currentTimeMillis 时间戳
     * @param pattern 格式
     * @return 返回毫秒值
     */
    public static synchronized String millToDhm(long currentTimeMillis,String pattern) {
        if (pattern != null && !"".equals(pattern)) {
            Date date = new Date(currentTimeMillis);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            return simpleDateFormat.format(date);
        }
        return null;
    }

    /**
     * 根据日期获取当天是周几
     * @param date 日期
     * @return 周几
     */
    public static synchronized String dateToWeek(Date date) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        return weekDays[w];
    }
    /**
     * 根据日期获取当天是周几
     * @param dateTime 时间
     * @param pattern 格式
     * @return 周几
     */
    public static synchronized String dateToWeek(String dateTime,String pattern) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            Date date = sdf.parse(dateTime);
            cal.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        return weekDays[w];
    }
    /**
     * 获取当前时间
     * @return 默认返回格式 YYYY-MM-dd 00:00:00
     */
    public static synchronized String getTodayZeroDate(){
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(YYYY_MM_dd_00_00_00);
        String format = ldt.format(dtf);
        return format;
    }
    /**
     * 获取当前时间
     * @return 默认返回格式 YYYY-MM-dd 00:00:00
     */
    public static synchronized String getTodayZeroDate(String dateTime){
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_dd);
        Date date = null;
        try {
            date = sdf.parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat sdf2 = new SimpleDateFormat(YYYY_MM_dd_00_00_00);
        return sdf2.format(date);
    }
    /**
     * 获取当前时间
     * @return 默认返回格式 YYYY-MM-dd 00:00:00
     */
    public static synchronized String getTodayZeroDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_dd_00_00_00);
        return sdf.format(date);
    }
}
