package casia.isiteam.api.toolutil.secretKey.os;

import casia.isiteam.api.toolutil.Validator;
import casia.isiteam.api.toolutil.secretKey.base.CasiaBaseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName: OsKeyUtil
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2021/3/8
 * Email: zhiyou_wang@foxmail.com
 */
public class CasiaOsKeyUtil {
    private static Logger logger = LoggerFactory.getLogger(CasiaOsKeyUtil.class);
    private static final String ALGORITHMSTR = "AES/CBC/PKCS5Padding";
    public static synchronized String encrypt(String content)  {
        if( !Validator.check(content) ){ return content; }
        return CasiaBaseUtil.encrypt64_2( encrypt(content.getBytes(), KEY.getBytes(), IV.getBytes()) );
    }
    public static synchronized String encrypt(String content,String KEY,String IV)  {
        if( !Validator.check(content) ){ return content; }
        return CasiaBaseUtil.encrypt64_2( encrypt(content.getBytes(), KEY.getBytes(), IV.getBytes()) );
    }
    private static synchronized byte[] encrypt(byte[] content, byte[] keyBytes, byte[] iv) {
        try {
            SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
            cipher.init(Cipher.ENCRYPT_MODE,key, new IvParameterSpec(iv));
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (Exception e) {
            logger.error("加密：exception:{}",e.toString());
        }
        return null;
    }
    private static final String KEY = "abcdef0123456789";
    public static synchronized String decrypt(String content,String KEY,String IV)  {
        byte[] rs = decrypt( content, KEY.getBytes(), IV.getBytes() );
        return new String(rs);
    }
    public static synchronized String decrypt(String content) {
        byte[] rs = decrypt( content, KEY.getBytes(), IV.getBytes() );
        return new String(rs);
    }
    private static synchronized byte[] decrypt(String content, byte[] keyBytes, byte[] iv) {
        try {
            SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
            cipher.init(Cipher.DECRYPT_MODE,key, new IvParameterSpec(iv));
            byte[] result = cipher.doFinal( CasiaBaseUtil.decrypt64ToByte_2(content) );
            return result;
        } catch (NoSuchAlgorithmException e) {
            logger.error("解密：exception:{}", e.getMessage());
        } catch (Exception e) {
            logger.error("解密：exception:{}", e.getMessage());
        }
        return null;
    }
    private static final String IV = "abcdef0123456789";
}
