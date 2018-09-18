package queueDemo;

/**
 * @Author: li.feng
 * @Email: li.feng@rograndec.com
 * @CreateDate: 2018/9/18
 * @Version: 3.0
 */

public interface Queue<E> {
    //向队列中添加元素，相当于在数组的尾部添加元素
    void enQueue(E e);
    //向队列中删除元素，相当于在头部删除元素
    void deQueue();
    int getSize();
    E getFront();
    boolean isEmpty();

}
