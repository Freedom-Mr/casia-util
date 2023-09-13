package casia.isiteam.api.toolutil.regex;

import junit.framework.TestCase;

/**
 * ClassName: CasiaRegexUtilTest
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/4/22
 * Email: zhiyou_wang@foxmail.com
 */
public class CasiaRegexUtilTest extends TestCase {
    String line = "我的QQ是:456456 我的电话是:0532214 我的邮箱是:aaa123@aaa.com,m-all-forum-2020-01";
    String pattern = "\\d{4}-\\d{2}$";

    public void testMatchFirst() {
        System.out.println( CasiaRegexUtil.matchFirst(line,pattern) );
    }

    public void testMatchAll() {
       CasiaRegexUtil.matchAll(line,pattern).forEach(System.out::println);
    }

    public void testIsMatch() {
        System.out.println(CasiaRegexUtil.isAllMatch(line,pattern));
        System.out.println(CasiaRegexUtil.isPortionMatch(line,pattern));
    }

    public void testMatchEmail() {
        String text = "3303514@qq.com;155545121@souhu.com;1561561@qq.com";
        CasiaRegexUtil.matchEmail(text).forEach(System.out::println);
    }

    public void testMatchEmailType() {
        String text = "3303514@qq.com;";
        System.out.println(CasiaRegexUtil.matchEmailType(text));
    }

    public void testMatchChinese() {
        String text = "china北京《天安门》真漂亮.very good!！";
        System.out.println( CasiaRegexUtil.matchChinese(text));
    }

    public void testMatchUrl() {
        String text = "https://tool.oschina.net/regex/#   https://www.baidu.com/s?ie=UTF-8&wd=stream";
        CasiaRegexUtil.matchUrl(text).forEach(System.out::println);
    }

    public void testMatchIP() {
        String text = "https://15.41.234.1a.net/regex/#   https://www.baidu.com/s?ie=UTF-8&wd=stream15.41.234.2";
        CasiaRegexUtil.matchIP(text).forEach(System.out::println);
    }

    public void testMatchCIDR() {
        String text = "https://15.41.234.1a.net/regex/# 27.195.96.127/23  https:// 192.168.0.1/24www.baidu.com/s?ie=UTF-8&wd=stream15.41.234.2";
        CasiaRegexUtil.matchCIDR(text).forEach(System.out::println);
    }
}