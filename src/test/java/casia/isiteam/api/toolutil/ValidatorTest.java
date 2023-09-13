package casia.isiteam.api.toolutil;

import casia.isiteam.api.toolutil.file.CasiaFileUtil;
import junit.framework.TestCase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: ValidatorTest
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/4/22
 * Email: zhiyou_wang@foxmail.com
 */
public class ValidatorTest extends TestCase {

    public void testCheck() {
//        assertEquals(false,Validator.check(Arrays.asList()));
        CasiaFileUtil casiaFileUtil = new CasiaFileUtil();
        Object a = casiaFileUtil;
        System.out.println(Validator.check(casiaFileUtil));
    }
}