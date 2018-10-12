package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/12
 * @Version: 1.0
 */
//实现一个竞拍抢答程序：要求设置三个线程抢答，发出抢答指令，抢答成功返回成功信息，失败返回失败信息；

    class Answer implements Callable<String>{
        private boolean flag=false;
        //如果flag为false，则表示可以抢答，抢答成功

    @Override
    public String call() throws Exception {
        synchronized (this){
            if (this.flag==false){
                this.flag=true;
                return Thread.currentThread().getName()+"抢答成功";
            }else{
                return Thread.currentThread().getName()+"抢答失败";
            }
        }
    }


}
public class QiangDaCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Answer a=new Answer();
        FutureTask<String> futureTaskA=new FutureTask<String>(a);
        FutureTask<String> futureTaskB=new FutureTask<String>(a);
        FutureTask<String> futureTaskC=new FutureTask<String>(a);
        new Thread(futureTaskC,"抢答者C").start();
        new Thread(futureTaskA,"抢答者A").start();
        new Thread(futureTaskB,"抢答者B").start();
        System.out.println(futureTaskA.get());
        System.out.println(futureTaskC.get());
        System.out.println(futureTaskB.get());
    }
}
