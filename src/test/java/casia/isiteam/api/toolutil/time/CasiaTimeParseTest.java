package casia.isiteam.api.toolutil.time;

import junit.framework.TestCase;

/**
 * ClassName: CasiaTimeParseTest
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/4/22
 * Email: zhiyou_wang@foxmail.com
 */
public class CasiaTimeParseTest extends TestCase {

    public void testGetTime() {
        System.out.println(CasiaTimeParse.getTime("pm9"));
        System.out.println(CasiaTimeParse.getTime("前天21:05"));
    }

    public void testGetDate() {
        System.out.println(CasiaTimeParse.getDate("2010-01-31T09:13:00+00:00"));
    }

    public void testGetDateForCN() {
        System.out.println(CasiaTimeParse.getDateForCN("2010-01-31T09:13:00+00:00"));
    }

    public void testGetDateForEN() {
        System.out.println(CasiaTimeParse.getDateForEN(" By msoft 1year  10month, 13 day,9 hour, 0 minutes ago"));
    }

    public void testGetDateTime() {
        System.out.println(CasiaTimeParse.getDateTime("前天21:05"));
        System.out.println(CasiaTimeParse.getDateTime("2010-01-31T09:13:00+00:00"));
        System.out.println(CasiaTimeParse.getDateTime("Wed Mar 03 06:51:43 +0000 2010"));
        System.out.println(CasiaTimeParse.getDateTime("2009-1-1"));
        System.out.println(CasiaTimeParse.getDateTime("1587526273"));
        System.out.println(CasiaTimeParse.getDateTime("1587526273000"));
        System.out.println(CasiaTimeParse.getDateTime("01-07 07:58   通过客户端  "));
        System.out.println(CasiaTimeParse.getDateTime("Thu, 01 Apr 2019 04:48:00 GMT"));
        System.out.println(CasiaTimeParse.getDateTime("January 11, 2020 at 21:35"));
        System.out.println(CasiaTimeParse.getDateTime("8:31:11 PM"));
        System.out.println(CasiaTimeParse.getDateTime("13:20:30"));
        System.out.println(CasiaTimeParse.getDateTime("10 hours ago / Thu, Jan 14, 2010 - 12:04 PM / 0 comment"));
        System.out.println(CasiaTimeParse.getDateTime("By happy24n7  15 hours, 13 minutes ago in Petaling Jaya Add Comment"));
        System.out.println(CasiaTimeParse.getDateTime("  几秒前   from web   "));
        System.out.println(CasiaTimeParse.getDateTime("  (11:22)   "));
        System.out.println(CasiaTimeParse.getDateTime("2021-01"));
        System.out.println(CasiaTimeParse.getDateTime("202102"));

    }

    public void testToChineseTime() {
        String date = "Thu, 01 Apr 2019 04:48:00 GMT";
        String parseDate = CasiaTimeParse.getDateTime(date);
        System.out.println(CasiaTimeParse.toChineseTime(parseDate,date));
    }

    public void testValidate() {

        System.out.println(CasiaTimeParse.validate("2020-02-31 00:00:00"));
    }
}