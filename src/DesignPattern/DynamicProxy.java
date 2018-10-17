package DesignPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/17
 * @Version: 1.0
 */
//动态代理的实现
public class DynamicProxy {
    public static void main(String[] args) {
        IPmessage msg=(IPmessage) new MldnProxy().bind(new PMessageReal());
        msg.send();
    }
}
interface IPmessage{
    public void send();
}
class PMessageReal implements IPmessage{
    @Override
    public void send() {
        System.out.println("消息发送。。。。。。。。。。。。");
    }
}
//利用代理方法控制来返回代理对象
class MldnProxy implements InvocationHandler{
    private Object target;
    public Object bind(Object target){
        this.target=target;
        //返回的代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    public boolean isConnected(){
        System.out.println("消息连接");
        return true;
    }
    public void closed(){
        System.out.println("消息连接关闭");
    }
    //代理主题类执行的操作都在invoke方法中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object data=null;
        if (this.isConnected()){
            data = method.invoke(this.target, args);

            this.closed();
        }
        return data;
    }
}


