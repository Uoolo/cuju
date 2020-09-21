package org.cuju.algorithm;

/**
 * @Author: Uoolo
 * @Description:
 * 爬楼梯：假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * @Date: Create in 14:19 2020/9/21
 */
public class ClimbStairs {

    public static int getResult(int n){
        int[] a = new int[n];
        a[0] = 1;
        a[1] = 2;
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        for(int i = 2; i < n;i++){
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n - 1];
    }

    private static int result = 0;
    public static int classicMethod(int n){
        if(n == 0){
            result++;
            return 0;
        }
        if(n < 0 ){
            return 0;
        }
        classicMethod(n-1);
        classicMethod(n-2);

        return result;
    }


    public static void main(String[] args){
        long startTime = 0L;
        long endTime = 0L;
        startTime = System.currentTimeMillis();
        int a = ClimbStairs.getResult(40);
        endTime = System.currentTimeMillis();
        System.out.println("斐波那契数列公式计算：" + a + ",耗时：" + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        int b = ClimbStairs.classicMethod(40);
        endTime = System.currentTimeMillis();
        System.out.println("递归计算：" + b + ",耗时：" + (endTime - startTime) + "ms");

        //在计算40个台阶时
        //斐波那契数列公式计算：165580141,耗时：1ms
        //递归计算：165580141,耗时：770ms
    }
}
