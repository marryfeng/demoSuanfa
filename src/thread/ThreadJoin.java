package thread;


/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/11
 * @Version: 1.0
 */
//线程的强制执行
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread=Thread.currentThread();
        //这个是辅线程
        Thread thread=new Thread(()->{
            for (int i=0;i<10;i++){
                if (i==0){
                    try {
                        //join即线程的强制执行
                        mainThread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"x="+i);
            }
        },"玩耍的线程");
        thread.start();
        //这个是主线程
        for (int i=0;i<20;i++){
            Thread.sleep(1000);
            System.out.println("霸道的线程：number=i="+i);
        }
    }



}
