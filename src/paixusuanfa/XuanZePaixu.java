package paixusuanfa;

import java.util.Arrays;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/9/26
 * @Version: 1.0
 */
//选择排序java实现
 /* 先将第一个位值上的数跟之后所有位置上的数依次进行比较，如果第一个位置上的数比第二个位置上的数大，则进行互换，
          然后继续将第一个位置上的数与第三个位置上的数进行比较，经过一轮的比较后，
          第一个位值上的数就是所有数中最小的一个，接着将第二个位置上的数与之后所有位置上的数进行比较，
          同样的规则，第二轮比较结束后，第二位放的就是所有数中第二小的数，依次往下比，直到最后一个位置结束。
          按照这种方法进行排序，就叫做选择排序。*/
public class XuanZePaixu {

    //从小到大排序:将第一个元素与后面的元素逐个相比，最小的到最前面；然后比较第二个与后面的元素大小
    public int[] xzpx(int[] arr){
        int temp;
        for(int i=0;i<arr.length;i++){
            for (int j=i+1;j<arr.length;j++){
                if (arr[i]>arr[j]){
                    //进行交换
                    temp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                }
            }
        }
        return arr;
    }
    public int[] insertSort(int[] arr){
        int insertNum;//待插入的数
        int j;
        for (int i=1;i<arr.length;i++){
            insertNum=arr[i];
            j=i-1;
            while(j>=0 && arr[j]>insertNum){
                //初始的时候有序数组有一个元素,交换元素
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=insertNum;
        }
        return arr;
    }
    //冒泡排序
    public int[] bubbleSort(int[] arr) {
        int temp;
        //选择排序是将第一个元素后面的所有元素进行比较，最小的在头。冒泡排序是相邻的两个元素进行比较，然后最大的冒泡到最后面
        //这一步只是设置循环的次数
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
    //快速排序
    public int[] quickSort(int[] arr, int start, int end) {
        if (start < end) {
            // 选定的基准值（第一个数值作为基准值）
            int base = arr[start];
            int temp; // 记录临时中间值
            int i = start, j = end;
            do {
                while ((arr[i] < base) && (i < end)){
                    i++;
                }
                while ((arr[j] > base) && (j > start)){
                    j--;
                }
                if (i <= j) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                    j--;
                }
            } while (i <= j);
            if (start < j){
                quickSort(arr, start, j);
            }

            if (end > i){
                quickSort(arr, i, end);
            }

        }
        return arr;
    }
    //希尔排序：
    public  void sheelSort(int[] a){
        int d  = a.length;
        while (d!=0) {
            d=d/2;
            //分的组数
            for (int x = 0; x < d; x++) {
                 for (int i = x + d; i < a.length; i += d) {
                     //组中的元素，从第二个数开始
                     //j为有序序列最后一位的位数
                     int j = i - d;
                     //要插入的元素
                     int temp = a[i];
                     //从后往前遍历。
                     for (; j >= 0 && temp < a[j]; j -= d) {
                         //向后移动d位
                           a[j + d] = a[j];
                          }
                     a[j + d] = temp;
                 }
            }
        }
    }




    //堆排序
    public  void heapSort(int[] a){
        System.out.println("开始排序");
        int arrayLength=a.length;
        //循环建堆
        for(int i=0;i<arrayLength-1;i++){
            //建堆
            buildMaxHeap(a,arrayLength-1-i);
            //交换堆顶和最后一个元素
            swap(a,0,arrayLength-1-i);
            System.out.println(Arrays.toString(a));
        }
    }
    private  void swap(int[] data, int i, int j) {
        // TODO Auto-generated method stub
        int tmp=data[i];
        data[i]=data[j];
        data[j]=tmp;    }
        //对data数组从0到lastIndex建大顶堆
     private void buildMaxHeap(int[] data, int lastIndex) {
         // TODO Auto-generated method stub
         // 从lastIndex处节点（最后一个节点）的父节点开始
         for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
             //k保存正在判断的节点
             int k = i;
             //如果当前k节点的子节点存在
             while (k * 2 + 1 <= lastIndex) {
                 //k节点的左子节点的索引
                 int biggerIndex = 2 * k + 1;
                 //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                 if (biggerIndex < lastIndex) {
                     //若果右子节点的值较大
                     if (data[biggerIndex] < data[biggerIndex + 1]) {
                         //biggerIndex总是记录较大子节点的索引
                         biggerIndex++;
                     }
                 }                //如果k节点的值小于其较大的子节点的值
                 if (data[k] < data[biggerIndex]) {
                     //交换他们
                     swap(data, k, biggerIndex);
                     //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                     k = biggerIndex;
                 } else {
                     break;
                 }
             }
         }
     }





    public static void main(String[] args){
        XuanZePaixu xz=new XuanZePaixu();
        int[] a={5,3,2,1,7};
       // int[] brr=xz.xzpx(a);
       // int[] brr=xz.insertSort(a);
        int[] brr=xz.quickSort(a,0,4);
        for (int i=0;i<brr.length;i++){
            System.out.print(brr[i]+",");
        }

    }

}
