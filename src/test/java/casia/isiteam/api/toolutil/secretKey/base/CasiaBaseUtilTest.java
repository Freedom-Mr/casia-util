package casia.isiteam.api.toolutil.secretKey.base;

import casia.isiteam.api.toolutil.secretKey.ase.CasiaAesUtil;
import junit.framework.TestCase;

/**
 * ClassName: CasiaBaseUtilTest
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/4/29
 * Email: zhiyou_wang@foxmail.com
 */
public class CasiaBaseUtilTest extends TestCase {

    public void testEncrypt64() {
        System.out.println(CasiaBaseUtil.encrypt64_2("{\n" +
                "  \"status\" : 200,\n" +
                "  \"message\" : \"请求成功！\",\n" +
                "  \"data\" : {\n" +
                "    \"user\" : {\n" +
                "      \"note\" : \"超级管理员\",\n" +
                "      \"unique_login\" : 15,\n" +
                "      \"user_id\" : 1,\n" +
                "      \"is_super\" : -1,\n" +
                "      \"real_name\" : \"超级管理员\",\n" +
                "      \"telephone\" : \"13021445423\",\n" +
                "      \"deadline\" : null,\n" +
                "      \"account\" : \"adminsuper\",\n" +
                "      \"email\" : \"3214214345@qq.com\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"timestamp\" : \"2021-03-08 18:03:03\"\n" +
                "}"));
    }

    public void testDecrypt64() {
        System.out.println(CasiaBaseUtil.decrypt64("PRoLT7Vv5Qc8xEVsLImp1Qf68hMtHT+7giTIPuvdXczNcLZR979aMFrcHp0f1GsU"));
        System.out.println(CasiaAesUtil.decrypt(CasiaBaseUtil.decrypt64ToByte("PRoLT7Vv5Qc8xEVsLImp1Qf68hMtHT+7giTIPuvdXczNcLZR979aMFrcHp0f1GsU"),"abcdef0123456789".getBytes()));
    }
}