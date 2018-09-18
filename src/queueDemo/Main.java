package queueDemo;

/**
 * @Author: li.feng
 * @Email: li.feng@rograndec.com
 * @CreateDate: 2018/9/18
 * @Version: 3.0
 */

public class Main {
    public static void main(String[] args){
        ArrayQueue<Integer> arrayQueue=new ArrayQueue<>();
        for(int i=0;i<5;i++){
            arrayQueue.enQueue(i);
        }
        System.out.println(arrayQueue);
        arrayQueue.deQueue();
        System.out.println(arrayQueue);
    }
}
