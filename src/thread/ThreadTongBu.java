package thread;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/11
 * @Version: 1.0
 */
//线程的同步的实现：synchronized
class TongbuThread implements Runnable{
private int ticket=10;
   /*没有实现同步的代码
    @Override
    public void run() {
      while (true){
          if (this.ticket>0){
              try {
                  Thread.sleep(100);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              System.out.println(Thread.currentThread().getName()+"ticket--------:"+ticket--);

          }else{
              System.out.println("票已卖完");
              break;
          }
      }
    }*/
   //使用同步代码块来实现同步
    /*@Override
    public void run() {
            while (true) {
                //同步代码块格式：synchronized(同步对象){同步代码操作}这种形式
                synchronized (this) {
                if (this.ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "ticket--------:" + ticket--);

                } else {
                    System.out.println("票已卖完");
                    break;
                }
            }
        }
    }*/
    //使用同步方法来实现同步:就是写一个方法，在方法上使用synchronized，然后在run中调用该方法
    //同步方法的编写
    public synchronized boolean buyTicket() {
            //同步代码块格式：synchronized(同步对象){同步代码操作}这种形式
            if (this.ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "ticket--------:" + ticket--);
                return true;
            } else {
                System.out.println("票已卖完");
                return false;
            }
    }
    @Override
    public void run() {
        //在run中调用同步方法
        while (this.buyTicket()){
            ;
        }

    }
}
public class ThreadTongBu {
    public static void main(String[] args) {
        TongbuThread tongbuThread=new TongbuThread();
        new Thread(tongbuThread,"线程1").start();
        new Thread(tongbuThread,"线程2").start();
        new Thread(tongbuThread,"线程3").start();
    }
}
