package org.cuju.study.designpattern.proxy;

/**
 * @Author: WuChao
 * @Description: TODO
 * @Date: Create in 18:34 2021/3/11
 */
public class MainTest {
    public static void main(String[] args) {
        //静态代理
        //UserDaoProxy userDaoProxy = new UserDaoProxy(new UserDao());
        //userDaoProxy.save();

        //JDK动态代理
        IUserDao proxy = (IUserDao) new ProxyFactory(new UserDao()).getProxyInstance();
        proxy.save();
    }
}
