package org.cuju.study.algorithm;

/**
 * @Author: WuChao
 * @Description: TODO
 * @Date: Create in 18:48 2021/3/22
 */
public class Bubble {
    public static void main(String[] args) {
        int[] result = sortByBubble(new int[]{2,6,10,4,1});

    }

    public static int[] sortByBubble(int[] list){
        for(int i=0;i<list.length;i++){
            for(int j=i+1;j<list.length;j++){
                if(list[i]<list[j]){
                    int temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
        return list;
    }
}
