package org.cuju.study.designpattern.proxy;

/**
 * @Author: WuChao
 * @Description: TODO
 * @Date: Create in 18:27 2021/3/11
 */
public class UserDao implements IUserDao {
    @Override
    public void save(){
        System.out.println("保存数据完成！");
    }
}
