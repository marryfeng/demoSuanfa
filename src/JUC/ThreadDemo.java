package JUC;


/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/10
 * @Version: 1.0
 */

public class ThreadDemo implements Runnable {
    private volatile boolean flag=false;
    @Override
    public void run() {
        try{
            Thread.sleep(200);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        flag=true;
        System.out.println(isFlag());

    }
    public boolean isFlag(){
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
