package org.cuju.study.algorithm;

/**
 * @Author: WuChao
 * @Description: TODO
 * @Date: Create in 18:42 2021/3/22
 */
public class MainTest {
    private static int a = 100;
    public MainTest(){
        a++;
    }

    public static void main(String[] args) {
        MainTest mainTest = new MainTest();
        a -= 10;
        mainTest = new MainTest();
        System.out.println(a);
    }
}
