package org.cuju.algorithm;

/**
 * @Author: Uoolo
 * @Description: n年后牛的数量
 * 假设农场中的母牛每年会产生一头小母牛，并且永远不会死。第一年农场中只有一头成熟的母牛，第二年开始，母牛开始生小母牛，每只小母牛三年之后成熟又可以生小母牛，给定整数N，求N年后母牛的数量。
 * @Date: Create in 16:51 2020/9/21
 */
public class CowNumber {

    public static int classicMethod(int n){
        int result = 0;
        for(int i=0;i<n;i++){
            result++;
            if(i>=3){
                result += classicMethod(n - i);
            }
        }
        return result;
    }

    public static int getResult(int n){

        return n;
    }

    public static void main(String[] args) {
        long startTime = 0L;
        long endTime = 0L;
        startTime = System.currentTimeMillis();
        int a = CowNumber.classicMethod(4)+1;
        endTime = System.currentTimeMillis();
        System.out.println("递归计算：" + a + ",耗时：" + (endTime - startTime) + "ms");
    }
}
