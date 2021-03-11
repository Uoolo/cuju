package org.cuju.study.designpattern.proxy;

/**
 * @Author: WuChao
 * @Description: TODO
 * @Date: Create in 18:30 2021/3/11
 */
public class UserDaoProxy implements IUserDao {
    private IUserDao target;
    public UserDaoProxy(IUserDao target){
        this.target = target;
    }

    public void save(){
        System.out.println("开始");
        target.save();
        System.out.println("结束");
    }
}
