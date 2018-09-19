package queueDemo;

/**
 * @Author: li.feng
 * @Email: li.feng@rograndec.com
 * @CreateDate: 2018/9/19
 * @Version: 3.0
 */

public class LoopQueueMain {

    public static  void main(String[] args){
        LoopQueue<Integer> loop=new LoopQueue<>();
        for(int i=0;i<5;i++){
            loop.enQueue(i);
        }
        System.out.println(loop);
        loop.deQueue();
        System.out.println(loop);
    }
}
