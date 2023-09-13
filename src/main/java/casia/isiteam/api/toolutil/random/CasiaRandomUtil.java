package casia.isiteam.api.toolutil.random;

import casia.isiteam.api.toolutil.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * ClassName: CasiaRandomUtil
 * Description: Random Class
 * <p>
 * Created by casia.wzy on 2020/4/29
 * Email: zhiyou_wang@foxmail.com
 */
public class CasiaRandomUtil {

    /**
     * 在指定区间范围内返回随机数(包含起始结束范围)
     * @param startRange 起始范围
     * @param endRange  结束范围
     * @return  随机数
     */
    public static Integer randomNumber(Integer startRange,Integer endRange){
        Random random = new Random();
        int number = random.nextInt(endRange - startRange + 1) + startRange;
        return number;
    }
    /**
     * 在指定数据集中返回N个随机数
     * @param parms 数据集
     * @param returnNumber 返回随机值个数,默认一个
     * @return  返回N个随机值
     */
    public static List<Object> randomNumber(List<Object> parms,Integer returnNumber){
        List<Object> result = new ArrayList<>();
        if( !Validator.check(parms) ){
            return result;
        }
        Random random = new Random();
        returnNumber = Validator.check(returnNumber) && returnNumber > 0 ? (returnNumber > parms.size() ? parms.size() : returnNumber) : 1;
        while (true){
            int number = random.nextInt(parms.size()) ;
            if(!result.contains(parms.get(number))){
                result.add(parms.get(number));
            }
            if( result.size() >= returnNumber ){
                break;
            }
        }
        return result;
    }
    /**
     * 在指定数据集中返回N个随机数
     * @param parms 数据集
     * @param returnNumber 返回随机值个数,默认一个
     * @return  返回N个随机值
     */
    public static Object[] randomNumber(Object[] parms,Integer returnNumber){
        List<Object> result = new ArrayList<>();
        if( !Validator.check(parms) ){
            return result.toArray();
        }
        Random random = new Random();
        returnNumber = Validator.check(returnNumber) && returnNumber > 0 ? (returnNumber > parms.length ? parms.length : returnNumber) : 1;
        while (true){
            int number = random.nextInt(parms.length) ;
            if(!result.contains(parms[number])){
                result.add(parms[number]);
            }
            if( result.size() >= returnNumber ){
                break;
            }
        }
        return result.toArray();
    }

    /**
     * 在指定数据集中返回N个随机数
     * @param returnNumber 返回随机值个数,默认一个
     * @param parms 数据集
     * @return  返回N个随机值
     */
    public static Object[] randomNumber(Integer returnNumber,Object ... parms){
        List<Object> result = new ArrayList<>();
        if( !Validator.check(parms) ){
            return result.toArray();
        }
        Random random = new Random();
        returnNumber = Validator.check(returnNumber) && returnNumber > 0 ? (returnNumber > parms.length ? parms.length : returnNumber) : 1;
        while (true){
            int number = random.nextInt(parms.length) ;
            if(!result.contains(parms[number])){
                result.add(parms[number]);
            }
            if( result.size() >= returnNumber ){
                break;
            }
        }
        return result.toArray();
    }
}
