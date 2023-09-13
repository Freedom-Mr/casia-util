package casia.isiteam.api.toolutil.secretKey.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.Base64;

/**
 * ClassName: CasiaBaseUtil
 * Description: Base加密、解密
 * <p>
 * Created by casia.wzy on 2020/4/29
 * Email: zhiyou_wang@foxmail.com
 */
public class CasiaBaseUtil {
    private static Logger logger = LoggerFactory.getLogger(CasiaBaseUtil.class);

    /**
     * 加密64
     * @param data byte[]
     * @return
     */
    public static String encrypt64(byte[] data){
        try {
            return (new BASE64Encoder()).encode(data);
        }catch (Exception E){
            logger.error("casia base64 encrypt error ! error:{}",E.getMessage());
            return "";
        }
    }
    public static String encrypt64_2(byte[] data) {
        try {
            return Base64.getEncoder().encodeToString(data);
        }catch (Exception E){
            logger.error("casia base64 encrypt error ! error:{}",E.getMessage());
            return "";
        }
    }
    /**
     * 加密64
     * @param data
     * @return
     */
    public static String encrypt64(String data){
        try {
            return (new BASE64Encoder()).encode(data.getBytes());
        }catch (Exception E){
            logger.error("casia base64 encrypt error ! error:{}",E.getMessage());
            return "";
        }
    }
    public static String encrypt64_2(String data) {
        try {
            return Base64.getEncoder().encodeToString(data.getBytes());
        }catch (Exception E){
            logger.error("casia base64 encrypt error ! error:{}",E.getMessage());
            return "";
        }
    }
    /**
     * 解码64
     * @param data
     * @return
     */
    public static String decrypt64(String data){
        try {
            byte[] bytes = ( new BASE64Decoder() ).decodeBuffer(data);
            return new String(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("casia base64 decrypt error ! error:{}",e.getMessage());
            return "";
        }
    }
    public static String decrypt64_2(String data){
        try {
            byte[] bytes =  Base64.getDecoder().decode(data.getBytes());
            return new String(bytes);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("casia base64 decrypt error ! error:{}",e.getMessage());
            return "";
        }
    }
    /**
     * 解码64
     * @param data
     * @return
     */
    public static byte[] decrypt64ToByte(String data){
        try {
            byte[] bytes = ( new BASE64Decoder() ).decodeBuffer(data);
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("casia base64 decrypt error ! error:{}",e.getMessage());
            return null;
        }
    }
    public static byte[] decrypt64ToByte_2(String data){
        try {
            byte[] bytes =  Base64.getDecoder().decode(data.getBytes());
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("casia base64 decrypt error ! error:{}",e.getMessage());
            return null;
        }
    }
}
