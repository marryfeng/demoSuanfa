package DesignPattern;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/17
 * @Version: 1.0
 *
 *
 */
//静态代理设计模式：一个代理类只为一个接口服务
public class ProxyDemo {
    public static void main(String[] args) {
        Imessage msg = new MessgeProxy(new MessageReal());
        msg.send();
    }
}
interface Imessage{
    public void send();
}
class MessageReal implements Imessage{
    @Override
    public void send() {
        System.out.println("消息发送。。。。。。。。。。。。");
    }
}
class MessgeProxy implements Imessage{
    private Imessage imessage;
    public MessgeProxy(Imessage imessage){
     this.imessage=imessage;
    }
    @Override
    public void send() {
        if (this.isConnected()){
            this.imessage.send();
            this.closed();
        }
    }
    public boolean isConnected(){
        System.out.println("消息连接");
        return true;
    }
    public void closed(){
        System.out.println("消息连接关闭");
    }
}

