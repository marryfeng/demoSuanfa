package thread;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/12
 * @Version: 1.0
 */
//加减数字：设计四个线程对象，两个线程加，两个线程减，则最后出现的结果是：减的结果为0。加的结果为1

//对同一资源的操作
    class Resource{
        private int num=0;
        private boolean flag=true;
        //如果flag为true，则执行加操作，如果为false则执行减操作
    public synchronized void add() throws InterruptedException {
        if (flag==false){
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.num++;
        System.out.println(Thread.currentThread().getName()+"加法操作"+this.num);
        this.flag=false;
        super.notifyAll();
    }
    public synchronized  void sub() throws InterruptedException {
        if (this.flag==true){
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.num--;
        System.out.println(Thread.currentThread().getName()+"减法操作"+this.num);
        this.flag=true;
        super.notifyAll();
    }
}
//执行加的操作
class AddMake implements Runnable{
 private Resource re;
 public AddMake(Resource re){
    this.re=re;
}
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            try {
                this.re.add();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
//执行减的操作
class SubMake implements Runnable{
    private Resource re;
    public SubMake(Resource re){
        this.re=re;
    }
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            try {
                this.re.sub();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}




public class AddSub {
    public static void main(String[] args) {
        Resource r=new Resource();
        AddMake at=new AddMake(r);
        SubMake st=new SubMake(r);
        new Thread(at,"线程加-a").start();
        new Thread(at,"线程加-b").start();
        new Thread(st,"线程减-a").start();
        new Thread(st,"线程减-b").start();

    }
}
