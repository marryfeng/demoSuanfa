import java.util.Arrays;
import java.util.Scanner;


/**
 * @Author: li.feng
 * @Email: li.feng@rograndec.com
 * @CreateDate: 2018/9/19
 * @Version: 3.0
 */

public class Main {
    public static void main(String[] args){
        //在默认情况下，Scanner使用空白（包括空格、Tab空白、回车）作为多个输入项之间的分隔符
        Scanner sc =  new Scanner(System.in);
        //输入数据包括一个整数N
        int n=sc.nextInt();
        int l=sc.nextInt();
        System.out.println(n+" "+l);
       // System.out.println(n);
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
            //System.out.println(str);
        }
        //sc.close();
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }
        System.out.println("....................................");
  //Scanner实现字符串的输入有两种方法，一种是next（），一种nextLine()
        String s1,s2;
        System.out.println("请输入第一个字符串：");
        s1=sc.nextLine();
        System.out.println("请输入第二个字符串：");
        s2=sc.next();
        System.out.println("输入的字符串是："+s1+" "+s2);
    }
}
