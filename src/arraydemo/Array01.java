package arraydemo;

/**
 * @Author: li.feng
 * @Email: li.feng@rograndec.com
 * @CreateDate: 2018/9/18
 * @Version: 3.0
 */

public class Array01 {
    public static void main(String[] args){
        Array<Integer> arr=new Array<>();
        for(int i=0;i<10;i++){
            arr.addLastElemplt(i);
        }
        System.out.println(arr);
        arr.insertEle(2,200);
        System.out.println(arr);
        arr.deleteEle(5);
        System.out.println(arr);
        arr.addLastElemplt(300);
        System.out.println(arr);
        arr.addFirstElemplt(-1);
        System.out.println(arr);

    }


}
