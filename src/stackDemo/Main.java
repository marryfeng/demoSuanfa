package stackDemo;

/**
 * @Author: li.feng
 * @Email: li.feng@rograndec.com
 * @CreateDate: 2018/9/18
 * @Version: 3.0
 */

public class Main {
    public static  void main(String[] args){
        ArrayStack<Integer> arrayStack=new ArrayStack<>();
        for(int i=0;i<5;i++){
            arrayStack.push(i);
            System.out.println(arrayStack);
        }
        arrayStack.pop();
        System.out.println(arrayStack);

    }
}
