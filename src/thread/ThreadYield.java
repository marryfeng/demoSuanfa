package thread;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/11
 * @Version: 1.0
 */
//线程的礼让：让出当前资源，让别的线程执行
public class ThreadYield {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
            for (int i=0;i<10;i++){
                if(i%3==0){
                    //线程礼让用：yield()方法
                    Thread.yield();
                    System.out.println("玩耍线程礼让");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"玩耍线程");
        thread.start();
        for (int i=0;i<10;i++){
            Thread.sleep(1000);
            System.out.println("霸道线程执行");
        }
    }
}
