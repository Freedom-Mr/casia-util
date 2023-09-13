package casia.isiteam.api.toolutil.time;

import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * ClassName: CasiaTimeFormat
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/4/22
 * Email: zhiyou_wang@foxmail.com
 */
public class CasiaTimeFormat {

    final static ZoneId ZONEID_BJ = ZoneId.of("GMT+08:00");
    final static ZoneOffset ZoneOffset_Add_8 = ZoneOffset.of("+8");

    public final static String YYYY = "yyyy";
    public final static String YYYY_MM = "yyyy-MM";
    public final static String YYYY_MM_dd = "yyyy-MM-dd";
    public final static String YYYY_MM_dd_HH = "yyyy-MM-dd HH";
    public final static String YYYY_MM_dd_HH_mm = "yyyy-MM-dd HH:mm";
    public final static String YYYY_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
    public final static String YYYY_MM_dd_00_00_00 = "yyyy-MM-dd 00:00:00";

    public final static String MM = "MM";
    public final static String MM_dd = "MM-dd";

    public final static String HH = "HH";
    public final static String HH_mm = "HH:mm";
    public final static String HH_mm_ss = "HH:mm:ss";

    public final static String mm_ss = "MM:ss";

    public final static String ss = "ss";

    public final static String YYYYMM = "yyyyMM";
    public final static String YYYYMMdd = "yyyyMMdd";
    public final static String YYYYMMddHH = "yyyyMMddHH";
    public final static String YYYYMMddHHmm = "yyyyMMddHHmm";
    public final static String YYYYMMddHHmmss = "yyyyMMddHHmmss";

    public final static String MMdd = "MMdd";

    public  final static String HHmm = "HHmm";
    public final static String HHmmss = "HHmmss";

    public final static String mmss = "mmss";
}
