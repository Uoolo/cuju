package org.cuju.algorithm;

/**
 * @Author: Uoolo
 * @Description: 变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @Date: Create in 16:29 2020/9/21
 */
public class AbnormalJump {
    private static int result = 0;
    public static int classicMethod(int n){
        if(n == 0){
            result++;
            return 0;
        }
        if(result < 0){
            return 0;
        }
        for(int i=1;i<=n;i++){
            classicMethod(n-i);
        }
        return result;
    }

    public static int getResult(int n){
        if(n == 1){
            return 1;
        }
        int a = 2;
        for(int i=1;i<n-1;i++){
            a *= 2;
        }
        return a;
    }


    public static void main(String[] args){
        long startTime = 0L;
        long endTime = 0L;

        startTime = System.currentTimeMillis();
        int b = AbnormalJump.classicMethod(30);
        endTime = System.currentTimeMillis();
        System.out.println("递归计算：" + b + ",耗时：" + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        int a = AbnormalJump.getResult(30);
        endTime = System.currentTimeMillis();
        System.out.println("公式计算：" + a + ",耗时：" + (endTime - startTime) + "ms");

        //在计算30个台阶时
        //递归计算：536870912,耗时：2077ms
        //公式计算：536870912,耗时：0ms
    }
}
