package queueDemo;

/**
 * @Author: li.feng
 * @Email: li.feng@rograndec.com
 * @CreateDate: 2018/9/19
 * @Version: 3.0
 */
//循环队列的实现
public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front;
    private int tail;
    private int size;
    //这里的capacity指的是data.length
    public LoopQueue(int capacity){
        //这里为了区分队列为空和队列为满的情况，有意识的浪费了一个空间，即空间多加1个
        data=(E[]) new Object[capacity+1];
        //指向队首元素
        int front=0;
        //指向队尾元素
        int tail=0;
        //队列中元素的个数
        int size;

    }
    public LoopQueue(){
        this(10);
    }
//循环队列入队：按照队列的原则：队尾入队；即数组末尾添加元素；考虑扩容的现象
    @Override
    public void enQueue(E e) {
        //如果队列满则进行扩容
        if((tail+1)%data.length==front){
            resize(getCapacity()*2);
        }
        //在队尾添加元素，并修改队尾的指向
        data[tail]=e;
        tail=(tail+1)%data.length;
        size++;
    }

    private void resize(int capacity) {
        //同样浪费一个空间，
        E[] newData=(E[])new Object[capacity+1];
        //将原队列中的元素复制到新队列中
        for(int i=0;i<size;i++){
            //因为循环队列有可能前面有空的位置，元素在中间,其实这里取余不取余没关系
            newData[i]=data[(i+front)%data.length];
        }
        data=newData;
        front=0;
        tail=size;
    }

    public int getCapacity(){
        return data.length-1;
    }
//循环队列出队，出队即从front出队，考虑缩容现象
    @Override
    public void deQueue() {
        if(isEmpty()){
            throw new IllegalArgumentException("队列中元素为空");
        }
        data[front]=null;
        //队首指向改变
        front=(front+1)%data.length;
        size--;
        if (size==getCapacity()/4 && getCapacity()/2!=0){
            resize(getCapacity()/2);
        }
    }
//循环队列中元素个数
    @Override
    public int getSize() {
        return size;
    }
//获取循环队列中队首元素
    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("队列中元素为空");
        }
        return data[front];
    }
//循环队列为空的条件是：front==tail,循环队列满的条件是：(tail+1)%queueLength==front
    @Override
    public boolean isEmpty() {
        return front==tail;
    }
    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("front[");
//        for(int i=0;i<size;i++){
//            res.append(data[i+front%data.length]);
//            if (i!=size-1){
//                res.append(", ");
//            }
//        }
        //另外一种实现方式
        for(int i=front;i!=tail;i=(i+1)%data.length){
            res.append(data[i]);
            if ((i+1)%data.length!=tail){
                res.append(", ");
            }
        }
        res.append("]tail");
        return res.toString();
    }
}
