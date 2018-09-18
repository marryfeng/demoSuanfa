package stackDemo;

/**
 * @Author: li.feng
 * @Email: li.feng@rograndec.com
 * @CreateDate: 2018/9/18
 * @Version: 3.0
 */

public class ArrayStack<E> implements Stack<E> {
    Array<E> arr=new Array<>();

    @Override
    public int getSize() {
        return arr.getSize();
    }

//栈的操作都是从栈顶进行的，向栈中放入元素，都是从栈顶进行的，相当于从数组的末尾添加元素
@Override
  public void push(E e) {
        arr.addLastElemplt(e);
 }
//取出元素相当于从数组的末尾取出元素
    @Override
    public E pop() {
        return arr.deleteEle(arr.getSize()-1);
    }

    @Override
    public E peek() {
        return arr.getEle(arr.getSize()-1);
    }

    @Override
    public Boolean isEmpty() {
        return arr.isEmpty();
    }
    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("stack:[");
        for (int i=0;i<arr.getSize();i++){
            res.append(arr.getEle(i));
            if (i!=arr.getSize()-1){
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
