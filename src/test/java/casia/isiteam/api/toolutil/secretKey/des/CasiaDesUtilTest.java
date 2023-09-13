package casia.isiteam.api.toolutil.secretKey.des;

import junit.framework.TestCase;

/**
 * ClassName: CasiaDesUtilTest
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/4/29
 * Email: zhiyou_wang@foxmail.com
 */
public class CasiaDesUtilTest extends TestCase {

    public void testEncrypt() {
        System.out.println(CasiaDesUtil.encrypt("webdev1","is79rgs9NIYmRtDvtYyGv09DcBCM8hZ/"));
    }

    public void testDecrypt() {
        System.out.println(CasiaDesUtil.decrypt(CasiaDesUtil.encrypt("webdev1","is79rgs9NIYmRtDvtYyGv09DcBCM8hZ/"),"is79rgs9NIYmRtDvtYyGv09DcBCM8hZ/"));
    }
}