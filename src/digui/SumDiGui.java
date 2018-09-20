package digui;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/9/20
 * @Version: 1.0
 */

public class SumDiGui {

    public int sum(int[] arr){
        return sum(arr,0);

    }
    public int sum(int[] arr,int l){
        if (arr.length==l){
            return 0;
        }
        return arr[l]+sum(arr,l+1);
    }

    public static void main(String[] args){
        int[] s={1,2,3,4};
        System.out.println((new SumDiGui().sum(s)));



    }
}
