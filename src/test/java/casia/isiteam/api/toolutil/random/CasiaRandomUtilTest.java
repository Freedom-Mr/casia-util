package casia.isiteam.api.toolutil.random;

import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: CasiaRandomUtilTest
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/4/29
 * Email: zhiyou_wang@foxmail.com
 */
public class CasiaRandomUtilTest extends TestCase {
    private Logger logger = LoggerFactory.getLogger(CasiaRandomUtilTest.class);
    public void testRandomNumber() {
        for(int i=0;i<20;i++){
            logger.info(CasiaRandomUtil.randomNumber(1,3)+"");
            System.out.println("\t");
        }
    }

    public void testRandomNumber1() {
        List<Object> parms = new ArrayList<>();
        parms.add("192.168.10.1:1302");
        parms.add("192.168.10.1:1303");
        parms.add("192.168.10.1:1301");
        for(int i=0;i<10;i++){
            CasiaRandomUtil.randomNumber(parms,2).forEach(System.out::print);
            System.out.println("\t");
        }

    }

    public void testRandomNumber2() {
        for(int i=0;i<10;i++){
            Object[]  results = CasiaRandomUtil.randomNumber(2,"192.168.10.1:1302","192.168.10.1:1303","192.168.10.1:1301");
            for(Object s:results){
                System.out.print(s.toString()+"\t");
            }
            System.out.println();
        }
    }
}