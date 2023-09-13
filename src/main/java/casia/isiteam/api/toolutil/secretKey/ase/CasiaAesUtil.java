package casia.isiteam.api.toolutil.secretKey.ase;

import casia.isiteam.api.toolutil.Validator;
import casia.isiteam.api.toolutil.secretKey.base.CasiaBaseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

/**
 * ClassName: CasiaAesUtil
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/8/12
 * Email: zhiyou_wang@foxmail.com
 */
public class CasiaAesUtil {
    private static Logger logger = LoggerFactory.getLogger(CasiaAesUtil.class);
    //参数分别代表 算法名称/加密模式/数据填充方式
    private static final String ALGORITHMSTR = "AES/CBC/PKCS5Padding";

    /**
     * AES 加密
     * @param content 加密内容
     * @param aesKey 秘钥
     * @return
     */
    public static synchronized byte[] encrypt(String content, String aesKey ) {
        if(!Validator.check(content) ){
            logger.error("parameter: content is empty!");
            return null;
        }
        return  encrypt(content.getBytes(), aesKey.getBytes() ) ;
    }
    /**
     * AES 加密
     * @param content 加密内容 byte
     * @param aesKeyBytes 秘钥 byte
     * @return
     */
    public static synchronized byte[] encrypt(byte[] content, byte[] aesKeyBytes) {
        try {
            if(!Validator.check(content) ){
                logger.error("parameter: content is empty!");
                return null;
            }
            SecretKeySpec key = new SecretKeySpec(aesKeyBytes, "AES");
            Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
            cipher.init(Cipher.ENCRYPT_MODE,key, new IvParameterSpec(aesKeyBytes));
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (Exception e) {
            logger.error("加密：exception:{}",e.toString());
        }
        return null;
    }
    /**
     * AES 解密
     * @param content 解密内容
     * @param aesKey 秘钥
     * @return
     */
    public static synchronized String decrypt(String content, String aesKey) {
        if(!Validator.check(content) ){
            logger.error("parameter: content is empty!");
            return null;
        }
        return decrypt(content.getBytes(),aesKey.getBytes());
    }
    /**
     * AES 解密
     * @param content 解密内容 byte
     * @param aesKeyBytes 秘钥 byte
     * @return
     */
    public static synchronized String decrypt(byte[] content, byte[] aesKeyBytes) {
        try {
            if(!Validator.check(content) ){
                logger.error("parameter: content is empty!");
                return null;
            }
            SecretKeySpec key = new SecretKeySpec(aesKeyBytes, "AES");
            Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
            cipher.init(Cipher.DECRYPT_MODE,key, new IvParameterSpec(aesKeyBytes));
            byte[] result = cipher.doFinal(content);
            return new String(result);
        } catch (NoSuchAlgorithmException e) {
            logger.error("解密：exception:{}", e.getMessage());
        } catch (Exception e) {
            logger.error("解密：exception:{}", e.getMessage());
        }
        return null;
    }

}
