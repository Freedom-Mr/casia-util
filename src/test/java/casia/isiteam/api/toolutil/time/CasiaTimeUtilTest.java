package casia.isiteam.api.toolutil.time;

import junit.framework.TestCase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * ClassName: CasiaTimeUtilTest
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/4/24
 * Email: zhiyou_wang@foxmail.com
 */
public class CasiaTimeUtilTest extends TestCase {

    public void testGetNowDateTime1() {
        System.out.println(CasiaTimeUtil.getNowDateTime());
    }

    public void testGetNowDateTime() {
        System.out.println(CasiaTimeUtil.getNowDateTime(CasiaTimeFormat.YYYY_MM_dd_HH_mm_ss));
        System.out.println(CasiaTimeUtil.getNowDateTime(CasiaTimeFormat.YYYY_MM_dd_HH));
        System.out.println(CasiaTimeUtil.getNowDateTime(CasiaTimeFormat.YYYY_MM_dd));
        System.out.println(CasiaTimeUtil.getNowDateTime(CasiaTimeFormat.HH_mm_ss));
    }

    public void testDateTimeToString() {
        Date date = new Date();
        System.out.println(CasiaTimeUtil.dateTimeToString(date,CasiaTimeFormat.YYYY_MM_dd_HH_mm_ss) );
        System.out.println(CasiaTimeUtil.dateTimeToString(date,CasiaTimeFormat.YYYY_MM_dd_HH) );
        System.out.println(CasiaTimeUtil.dateTimeToString(date,CasiaTimeFormat.YYYY_MM_dd) );
        System.out.println(CasiaTimeUtil.dateTimeToString(date,CasiaTimeFormat.HH_mm_ss) );
    }

    public void testTransafeDateTime() {
        System.out.println(CasiaTimeUtil.transafeDateTime("2020-04-26 09:51:21",CasiaTimeUtil.YYYY_MM_dd_HH_mm_ss,CasiaTimeFormat.YYYY_MM_dd_HH) );
        System.out.println(CasiaTimeUtil.transafeDateTime("2020-04-26",CasiaTimeUtil.YYYY_MM_dd,CasiaTimeFormat.YYYY_MM_dd_HH_mm_ss) );
        System.out.println(CasiaTimeUtil.transafeDateTime("09:51:21",CasiaTimeUtil.HH_mm_ss,CasiaTimeFormat.YYYY_MM_dd_HH) );
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(CasiaTimeFormat.YYYYMM);
        try {
            Date date= simpleDateFormat.parse("202101");
            System.out.println(CasiaTimeUtil.dateTimeToString(date,CasiaTimeFormat.YYYY_MM_dd));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void testCompareToDateTime() {
        System.out.println(CasiaTimeUtil.compareToDateTime("2020-04-26 09:51:21","2020-04-26 09:53:21",CasiaTimeFormat.YYYY_MM_dd_HH_mm_ss));
        System.out.println(CasiaTimeUtil.compareToDateTime("2020-04-26 09","2020-04-26 07",CasiaTimeFormat.YYYY_MM_dd_HH));
        System.out.println(CasiaTimeUtil.compareToDateTime("2020-04-27","2020-04-26",CasiaTimeFormat.YYYY_MM_dd));
        System.out.println(CasiaTimeUtil.compareToDateTime("09:51:21","09:53:21",CasiaTimeFormat.HH_mm_ss));
    }

    public void testAddSubtractDateTime() {
        System.out.println(CasiaTimeUtil.addSubtractDateTime("2020-04-26 09:51:21",CasiaTimeFormat.YYYY_MM_dd_HH_mm_ss,2, ChronoUnit.HOURS));
        System.out.println(CasiaTimeUtil.addSubtractDateTime("2020-04-26 09:51:21",CasiaTimeFormat.YYYY_MM_dd_HH_mm_ss,-1, ChronoUnit.DAYS));
        System.out.println(CasiaTimeUtil.addSubtractDateTime("2020-04-26",CasiaTimeFormat.YYYY_MM_dd,2, ChronoUnit.MONTHS));
        System.out.println(CasiaTimeUtil.addSubtractDateTime("09:51:21",CasiaTimeFormat.HH_mm_ss,20, ChronoUnit.MINUTES));
    }


    public void testDhmToMill() {
        System.out.println(CasiaTimeUtil.dhmToMill("1d"));
        System.out.println(CasiaTimeUtil.dhmToMill("2h"));
        System.out.println(CasiaTimeUtil.dhmToMill("3m"));
    }


    public void testDateToWeek() {
        System.out.println(CasiaTimeUtil.dateToWeek(new Date()));
        System.out.println(CasiaTimeUtil.dateToWeek("2022-02-28",CasiaTimeFormat.YYYY_MM_dd));
        System.out.println(CasiaTimeUtil.dateToWeek("2022-02-28 11:00:11",CasiaTimeFormat.YYYY_MM_dd_HH_mm_ss));
    }

    public void testGetTodayZeroDate() {
        System.out.println(CasiaTimeUtil.getTodayZeroDate(new Date()));
        System.out.println(CasiaTimeUtil.getTodayZeroDate());
        System.out.println(CasiaTimeUtil.getTodayZeroDate("2022-02-28"));
    }


}