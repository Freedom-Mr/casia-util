package casia.isiteam.api.toolutil;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ClassName: Validator
 * Description: 校验空值工具类
 * <p>
 * Created by casia.wzy on 2020/4/21
 * Email: zhiyou_wang@foxmail.com
 */
public class Validator {
	public static boolean check(String string) {
		return (string == null || "".equals(string.trim())) ? false : true;
	}

	public static boolean check(String[] string) {
		return (string == null || string.length == 0) ? false : true;
	}
	public static boolean check(Object[] objects) {
		return (objects == null || objects.length == 0) ? false : true;
	}
	public static boolean check(Collection collection) {
		return (collection == null || collection.isEmpty()) ? false : true;
	}
	public static boolean check(List list) {
		return (list == null || list.isEmpty()) ? false : true;
	}
	public static boolean check(Map map) {
		return (map == null || map.isEmpty()) ? false : true;
	}
	public static boolean check(Set set) {
		return (set == null || set.isEmpty()) ? false : true;
	}
	public static boolean check(StringBuffer stringBuffer) {
		return (stringBuffer == null || stringBuffer.length() ==0 ) ? false : true;
	}
	public static boolean check(Object o) {
		if(o == null){
			return false;
		}
		else if(o instanceof String){
			return check(String.valueOf(o));
		}else if(o instanceof String[]){
			return check((String[])o);
		}else if(o instanceof Object[]){
			return check((Object[])o);
		}else if(o instanceof Map){
			return check((Map)o);
		}else if(o instanceof Set){
			return check((Set)o);
		}else if(o instanceof List){
			return check((List)o);
		}else if(o instanceof Collection){
			return check((Collection)o);
		}else if(o instanceof StringBuffer){
			return check((StringBuffer) o);
		}else {
			return o == null ? false : true;
		}
	}

}
