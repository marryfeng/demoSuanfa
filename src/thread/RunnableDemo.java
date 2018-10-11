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

}
