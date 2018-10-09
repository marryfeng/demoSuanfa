package leetcode;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/9
 * @Version: 1.0
 */
//从数组中找出三个数的和为0的数组元素
//先排序，然后遍历数组，当前元素nums[i],，并从剩下的数组中找两个数的和0-nums[i]，这个做法就是两边向中间找,即采用双指针的方法
public class Sum3 {
    public List<List<Integer>> getSum0(int[] arr){
        List<List<Integer>> result=new ArrayList<>();
        if (arr.length<3 || arr==null){
            return result;
        }
        for (int i=0;i<arr.length;i++) {
            List<Integer> list = new ArrayList<>();
            //跳过重复的,这个跟前一个不一样就进行
            if (i == 0 || (i > 0 && arr[i] != arr[i - 1])) {
                int sum = 0 - arr[i];
                //从剩余的数组元素中找出和为sum的两个数
                int left = i + 1;
                int right = arr.length - 1;
                while (left < right) {
                    if (arr[left] + arr[right] == sum) {
                        //找到两元素
                        list.add(arr[i]);
                        list.add(arr[left]);
                        list.add(arr[right]);
                        //跳过重复元素。这里跳到了重复节点的最后一个，也就是说还需要在++
                        while (left < right && arr[left + 1] == arr[left]) {
                            left++;
                        }
                        while (left < right && arr[right] == arr[right - 1]) {
                            right--;
                        }
                    } else if (arr[left] + arr[right] < sum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }


}
