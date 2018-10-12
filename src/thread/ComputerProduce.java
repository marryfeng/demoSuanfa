package thread;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/12
 * @Version: 1.0
 */
//设计一个生产电脑和取走电脑的类，要求：生产出一台电脑就搬走，没有电脑就等待生产。电脑没搬走就等待生产，并统计电脑数量

class ResourceComputer{
    private String computerName;
    private Double price;
    private int count=0;
    private boolean  flag=false;

    public String getComputerName() {
        return computerName;
    }

    public Double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    //如果为true则表示可以生产，如果为false，则表示不能生产，可以消费
    public ResourceComputer(String computerName,Double price){
        this.computerName=computerName;
        this.price=price;
    }
    public synchronized void make() throws InterruptedException {
        if (this.flag==false){
            super.wait();
        }
        this.count++;
        this.flag=false;
        super.notify();
    }
    public synchronized void  get() throws InterruptedException {
        if (this.flag==true){
            super.wait();
        }
        this.count--;
        this.flag=true;
        super.notify();
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
                resourceComputer.make();
                System.out.println(Thread.currentThread()+"生产电脑者"+this.resourceComputer.getComputerName()+this.resourceComputer.getPrice()+this.resourceComputer.getCount());
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
                resourceComputer.get();
                System.out.println(Thread.currentThread()+"消费电脑者"+this.resourceComputer.getComputerName()+this.resourceComputer.getPrice()+this.resourceComputer.getCount());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}




public class ComputerProduce {
    public static void main(String[] args) {
        ResourceComputer rc=new ResourceComputer("戴尔",1.1);
        new Thread(new ProCom(rc),"生产电脑者").start();
        new Thread(new ConCom(rc),"消费电脑者").start();


    }
}
