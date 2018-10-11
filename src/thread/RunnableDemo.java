package thread;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/10
 * @Version: 1.0
 */
class RunThread implements Runnable{//线程的主体
    private String title;
    public RunThread(String title){
        this.title=title;
    }
    @Override
    public void run(){//线程的主方法
        for (int i=0;i<10;i++){
            System.out.println(this.title+"运行"+i);
        }
    }
}
public class RunnableDemo {

    public static void main(String[] args){
        //注意Runnable线程的启动，因为没有继承Thread，所以这里要new一个
        new Thread(new RunThread("线程1")).start();
        new Thread(new RunThread("线程2")).start();
        new Thread(new RunThread("线程3")).start();
    }
    /* Thread与Runnable的关系：这里建议看下Thread的源码：
     Thread类：class Thread implements Runnable {所以Thread是Runnable的子类
     构造方法：public Thread(Runnable target) 而target执行了这个run()方法。而这个run()方法被我们覆写了
      public void run() {
        if (target != null) {
            target.run();
        }
    }
     在进行Tread中的start()方法启动多线程时，会调用run()方法。
     这个过程是：在创建Tread的时候会传入一个Runnable的对象（这里就是：new RunThread("线程1")），
     这个对象被Thread的构造方法中的Runnable类型的target属性接收，然后target执行run()方法。
     而这个run()方法，就是上面RunThread类中复写的Runnable的run()方法。*/

}
