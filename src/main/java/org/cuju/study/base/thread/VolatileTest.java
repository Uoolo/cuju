package org.cuju.study.base.thread;

/**
 * @Author: WuChao
 * @Description: TODO
 * @Date: Create in 13:19 2021/3/25
 */
public class VolatileTest {
    public volatile int inc = 0;

    public void increase() {
        inc++;
    }
    public static void main(String[] args) {
        final VolatileTest test = new VolatileTest();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<10;j++)
                        test.increase();
                };
            }.start();
        }
        while(Thread.activeCount()>1)
            Thread.yield();
        System.out.println(test.inc);
    }

}
