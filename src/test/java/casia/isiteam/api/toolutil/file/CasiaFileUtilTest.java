package casia.isiteam.api.toolutil.file;

import junit.framework.TestCase;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * ClassName: CasiaFileUtilTest
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/4/22
 * Email: zhiyou_wang@foxmail.com
 */
public class CasiaFileUtilTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testIsExists() {
        assertEquals(true, CasiaFileUtil.isExists("D:\\upload\\start\\test"));
    }

    public void testCreateDirectory() {
        assertEquals(true, CasiaFileUtil.createDirectory("D:\\upload\\start\\test"));
    }

    public void testCreateFile() {
        assertEquals(true, CasiaFileUtil.createFile("D:\\upload\\start\\test\\a.txt"));
    }

    public void testCreateDirectoryFile() {
        assertEquals(true, CasiaFileUtil.createDirectoryFile("D:\\upload\\start\\test\\测试文件夹\\a.txt"));
    }

    public void testCopy() {
        assertEquals(true, CasiaFileUtil.copy("D:\\upload\\start\\test\\a.txt","D:\\upload\\start\\test\\b.txt",false));
    }

    public void testMove() {
        assertEquals(true, CasiaFileUtil.move("D:\\upload\\start\\test\\a.txt","D:\\upload\\start\\test\\c.txt",false));
    }

    public void testDelete() {
        assertEquals(true, CasiaFileUtil.delete("D:\\upload\\start\\test\\a.txt"));
    }

    public void testDelete1() {
        assertEquals(true, CasiaFileUtil.delete(Arrays.asList("D:\\upload\\start\\test\\a.txt")));
    }

    public void testWrite() {
        assertEquals(true, CasiaFileUtil.write("D:\\upload\\start\\test\\b.lastIds","394",false));
    }

    public void testReadAllLines() {
        CasiaFileUtil.readAllLines("D:\\upload\\start\\test\\b.txt").stream().forEach(System.out::println);
    }

    public void testReadAllLines1() {
        CasiaFileUtil.readAllLines("D:\\upload\\start\\test\\b.txt", StandardCharsets.UTF_8).stream().forEach(System.out::println);
    }

    public void testReadAllBytes() {
        System.out.println(CasiaFileUtil.readAllBytes("D:\\upload\\start\\test\\b.txt"));
    }

    public void testReadAllBytes1() {
        System.out.println(CasiaFileUtil.readAllBytes("D:\\upload\\start\\test\\b.txt",StandardCharsets.UTF_8));
    }

    public void testReadAllFileName() {
        CasiaFileUtil.readAllFileName("D:\\upload\\start\\test\\").stream().forEach(System.out::println);
    }

    public void testReadAllFilePath() {
        CasiaFileUtil.readAllFilePath("D:\\upload\\start\\test\\").stream().forEach(System.out::println);
    }

    public void testReadAllDirectoryName() {
        CasiaFileUtil.readAllDirectoryName("D:\\upload\\start\\test\\").stream().forEach(System.out::println);
    }

    public void testReadAllDirectoryPath() {
        CasiaFileUtil.readAllDirectoryPath("D:\\upload\\start\\test\\").stream().forEach(System.out::println);
    }

    public void testReadAllPath() {
        CasiaFileUtil.readAllPath("D:\\upload\\start\\test\\").stream().forEach(System.out::println);
    }

    public void testReadAllName() {
        CasiaFileUtil.readAllName("D:\\upload\\start\\test\\").stream().forEach(System.out::println);
    }

    public void testReadAllDirectoryAndFilePath() {
        CasiaFileUtil.readAllDirectoryAndFilePath("D:\\upload\\start\\test\\").stream().forEach(System.out::println);
    }
}