package org.cuju.study.designpattern.singleton;

/**
 * @Author: WuChao
 * @Description: TODO
 * @Date: Create in 23:27 2021/3/17
 */
public class TaskManagerHungry {
    private static TaskManagerHungry taskManagerHungry = new TaskManagerHungry();

    private TaskManagerHungry(){

    }

    public static TaskManagerHungry createInstance(){
        return taskManagerHungry;
    }

    public void printStart(){
        System.out.println("打印开始");
    }
    public void printEnd(){
        System.out.println("打印结束");
    }
}
