package org.cuju.common;

import java.util.*;

/**
 * @Author: WuChao
 * @Description: 集合 按照某个字段（依据一定条件）进行分组
 * @Date: Create in 16:24 2021/4/12
 * 参考：https://blog.csdn.net/weixin_38429587/article/details/81081733
 */
public class ListUtils {
    /**
     * list 集合分组
     *
     * @param list    待分组集合
     * @param groupBy 分组Key算法
     * @param <K>     分组Key类型
     * @param <V>     行数据类型
     * @return 分组后的Map集合
     */
    public static <K, V> Map<K, List<V>> groupBy(List<V> list, GroupBy<K, V> groupBy) {
        return groupBy((Collection<V>) list, groupBy);
    }
    /**
     * list 集合分组
     *
     * @param list    待分组集合
     * @param groupBy 分组Key算法
     * @param <K>     分组Key类型
     * @param <V>     行数据类型
     * @return 分组后的Map集合
     */
    public static <K, V> Map<K, List<V>> groupBy(Collection<V> list, GroupBy<K, V> groupBy) {
        Map<K, List<V>> resultMap = new LinkedHashMap<K, List<V>>();

        for (V e : list) {

            K k = groupBy.groupBy(e);
            if (resultMap.containsKey(k)) {
                resultMap.get(k).add(e);
            } else {
                List<V> tmp = new LinkedList<V>();
                tmp.add(e);
                resultMap.put(k, tmp);
            }
        }
        return resultMap;
    }
    /**
     * List分组
     *
     * @param <K> 返回分组Key
     * @param <V> 分组行
     */
    public interface GroupBy<K, V> {
        K groupBy(V row);
    }

    /*List<SportProductSub> sportProductSubList = sportProductSubService.list(querySubWrapper);
    Map<String,List<SportProductSub>> resSubMap = ListUtils.groupBy(sportProductSubList,new ListUtils.GroupBy<String,SportProductSub>(){
        @Override
        public String groupBy(SportProductSub row){
            return row.getType();
        }
    });
    sportProduct.setProductSub(resSubMap);*/
}
