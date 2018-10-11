package thread;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/10
 * @Version: 1.0
 */
class MyThread extends Thread{//线程的主体
    private String title;
    public MyThread(String title){
        this.title=title;
    }
    @Override
    public void run(){//线程的主方法
        for (int i=0;i<10;i++){
            System.out.println(this.title+"运行"+i);
        }
    }
}
public class ThreadDemo {
    public static void main(String[] args){
        new MyThread("线程1").start();
        new MyThread("线程2").start();
        new MyThread("线程3").start();
    }

}

