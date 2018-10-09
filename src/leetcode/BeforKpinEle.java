package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;


/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/9
 * @Version: 1.0
 */
//求出数组中，频率出现前k高的元素
public class BeforKpinEle {

    public List<Integer> getKele(int[] arr,int k){
        //第一步求数组中元素出现的频次
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for (int num:arr) {
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }
        //根据出现的频次来求出前k高的元素，频次越低优先级越高
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(
                (a,b)->map.get(a)-map.get(b));
        for (int key:map.keySet()) {
            if (pq.size()<k){
                pq.add(key);
            }else if(map.get(key)>map.get(pq.peek())){
                pq.remove(0);
                pq.add(key);
            }
        }
        //经过上面的操作pq中都是出现频次为k的元素
        List<Integer> list=new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(pq.remove());
        }
        return list;
    }

}
