package org.cuju.study.regular;

/**
 * @Author: WuChao
 * @Description: TODO
 * @Date: Create in 13:59 2021/3/15
 */
public class MainTest {
    public static void main(String[] args) {
        String a = "StringA_StringAB_StringABA_StringABAB";
        System.out.println(a.replaceAll("",""));//结果String_String_String  ([ab]+)  ""

        String b = "StringA_StringAB_StringABA_StringABAB";
        System.out.println(b.replaceAll("",""));//StringA1_StringAB1_StringABA1_StringABAB1  ([ab]+)  $11
    }
}
