package thread;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/11
 * @Version: 1.0
 */
//message类：商品库，因为都是对这个message操作，所以同步和等待唤醒都是在这里进行：set与get
class Message{
    private String title;
    private String content;
    //设置一个信号灯：当flag为true时，生产者可以生产,不允许消费。当flag为false的时候，消费者可以消费
    private boolean flag=true;

    public synchronized void set(String title, String content) {
        //生产者不能生产，等待
        if (this.flag==false){
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.title=title;
        this.content = content;
        //已经生产过了
        this.flag=false;
        super.notify();
    }


    public synchronized String get() {
        if (this.flag==true) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try{
            return this.title+this.content;
        } finally {
            this.flag=true;
            super.notify();
        }
    }
}
//生产者:线程
class Producer implements Runnable{
       private Message msg;
       public Producer(Message msg){
           this.msg=msg;
       }

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if (i%2==0){
                this.msg.set("王建","宇宙大帅哥");
            }else{
                this.msg.set("小高","猥琐第一人");
            }
        }
    }
}
//消费者
class Consumer implements Runnable{
private Message msg;
public Consumer(Message msg){
    this.msg=msg;
}
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println(this.msg.get());
        }
    }
}



//生产者消费者问题:三个角色：生产者、商品库、消费者；生产者向商品库中生产商品，消费者从商品库中消费商品
public class producer_consumer {
    public static void main(String[] args) {
        //Message在这里new的好处是消费者和生产者都是使用的同一个message，如果在consumer和producer中new的话，那就表明生产者和消费者使用的message不是一个了，就无所谓竞争了
        Message msg=new Message();
        new Thread(new Producer(msg)).start();
        new Thread(new Consumer(msg)).start();

    }


}
