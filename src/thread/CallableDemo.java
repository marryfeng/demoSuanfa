package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/11
 * @Version: 1.0
 */
//线程的启动必须是Thread的start方法，所以Runnable与callable都必须new一个Thread
class CallThread implements Callable<String>{
    @Override
    public String call() throws Exception {
        for (int i=0;i<10;i++){
            System.out.println("*************************");
        }
        return "线程执行完毕";
    }
}
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> ft=new FutureTask<>(new CallThread());
        new Thread(ft).start();
        System.out.println("线程返回结果"+ft.get());

    }
}
