package queueDemo;

/**
 * @Author: li.feng
 * @Email: li.feng@rograndec.com
 * @CreateDate: 2018/9/18
 * @Version: 3.0
 */

public class ArrayQueue<E> implements Queue<E>{
    Array<E> arr=new Array<>();
    @Override
    public void enQueue(E e) {
        arr.addLastElemplt(e);

    }

    @Override
    public void deQueue() {
        arr.deleteEle(0);

    }

    @Override
    public int getSize() {
        return arr.getSize();
    }

    @Override
    public E getFront() {
        return arr.getEle(0);
    }

    @Override
    public boolean isEmpty() {
        return arr.isEmpty();
    }
    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("queue top:[");
        for (int i=0;i<arr.getSize();i++){
            res.append(arr.getEle(i));
            if (i!=arr.getSize()-1){
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
