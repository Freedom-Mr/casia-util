package casia.isiteam.api.toolutil.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @ClassName: CasiaTimeTraverse
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2021/9/22
 * Email: zhiyou_wang@foxmail.com
 */
public class CasiaTimeTraverse extends CasiaTimeFormat{
    /**
     * 生成多个日期
     * @param prefix 每个结果前缀
     * @param startDateTime 开始时间
     * @param endDateTime 结束时间
     * @param format    返回结果格式化，例如：2021-01-22
     * @param postfix    每个结果后缀
     * @return 返回数组
     */
    public static synchronized Set<String> traverseDateStrToSet(String prefix, String startDateTime, String endDateTime, String format, String postfix) {
        startDateTime  = CasiaTimeParse.getDateTime(startDateTime);
        endDateTime  = CasiaTimeParse.getDateTime(endDateTime);

        LocalDateTime start_dateTime = LocalDateTime.parse(startDateTime, DateTimeFormatter.ofPattern(YYYY_MM_dd_HH_mm_ss));
        LocalDateTime end_dateTime = LocalDateTime.parse(endDateTime,DateTimeFormatter.ofPattern(YYYY_MM_dd_HH_mm_ss));
        long numOfDaysBetween = ChronoUnit.HOURS.between(start_dateTime, end_dateTime);
        numOfDaysBetween = numOfDaysBetween==0?1:numOfDaysBetween;
        Set<String> sets = IntStream.iterate(0, i -> i + 1) .limit(numOfDaysBetween).mapToObj(i ->
                prefix+(start_dateTime.plusHours(i).format(DateTimeFormatter.ofPattern(format)))+postfix
        ).collect(Collectors.toSet());
        return sets;
    }
    /**
     * 生成多个日期
     * @param prefix 每个结果前缀
     * @param startDateTime 开始时间
     * @param endDateTime 结束时间
     * @param format    返回结果格式化，例如：2021-01-22
     * @param postfix    每个结果后缀
     * @return 返回数组
     */
    public static synchronized Set<String> traverseDateStrToSet(List<String> prefix,String startDateTime,String endDateTime,String format,String postfix) {
        Set<String> sets = new LinkedHashSet<>();
        prefix.forEach(k->{
            Set<String> result =traverseDateStrToSet(k,startDateTime,endDateTime,format,postfix);
            sets.addAll(result);
        });
        return sets;
    }
    /**
     * 生成多个日期
     * @param prefix 每个结果前缀
     * @param startDateTime 开始时间
     * @param endDateTime 结束时间
     * @param format    返回结果格式化，例如：2021-01-22
     * @param postfix    每个结果后缀
     * @return 返回字符串
     */
    public static synchronized String traverseDateStrToStr(String prefix,String startDateTime,String endDateTime,String format,String postfix) {
        Set<String> sets =traverseDateStrToSet(prefix,startDateTime,endDateTime,format,postfix);
        StringBuffer stringBuffer = new StringBuffer();
        sets.forEach(s->{
            stringBuffer.append(stringBuffer.length()>0?","+s:s);
        });
        return stringBuffer.toString();
    }
    /**
     * 生成多个日期
     * @param prefix 每个结果前缀
     * @param startDateTime 开始时间
     * @param endDateTime 结束时间
     * @param format    返回结果格式化，例如：2021-01-22
     * @param postfix    每个结果后缀
     * @return 返回字符串
     */
    public static synchronized String traverseDateStrToStr(List<String> prefix,String startDateTime,String endDateTime,String format,String postfix) {
        StringBuffer stringBuffer = new StringBuffer();
        prefix.forEach(k->{
            Set<String> sets =traverseDateStrToSet(k,startDateTime,endDateTime,format,postfix);
            sets.forEach(s->{
                stringBuffer.append(stringBuffer.length()>0?","+s:s);
            });
        });
        return stringBuffer.toString();
    }
    /**
     * 生成多个日期
     * @param prefix 每个结果前缀
     * @param timeGranularity 时间粒度： 0-今天，1-24小时，2-2天 3-3天，N-N天，
     * @param format    返回结果格式化，例如：2021-01-22
     * @param postfix    每个结果后缀
     * @return 返回字符串
     */
    public static synchronized String traverseDateStrToStr(String prefix,int timeGranularity,String format,String postfix) {
        StringBuffer stringBuffer = new StringBuffer();
        String endTime = CasiaTimeUtil.getNowDateTime();
        String startTime = timeGranularity>0? CasiaTimeUtil.addSubtractDateTime(endTime,CasiaTimeFormat.YYYY_MM_dd_HH_mm_ss,-timeGranularity, ChronoUnit.DAYS) :
                CasiaTimeUtil.getNowDateTime(YYYY_MM_dd)+" 00:00:00";
        Set<String> sets =traverseDateStrToSet(prefix,startTime,endTime,format,postfix);
        sets.forEach(s->{
            stringBuffer.append(stringBuffer.length()>0?","+s:s);
        });
        return stringBuffer.toString();
    }
    /**
     * 生成多个日期
     * @param prefix 每个结果前缀
     * @param timeGranularity 时间粒度： 0-今天，1-24小时，2-2天 3-3天，N-N天，
     * @param format    返回结果格式化，例如：2021-01-22
     * @param postfix    每个结果后缀
     * @return 返回字符串
     */
    public static synchronized String traverseDateStrToStr(List<String> prefix,int timeGranularity,String format,String postfix) {
        StringBuffer stringBuffer = new StringBuffer();
        prefix.forEach(k->{
            String endTime = CasiaTimeUtil.getNowDateTime();
            String startTime = timeGranularity>0? CasiaTimeUtil.addSubtractDateTime(endTime,CasiaTimeFormat.YYYY_MM_dd_HH_mm_ss,-timeGranularity, ChronoUnit.DAYS) :
                    CasiaTimeUtil.getNowDateTime(YYYY_MM_dd)+" 00:00:00";
            Set<String> sets =traverseDateStrToSet(k,startTime,endTime,format,postfix);
            sets.forEach(s->{
                stringBuffer.append(stringBuffer.length()>0?","+s:s);
            });
        });
        return stringBuffer.toString();
    }
    public static synchronized Set<String> traverseDateStrToSet(List<String> prefix,int timeGranularity,String format,String postfix) {
        Set<String> result = new LinkedHashSet<>();
        prefix.forEach(k->{
            String endTime = CasiaTimeUtil.getNowDateTime();
            String startTime = timeGranularity>0? CasiaTimeUtil.addSubtractDateTime(endTime,CasiaTimeFormat.YYYY_MM_dd_HH_mm_ss,-timeGranularity, ChronoUnit.DAYS) :
                    CasiaTimeUtil.getNowDateTime(YYYY_MM_dd)+" 00:00:00";
            Set<String> sets =traverseDateStrToSet(k,startTime,endTime,format,postfix);
            result.addAll(sets);
        });
        return result;
    }
}
