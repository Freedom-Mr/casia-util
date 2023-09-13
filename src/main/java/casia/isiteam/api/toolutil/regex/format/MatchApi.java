package casia.isiteam.api.toolutil.regex.format;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: MatchApi
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/4/22
 * Email: zhiyou_wang@foxmail.com
 */
public class MatchApi {
    private static Logger logger = LoggerFactory.getLogger(MatchApi.class);


    /**
     * 正则通用匹配
     * @param text 内容
     * @param regex 表达式
     * @return
     */
    public synchronized static String matchFirst(String text, String regex) {
        try {
            if( text == null ){
                return null;
            }
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(text);
            if(m.find()) {
                return m.group();
            }
        } catch (Exception E){
            logger.error("match regex fail , error:{}",E.getMessage());
            return null;
        }
        return null;
    }
    /**
     * 正则通用匹配
     * @param text 内容
     * @param regex 表达式
     * @return
     */
    public synchronized static List<String> matchAll(String text, String regex) {
        List<String> result = new ArrayList<>();
        try {
            if( text == null ){
                return result;
            }
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(text);
            while(m.find()){
                result.add(m.group());
            }
        } catch (Exception E){
            logger.error("match regex fail , error:{}",E.getMessage());
            return result;
        }
        return result;
    }
    /**
     * 返回邮箱 -- 截取邮箱地址
     * @param text
     * @return
     */
    public synchronized static List<String> matchEmail(String text) {
        return matchAll(text,ExpressionApi.EAIL.getExpression());
    }
    /**
     * 返回邮箱类型 -- 截取邮箱地址@后的字符串
     * @param text
     * @return
     */
    public synchronized static String matchEmailType(String text) {
        return matchFirst(text,ExpressionApi.EAIL_TYPE.getExpression());
    }
    /**
     * 返回中文内容包含中文标点符号
     * @param text
     * @return
     */
    public synchronized static String matchChinese(String text) {
        StringBuffer sb = new StringBuffer();
        matchAll(text,ExpressionApi.CHINESE.getExpression()).forEach(s->{
            sb.append(s);
        });
        return sb.toString();
    }
    /**
     * 返回url
     * @param text
     * @return
     */
    public synchronized static List<String> matchUrl(String text) {
        return matchAll(text,ExpressionApi.URL.getExpression());
    }
    /**
     * 返回url
     * @param text
     * @return
     */
    public synchronized static List<String> matchIP(String text) {
        return matchAll(text,ExpressionApi.IP.getExpression());
    }
    /**
     * 返回CIDR
     * @param text
     * @return
     */
    public synchronized static List<String> matchCIDR(String text) {
        return matchAll(text,ExpressionApi.CIDR.getExpression());
    }
}
