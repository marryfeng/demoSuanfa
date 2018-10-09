package paixusuanfa;

import java.util.Arrays;
import java.util.HashMap;

import heap.MaxHeap;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/9/26
 * @Version: 1.0
 */

public class PaiXuSuanfa {

    //选择排序java实现
 /* 先将第一个位值上的数跟之后所有位置上的数依次进行比较，如果第一个位置上的数比第二个位置上的数大，则进行互换，
          然后继续将第一个位置上的数与第三个位置上的数进行比较，经过一轮的比较后，
          第一个位值上的数就是所有数中最小的一个，接着将第二个位置上的数与之后所有位置上的数进行比较，
          同样的规则，第二轮比较结束后，第二位放的就是所有数中第二小的数，依次往下比，直到最后一个位置结束。
          按照这种方法进行排序，就叫做选择排序。*/
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
    //快速排序：选择排序的改进
    /*快速排序的原理：选择一个关键值作为基准值(一般选择序列的第一个元素为key),记住基准值一直是我们选的第一个元素的值
    比基准值小的都在左边序列（一般是无序的），比基准值大的都在右边（一般是无序的）。
    基准的右边是比基准大的，基准的左边是比基准小的
    从后往前比较，找到比基准值小的元素，则进行基准值与key进行交换；
    从前往后开始比较，找到比基准值大的元素，将该元素与基准值交换；
    直到从前往后的比较索引>从后往前比较的索引，结束第一次循环，此时，对于基准值来说，左右两边就是有序的了。
    接着分别比较左右两边的序列，重复上述的循环*/
    //low为数组中索引为0，high为最后一个元素的索引
    public int[] quickSort(int[] arr, int low, int high) {
        int start=low;
        int end=high;
        int key=arr[start];
        while(start<end){
            //从后向前找比key小的元素，直到满足条件交换位置
            while(start<end && arr[end]>=key){
                end--;
            }
            if (key>=arr[end]){
                //将key与比key小的哪个元素交换
                int temp=arr[end];
                arr[end]=arr[start];
                arr[start]=temp;
            }
            //接下来从前向后找比key大的元素
            while(start<end && arr[start]<=key){
                start++;
            }
            if (arr[start]>=key){
                //如果找到比key大的元素则进行交换
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
        //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        //递归:注意这里比较是传入的参数low和high，0和arr.length-1
        //左边序列排序
        if(start>low) {
            quickSort(arr,low,start-1);
        }
        //右边序列排序
        if(end<high){
            quickSort(arr,end+1,high);
        }
        return arr;
    }
    //插入排序：将第一个元素看作有序数组中的一个，然后从1开始，后面的每个元素依次插入到这个数组中。一个一个的插入
    public int[] insertSort(int[] arr){
        int insertNum;//待插入的数
        int j;
        for (int i=1;i<arr.length;i++){
            insertNum=arr[i];
            j=i-1;
            while(j>=0 && arr[j]>insertNum){
                //将待插入的元素与有序组中的元素逐个对比，记住这个insertNum是没有变化的
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=insertNum;
        }
        return arr;
    }
    //希尔排序：插入排序的改进：先将整个数组宏观上小的在前面，大的在后面，然后在步长为1时，就是简单插入排序的了
    public  int[] sheelSort(int[] a){
        int d  = a.length;
        while (d!=0) {
            d=d/2;
            //分的组数：刚开始的时候根据步长进行交换，到步长为1了，则就跟简单插入排序一样了
            //理解为步长，即对比的元素与哪个元素
            for (int x = 0; x < d; x++) {
                //根据有多少组数，将元素进行互换，每组都要换
                for (int i = x + d; i < a.length; i += d) {
                    //对比的元素
                    int j = i - d;
                    int insertNum = a[i];
                    //从后往前遍历：从有序列表中从后向前比对
                    while(j >=  0 && insertNum < a[j]) {
                        //移动交换位置
                        a[j + d] = a[j];
                        j=j-d;
                    }
                    a[j+d] = insertNum;
                }
            }
        }
        return a;
    }
    //冒泡排序：
    // 选择排序是将第一个元素后面的所有元素进行比较，最小的在头。冒泡排序是相邻的两个元素进行比较，然后最大的冒泡到最后面
    public int[] bubbleSort(int[] arr) {
        int temp;
        //这一步只是设置循环的次数
        for (int i = 0; i < arr.length; i++) {
            //因为每次冒泡到最后的都是最大/最小元素，所以这里循环也减少了次数，-1是为了防止越界
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
    //堆排序：冒泡排序的改进
    //步骤：建立大顶堆（根节点比孩子节点都大）或者小顶堆（根节点比孩子节点都小）--》交换跟节点与最末尾的节点--》如此循环
   // 堆排序的基本思想是：将待排序序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根节点。将其与末尾元素进行交换，此时末尾就为最大值。然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了
    public  void heapSort(Integer[] a){
        MaxHeap<Integer> maxHeap=new MaxHeap<>(a.length);
        maxHeap.heapify(a);
        maxHeap.bianliHeap();
        for (int i=0;i<a.length;i++){
            System.out.println(maxHeap.delMax());
        }
       /*for (int i=0;i<a.length;i++){
            maxHeap.insertHeapEle(a[i]);
        }
        maxHeap.bianliHeap();
        //上面已经将大顶堆建立完成，依次输出堆中最大的元素
        for (int i=0;i<a.length;i++){
            System.out.println(maxHeap.delMax());
        }*/
     }
     //归并排序 (merge sort) 是一类与插入排序、交换排序、选择排序不同的另一种排序方法。归并的含义是将两个或两个以上的有序表合并成一个新的有序表
     /*一、两路归并排序算法思路
    分而治之(divide - conquer);每个递归过程涉及三个步骤
    第一, 分解: 把待排序的 n 个元素的序列分解成两个子序列, 每个子序列包括 n/2 个元素.
    第二, 治理: 对每个子序列分别调用归并排序MergeSort, 进行递归操作
    第三, 合并: 合并两个排好序的子序列,生成排序结果
    */
    public void mergeSort(int[] array,int low,int high){
        int mid=(low+high)/2;
        if (low<high){
            mergeSort(array,low,mid);//对low到mid进行归并排序
            mergeSort(array,mid+1,high);//对mid+1到high进行归并排序
            mergeArray(array,low,mid,high);//对两边有序的元素进行合并
        }

    }
    //归并排序的融合步骤
    private void mergeArray(int[] arr, int low, int mid, int high){
        //归并排序的一个技巧就是创建一个临时数组来盛放排好的元素
        int[] temp=new int[high-low+1];
        //定义两个指向每组数据的指向
        int i=low;
        int j=mid+1;
        //k为临时数组的索引
        int k=0;
        while(i<=mid && j<=high){
            if (arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
            }
        }
        //将左边剩余元素放入临时数组
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        //将右边剩余元素放入临时数组
        while(j<=high){
            temp[k++]=arr[j++];
        }
        //将临时数组中有序的元素放入arr中
        for(int x=0;x<temp.length;x++){
            arr[x+low] = temp[x];
        }
    }

    //基数排序
    //基数排序(Radix Sort)是桶排序的扩展，它的基本思想是：将整数按位数切割成不同的数字，然后按每个位数分别比较。
    //具体做法是：将所有待比较数值统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列。
           /* 1. 按照个位数进行排序。
            2. 按照十位数进行排序。
            3. 按照百位数进行排序*/

    public static void main(String[] args){
        PaiXuSuanfa xz=new PaiXuSuanfa();
        int a[] = {51,46,20,18};
       // int[] brr=xz.xzpx(a);
       // int[] brr=xz.insertSort(a);
        // int[] brr=xz.quickSort(a,0,a.length-1);
        //int[] brr=xz.sheelSort(a);
//        xz.heapSort(a);
        xz.mergeSort(a,0,a.length-1);
       /* for (int i=0;i<brr.length;i++){
            System.out.print(brr[i]+",");
        }
*/
    }

   /* public static void main(String[] args){
        String a="1";
        f(a);
        System.out.println(a);
    }
    public static void f(String str){
        str=str+"2";
    }*/

}
