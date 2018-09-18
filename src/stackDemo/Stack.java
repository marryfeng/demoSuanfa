package stackDemo;

/**
 * @Author: li.feng
 * @Email: li.feng@rograndec.com
 * @CreateDate: 2018/9/18
 * @Version: 3.0
 */

public interface Stack<E> {
    //查看栈元素个数
    int getSize();
    //向栈中放入元素
     void push(E e);
    //从栈中取出元素
    E pop();
    //查看栈顶元素
    E peek();
    //判断栈中元素是否为空
    Boolean isEmpty();
}
