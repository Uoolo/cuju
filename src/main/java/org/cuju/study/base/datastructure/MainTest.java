package org.cuju.study.base.datastructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * @Author: WuChao
 * @Description: TODO
 * @Date: Create in 15:53 2021/4/8
 */
public class MainTest {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("1");
        hashSet.add("1");
        hashSet.add("2");

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("1");
        treeSet.add("1");
        treeSet.add("2");

        HashMap hashMap = new HashMap();
        hashMap.put("1", null);
        hashMap.put("1", null);
        hashMap.put("2", null);
    }
}
