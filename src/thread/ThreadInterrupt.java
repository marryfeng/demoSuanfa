package thread;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/11
 * @Version: 1.0
 */
//线程中断：即休眠或者正在执行被中断，中断线程必须进行异常处理
public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
            System.out.println("我要睡给天昏地暗");
            try {
                Thread.sleep(10000);
                System.out.println("我睡饱了");
            } catch (InterruptedException e) {
                System.out.println("谁打扰我了，烦死了");
            }

        });
        thread.start();//开始睡
        Thread.sleep(1000);
        //线程是否中断，线程中断的方法
        if (!thread.isInterrupted()){
            thread.interrupt();
        }

    }
}
