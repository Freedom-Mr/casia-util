package casia.isiteam.api.toolutil;

import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClassName: LoggerTest
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/4/26
 * Email: zhiyou_wang@foxmail.com
 */
public class LoggerTest extends TestCase {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public void testCheck() {
        logger.debug("debug");
        logger.info("info");
        logger.warn("warning");
        logger.error("error");
    }
}
