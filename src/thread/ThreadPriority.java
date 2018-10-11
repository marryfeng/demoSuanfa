package thread;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/11
 * @Version: 1.0
 */

//线程的优先级：优先级高的越有可能抢占到资源
public class ThreadPriority {
    //psvm   main方法的快捷键
    public static void main(String[] args) {
        Runnable run=(()->{
            for (int i=0;i<10;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        });
        //ctrl+PgDn向下箭头复制上一行
        Thread threadA=new Thread(run,"线程a");
        Thread threadB=new Thread(run,"线程b");
        Thread threadC=new Thread(run,"线程c");
        //设置线程的优先级
        threadA.setPriority(Thread.MIN_PRIORITY);
        threadC.setPriority(Thread.MAX_PRIORITY);
        threadB.setPriority(Thread.MIN_PRIORITY);
        threadA.start();
        threadB.start();
        threadC.start();





    }
}
