package org.cuju.study.designpattern.singleton;

/**
 * @Author: WuChao
 * @Description: TODO
 * @Date: Create in 23:23 2021/3/17
 */
public class MainTest {
    public static void main(String[] args) {
        TaskManagerLazy taskManagerLazy = TaskManagerLazy.createInstance();
        taskManagerLazy.printStart();
        taskManagerLazy.printEnd();

        TaskManagerLazy taskManagerLazy1 = TaskManagerLazy.createInstance();

        TaskManagerHungry taskManagerHungry = TaskManagerHungry.createInstance();
        taskManagerHungry.printStart();
        taskManagerHungry.printEnd();
    }
}
