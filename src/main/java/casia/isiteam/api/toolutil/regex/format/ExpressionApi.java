package casia.isiteam.api.toolutil.regex.format;

/**
 * ClassName: ExpressionApi
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/4/26
 * Email: zhiyou_wang@foxmail.com
 */
public enum  ExpressionApi {

    /**
     * 邮箱
     */
    EAIL("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?"),
    EAIL_TYPE("\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+"),

    /**
     * 中文
     */
    CHINESE("([\u4E00-\u9FA5]|[\uFE30-\uFFA0])+"),

    /**
     * url
     */
    URL("[a-zA-z]+://[^\\s]*"),
    /**
     * IP
     */
    IP("((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}"),
    /**
     * CIDR
     */
    CIDR("(?:(?:[0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}(?:[0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\/(3[0-2]|[1-2][1-9]||[1-9]|[1-2]\\d)")
    ;

    private final String expression;

    private ExpressionApi(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return "ExpressionApi{" +
                "expression='" + expression + '\'' +
                '}';
    }

}
