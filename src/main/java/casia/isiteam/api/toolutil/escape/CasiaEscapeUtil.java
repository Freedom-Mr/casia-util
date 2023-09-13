package casia.isiteam.api.toolutil.escape;

import casia.isiteam.api.toolutil.Validator;

import javax.script.*;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: CasiaEscapeUtil
 * Description: 转义
 * <p>
 * Created by casia.wzy on 2020/6/12
 * Email: zhiyou_wang@foxmail.com
 */
public class CasiaEscapeUtil {

    /**
     * url 反转义
     * @param url
     * @return
     */
    public static String urlDecode(String url){
        return urlDecode(url,"UTF-8");
    }
    public static String urlDecode(String url,String enc){
        try {
            return  Validator.check(url) ? URLDecoder.decode(url,enc) : url;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return url;
        }
    }
    /**
     * url 转义
     * @param url
     * @return
     */
    public static String urlEscape(String url){
        if (!Validator.check(url)) {
            return url;
        }
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
        String options = "function getdata(url){ return encodeURI(url) } getdata(url);";
        Compilable compilable = (Compilable) engine;
        CompiledScript JSFunction;
        try {
            JSFunction = compilable.compile(options);
            Bindings bindings = engine.createBindings();
            bindings.put("url", url);
            Object result = JSFunction.eval(bindings);
            return String.valueOf(result);
        } catch (ScriptException e) {
            e.printStackTrace();
            return url;
        }
    }
    /**
     * url 空格转义
     * @param input
     * @return
     */
    public static String urlBlankEscape(String input){
        return input!=null? input.replaceAll("\\s", "%20") : null;
    }
    /**
     *
     * lucene 特殊字符转义处理
     * @param input
     * @return
     */
    public static String luceneQueryStringEscape(String input){
        StringBuffer sb = new StringBuffer();
        //String regex = "[+\\-&|!(){}\\[\\]^\"~*?:(\\)]";
        //去掉*号，用于模糊匹配
        String regex = "[+\\-&|!(){}\\[\\]^\"~?:(\\)]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()){
            matcher.appendReplacement(sb, "\\\\"+matcher.group());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * @param
     * @return
     * @Description: TODO(替换影响数据入库的特殊字符)
     */
    public static Object neo4jEscape(Object object) {

        if (object instanceof String) {
            String entityName = (String) object;
            if (entityName != null) {

                // 先替换反斜杠
                entityName = entityName.replace("\\", "\\\\");

                // 再替换单引号
                entityName = entityName.replace("'", "\\'");

                // 再替换双引号
                entityName =entityName.replace("\"", "\\\"");
                return entityName;
            } else {
                return object;
            }
        } else {
            return object;
        }
    }


}
