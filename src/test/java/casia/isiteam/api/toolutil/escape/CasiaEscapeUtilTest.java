package casia.isiteam.api.toolutil.escape;

import junit.framework.TestCase;

/**
 * ClassName: CasiaEscapeUtilTest
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/6/12
 * Email: zhiyou_wang@foxmail.com
 */
public class CasiaEscapeUtilTest extends TestCase {

    public void testUrlDecode() {
        String url = "select%20*%20from%20test%20where%20eid%20%3D687%20and%20pubtime%20%3E%3D%272020-05-09%2008%3A35%3A12%27%20order%20by%20pubtime%20asc";
        System.out.println(CasiaEscapeUtil.urlDecode(url));
    }

    public void testUrlEscape() {
        String url = "select title from test where title = matchQuery('香港 抗议') ORDER BY _score DESC LIMIT 3";
        System.out.println(CasiaEscapeUtil.urlEscape(url));
    }

    public void testUrlBlankEscape() {
    }

    public void testLuceneQueryStringEscape() {
    }

    public void testNeo4jEscape() {
    }
}