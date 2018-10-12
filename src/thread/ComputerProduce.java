package thread;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/12
 * @Version: 1.0
 */
//设计一个生产电脑和取走电脑的类，要求：生产出一台电脑就搬走，没有电脑就等待生产。电脑没搬走就等待生产，并统计电脑数量
class Computer{
    private static int count=0;
    private String computerName;
    private Double price;
    public Computer(String name,Double price){
        this.computerName=name;
        this.price=price;
        count++;
    }
}
class ResourceComputer{
   private Computer computer;
    //如果为true则表示可以生产，如果为false，则表示不能生产，可以消费
    public synchronized void make() throws InterruptedException {
        if (this.computer!=null){
            super.wait();
        }
        this.computer=new Computer("电脑",1.1);
        super.notifyAll();
    }
    public synchronized void  get() throws InterruptedException {
        if (this.computer==null){
            super.wait();
        }
        System.out.println(this.computer);
        this.computer=null;
        super.notifyAll();
    }
}
class ProCom implements Runnable{
    private ResourceComputer resourceComputer;
    public ProCom(ResourceComputer resourceComputer){
        this.resourceComputer=resourceComputer;
    }
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            try {
               this.resourceComputer.make();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class ConCom implements Runnable{
    private ResourceComputer resourceComputer;
    public ConCom(ResourceComputer resourceComputer){
        this.resourceComputer=resourceComputer;
    }
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            try {
                this.resourceComputer.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}




public class ComputerProduce {
    public static void main(String[] args) {
        ResourceComputer rc=new ResourceComputer();
        ProCom p=new ProCom(rc);
        new Thread(p,"生产电脑者").start();
        ConCom c = new ConCom(rc);
        new Thread(c,"消费电脑者").start();


    }
}
