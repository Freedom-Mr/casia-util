package casia.isiteam.api.toolutil.time;

import junit.framework.TestCase;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * @ClassName: CasiaTimeTraverseTest
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2021/9/22
 * Email: zhiyou_wang@foxmail.com
 */
public class CasiaTimeTraverseTest extends TestCase {
    public void testTraverseDateStr() {
        System.out.println(CasiaTimeTraverse.traverseDateStrToStr("all-s-blog-","2022-05-22 15:01:12","2022-05-22 15:15:12",CasiaTimeFormat.YYYY_MM,"*"));
//        System.out.println(CasiaTimeTraverse.traverseDateStrToStr("blog-",3,CasiaTimeFormat.YYYY_MM_dd,"*"));
        System.out.println(CasiaTimeTraverse.traverseDateStrToStr(Arrays.asList("blog-","news-"),3,CasiaTimeFormat.YYYY_MM_dd,"*"));
    }
    public void testTraverseDateStrToStr() {
    }

}