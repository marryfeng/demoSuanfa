package thread;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/11
 * @Version: 1.0
 */
class NameThread implements Runnable{
    @Override
    public void run() {
        //获取当前线程的名称
        System.out.println(Thread.currentThread().getName());
    }
}
//线程命名
public class ThreadName {
    public static void main(String[] args){
        NameThread nt=new NameThread();
        //线程的命名：static类型
        new Thread(nt,"线程a").start();
        //当没有命名的时候，则会生成一个不重复的名字：这个编号如何实现的：源码：这种属性命名主要是依靠了static属性完成的
      /*  private static int threadInitNumber;
        private static synchronized int nextThreadNum() {
            return threadInitNumber++;

            这里隐含了一个知识点：利用static的特性实现自动命名
        }*/
        new Thread(nt).start();
        new Thread(nt,"线程c").start();
        new Thread(nt,"线程d").start();
    }
}
