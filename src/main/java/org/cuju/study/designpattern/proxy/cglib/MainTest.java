package org.cuju.study.designpattern.proxy.cglib;

/**
 * @Author: WuChao
 * @Description: TODO
 * @Date: Create in 17:23 2021/3/17
 */
public class MainTest {
    public static void main(String[] args) {
        UserDao proxy = (UserDao)new ProxyFactory(new UserDao()).getProxyInstance();
        proxy.save();
    }
}
