package org.cuju.study.designpattern.singleton;

/**
 * @Author: WuChao
 * @Description: 任务管理器
 * @Date: Create in 23:20 2021/3/17
 */
public class TaskManagerLazy {
    private static TaskManagerLazy taskManagerLazy = null;

    private TaskManagerLazy(){

    }

    public static TaskManagerLazy createInstance(){
        if(taskManagerLazy == null){
            synchronized(TaskManagerLazy.class) {
                if(taskManagerLazy == null) {
                    taskManagerLazy = new TaskManagerLazy();
                }
            }
        }
        return taskManagerLazy;
    }

    public void printStart(){
        System.out.println("打印开始");
    }
    public void printEnd(){
        System.out.println("打印结束");
    }
}
