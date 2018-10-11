package thread;

import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/11
 * @Version: 1.0
 */
//线程休眠
public class ThreadSleep {

    public static void main(String[] args){
        new Thread(()->{
            for (int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName()+"x="+i);
                try {
                    //异常强制处理：休眠即暂停一会（休息一会）再执行，可以自动实现线程的唤醒
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程对象").start();
    }
}
