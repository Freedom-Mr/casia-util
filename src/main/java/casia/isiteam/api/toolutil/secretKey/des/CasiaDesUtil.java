package casia.isiteam.api.toolutil.secretKey.des;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.Key;
import java.security.SecureRandom;

/**
 * ClassName: CasiaDesUtil
 * Description: DES加密、解密
 * <p>
 * Created by casia.wzy on 2020/4/29
 * Email: zhiyou_wang@foxmail.com
 */
public class CasiaDesUtil {
    private static Logger logger = LoggerFactory.getLogger(CasiaDesUtil.class);

    private static final String ALGORITHM = "DES";
    private static final String NEBULA_SSOAUTH_TICKET_KEY = "is79rgs9NIYmRtDvtYyGv09DcBCM8hZ/";
    public static final String CHAR_SET = "UTF-8";
    public static final String DATA_SEPERATOR = "\t";

    /**
     * des加密
     * @param data 加密内容
     * @param key 秘钥
     * @return String
     */
    public static String encrypt(String data, String key) {
        try{
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(key.getBytes());
            //创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
            SecretKey securekey = keyFactory.generateSecret(desKey);
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            //用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            //现在，获取数据并加密
            //正式执行加密操作
            byte[] result = cipher.doFinal(data.getBytes());
            return new String(result);
        }catch(Throwable e){
            e.printStackTrace();
            logger.error("casia des encrypt error ! error:{}",e.getMessage());
            return "";
        }
    }
    /**
     * DES解密
     * @param data 已加密内容
     * @param key 秘钥
     * @return String
     * @throws Exception
     */
    public static String decrypt(String data, String key){
        try {
            // DES算法要求有一个可信任的随机数源
            SecureRandom random = new SecureRandom();
            // 创建一个DESKeySpec对象
            DESKeySpec desKey = new DESKeySpec(key.getBytes());
            // 创建一个密匙工厂
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
            // 将DESKeySpec对象转换成SecretKey对象
            SecretKey securekey = keyFactory.generateSecret(desKey);
            // Cipher对象实际完成解密操作
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE, securekey, random);
            // 真正开始解密操作
            return new String(cipher.doFinal(data.getBytes()));
        }catch(Throwable e){
            e.printStackTrace();
            logger.error("casia des decrypt error ! error:{}",e.getMessage());
            return "";
        }
    }
}
