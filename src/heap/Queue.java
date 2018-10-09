package heap;

/**
 * @Author: li.feng
 * @Email: li.feng@rograndec.com
 * @CreateDate: 2018/9/18
 * @Version: 3.0
 */
//队列基本上是这几种操作
public interface Queue<E> {
    //入队
    void enQueue(E e);
    //出队
    void deQueue();
    int getSize();
    E getFront();
    boolean isEmpty();

}
