package org.cuju.study.algorithm;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: WuChao
 * @Description: 去重
 * @Date: Create in 23:29 2021/3/4
 */
public class RemoveDup {
    public static void main(String[] args) {
        String str = "aa,bb,cc,aa,dd,ee,aa,";
        System.out.println(dupSort(str));
    }

    private static String dupSort(String str){
        List<String> list = Arrays.asList(str.split(","));
        return list.stream().distinct().sorted(Comparator.comparing(String::hashCode)).collect(Collectors.joining(","));
    }
}
