package org.cuju.common;

/**
 * @Author: Uoolo
 * @Description: 字符串处理
 * @Date: Create in 19:03 2020/4/22
 */
public class StringUtils {

    public static String repeatString(String str, Integer n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(str);
        }
        return sb.substring(0, sb.length());
    }

    /**
     * 替换指定字符串
     * @param str 输入字符串
     * @param mark 替换字符
     * @param times 重复次数
     * @param s 首预留
     * @param e 尾预留
     * @param isChinese 是否是中文
     * @return
     */
    public static String replaceMark(String str,String mark,Integer times,Integer s,Integer e,String... isChinese) {
        Integer num = s + e;
        if (str != null && str.length() > num) {
            String tips = repeatString(mark, times);
            String reg = "(\\w{"+s+"})\\w*(\\w{"+e+"})";
            if(isChinese.length>0 && "true".equals(isChinese[0])){
                reg = "([\\u4e00-\\u9fa5]{"+s+"})[\\u4e00-\\u9fa5]*([\\u4e00-\\u9fa5]{"+e+"})";
            }
            str = str.replaceAll(reg, "$1"+tips+"$2");
        }
        return str;
    }
}
