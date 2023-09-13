package casia.isiteam.api.toolutil.secretKey.ase;

import junit.framework.TestCase;

/**
 * ClassName: CasiaAesUtilTest
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/8/12
 * Email: zhiyou_wang@foxmail.com
 */
public class CasiaAesUtilTest extends TestCase {

    public static String content = "中国北京是我们的首都。";
    public static String aseKey = "abcdef0123456789";
    public void testEncrypt() {
        byte[] rs = CasiaAesUtil.encrypt(content,aseKey);
        String result = CasiaAesUtil.decrypt(rs,aseKey.getBytes());
        System.out.printf(result);
    }

}