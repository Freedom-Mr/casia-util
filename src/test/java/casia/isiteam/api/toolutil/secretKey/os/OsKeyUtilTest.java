package casia.isiteam.api.toolutil.secretKey.os;

import junit.framework.TestCase;

/**
 * @ClassName: OsKeyUtilTest
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2021/3/8
 * Email: zhiyou_wang@foxmail.com
 */
public class OsKeyUtilTest extends TestCase {

    public void testEncrypt() {
        System.out.println(CasiaOsKeyUtil.encrypt("{\n" +
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

    public void testDecrypt() {
        System.out.println(CasiaOsKeyUtil.decrypt("mUE1mcXMq+JFyrk2s5/MhYAbAziFoISI0U2jZAUyoiaLdhk+BmaQJhDPv8kue3V3/NgZZ/xskjbLuhrSb/1hAsFKHMZckhPP0CZLzY+RQLJm2yKeWClVFMu3pugliCHInrYkpKuS/p2hZNhXhn5hpjZZInXOqcRhLYRnaAfFWPY7wkJDciA2/g9Q9DLZ5nk8oBWO8UekNLEPS3RrzzG2KfLPm7t6UnvAn1s25rw5HkaEGsHUyqd4LiX63ilUtExdWlFGNfRQgJfLth0eU2VeL9nDd/i29IaI78/mUNLhptPDrccG8miar6jatC3YGc9dNR4czjMGhpfiREJ7CsqFvA2xJ0Rvkck50ByMlj53AhslxB0jY0RFALFPI9FsU88lNUMOjhh/UKovYEdi5kXTGSqskOpHa1X7rzSE8oIixfa0vV+NPc3bqgaOYRm4Q/sk6gwGqeoECeckXRmS2a43wiI4I1yt/2Wow/o0WQvGNAEB2eVP3txTAIxt0iesqwTDQH1ja5VkeUqgfTqHBuJEYOud6rVqX5IZ8gWAXA1PzExlvmljJAQeT6MDnMTSgEkodtuKRxswvKzsWWxmWCbpajLTLDJ0DYtHdiZ33Q2ZdCE7XwPMS9yb8fABu+fmaMTWmJ5uQbi9OFhCIYooR6bvkJLf9nkGNAnzOmD9P/5njJ7QLO5DIFSVcYbyAu2LUlFoxG2/f5W8904El6pxxkaX5UeWqpCes+VZIO0Ej6niIIJTdKcjlX/layWoGi5yH3ILwfjqIIFv4nP3tbe85XJETTuVZ6DzApkvSJhI2j0WHZZAuI9rvdENbCjbUozdp+XvU0+Hx3Jk4+PcjYTWuqDv3SKmbQ+oHXrtKTTbRa1/n8KaldpJHcCt6D3k/uXLHI7l/JvuS2bAyBD2679hOX/G6Nx04KI3HFVUa647X1DX2jAPsSkK/qoUKCyYqrHMsJTpGBYfjM/MbU/9XbB7dhADPzFBir1X2DMXmNKLi2nPkfVtziZUcKzOu6zrFcIONArfjxjYsPzMEDAmhnfg2MIexv0jWtYOXPi5rbl4Eaz9tgVWqNwuPm2a55H8d4FtsomNLg+UjY+GY7+UTYrloJeZ2HztF3ew3SZcNUfehHjApPbHIIfghpuwYsu3oYZ68cqGTBDrjHYWCdBJKx/M3U+HznL7VEqW/fuIBQOZtgQX5ExjEyO6PfLx0jUuvaq9fbAwAbyEPg4SoMquYld+8PVm1wkFBYH52qjzNt960DZBUApHET1cYmsGkX5OpZpLhG6bHXireFjeAzoPrObd81dmNXmBhlIgaVFILwV11KsHqkJg8bgdhv5jJNyeGPUJCD2k5yZ8Ps/BWlsOpOfU/svUvb3p92+aL0BUfIbhV9+Ra//kZ8eB07GUKzjy+KzB4yttHI9sFREN3onqg1KhxpgSa56mGvNFq1LiOHcVZCRXxajA1IwGgaMDHu2xnUdfrFnPK52xLdOIwtwMoUD66WSb017xlY5tG6Gj72ktXCa8DH+tu/tcbVyXRk2HGkDA5ptsEb7hdccKAkFqVoY5H7QdBlJ35/GFnthC0iagE4MqL3Ty2KZuxtlkBpgbZxak8iRfcwCNIZxEFEIfUSp6fCo58w+44YWWv5TynPOq9Ke1QbD1ZE9tlkHKToEtLxnCcS5q99HGqvWBLNadLVxwS0JZ8QqATmZ1sB46c5siOLGCdko="));
    }
}