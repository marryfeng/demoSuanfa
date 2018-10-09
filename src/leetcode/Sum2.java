package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/9
 * @Version: 1.0
 */
//在给定数组中求两个数的和为sum的两个数索引
public class Sum2 {

    public int[] isExist(int[] arr,int sum){
        int[] result=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }

        for (int i=0;i<arr.length;i++){
           int b=sum-arr[i];
            // 如果存在第二个数的数组下标&&结果的两个数不是同一个数的值，这里默认的是数组中没有重复元素
           if (map.containsKey(b)&& map.get(b)!=i){
               result[0]=i;
               result[1]=map.get(b);
               return result;
           }
        }
        return result;
        }

        public static void main(String[] args){
        Sum2 s=new Sum2();
        int[] a={1,2,3,4,5,9};
        int[] res=s.isExist(a,10);
        for (int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }

        }

    }
