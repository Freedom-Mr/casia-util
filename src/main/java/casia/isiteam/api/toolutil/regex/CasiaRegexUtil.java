package casia.isiteam.api.toolutil.regex;

import casia.isiteam.api.toolutil.regex.format.MatchApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: CasiaRegexUtil
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/4/22
 * Email: zhiyou_wang@foxmail.com
 */
public class CasiaRegexUtil extends MatchApi {
    private static Logger logger = LoggerFactory.getLogger(CasiaRegexUtil.class);

    /**
     * 正则通用匹配,是否全部匹配
     * @param text 内容
     * @param regex 表达式
     * @return
     */
    public synchronized static boolean isAllMatch(String text, String regex) {
        try {
            if( text == null ){
                return false;
            }
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(text);
            return m.matches();
        } catch (Exception E){
            logger.error("match regex fail , error:{}",E.getMessage());
            return false;
        }
    }
    /**
     * 正则通用匹配,是否存在部分匹配
     * @param text 内容
     * @param regex 表达式
     * @return
     */
    public synchronized static boolean isPortionMatch(String text, String regex) {
        try {
            if( text == null ){
                return false;
            }
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(text);
            return m.find();
        } catch (Exception E){
            logger.error("match regex fail , error:{}",E.getMessage());
            return false;
        }
    }
}
