package JUC;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/10
 * @Version: 1.0
 */

public class AutomaticDemo implements Runnable{
   // private int seriableNumber=0;
    private AtomicInteger seriableNumber=new AtomicInteger();
    @Override
    public void run() {
        try{
            Thread.sleep(200);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+":"+getSeriableNumber());
    }
    public int getSeriableNumber(){
        return seriableNumber.getAndDecrement();
    }
}
