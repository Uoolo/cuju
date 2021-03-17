package org.cuju.study.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: WuChao
 * @Description: 代理工厂类
 * @Date: Create in 16:44 2021/3/17
 */
public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开始事务2");
                        Object returnValue = method.invoke(target, args);
                        System.out.println("开始事务2");
                        return returnValue;
                    }
                });
    }

}
