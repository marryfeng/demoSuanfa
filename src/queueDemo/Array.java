package queueDemo;

/**
 * @Author: li.feng
 * @Email: li.feng@rograndec.com
 * @CreateDate: 2018/9/18
 * @Version: 3.0
 */
//数组泛型：元素可以是任意类型
public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity){
        //data=new int[capacity];
        data=(E[])new Object[capacity];
    }
    public Array(){
        this(10);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public int getCapacity(){
        return data.length;
    }
    public boolean isEmpty(){
        return size==0;
    }
    //向元素末尾添加一个元素
    public void addLastElemplt(E e){
       this.insertEle(size,e);
    }
    //向数组头添加元素
    public void addFirstElemplt(E e){
        this.insertEle(0,e);
    }
    //向数组中插入一个元素,元素逐个向后移动
    public void insertEle(int index,E e){

        //如果i>size的话，数组中的元素就不是连续的了，这是不合法的
        if(index>size || index<0){
            throw  new IllegalArgumentException("添加元素失败");
        }
        /*if (size==data.length){
            throw  new IllegalArgumentException("添加元素失败");
        }*/
        //数组进行扩容
        if(size==data.length){
            resize(2*data.length);
        }
        //元素由后向前逐个移动
        for(int i=size-1;i>=index;i--) {
            data[i+1] = data[i];
        }
        data[index]=e;
        size++;

    }

    private void resize(int newLength) {
        E[] newData=(E[])new Object[newLength];
        for(int i=0;i<size;i++){
           newData[i]=data[i];
        }
        data=newData;
    }

    //从数组中删除元素
    public E deleteEle(int index){
        if (index<0 || index>=size){
            throw  new IllegalArgumentException("索引无效");
        }
        E e=getEle(index);
       for(int i=index+1;i<size;i++){
            data[i-1]=data[i];
       }
       size--;
        if(size==data.length/2){
            resize(data.length/2);
        }
        return e;
    }
    E getEle(int index){
        if(index<0 || index>size){
            throw  new IllegalArgumentException("添加元素失败");
        }
        return data[index];
    }
    E setEle(int index,E e){
        if(index<0 || index>size){
            throw  new IllegalArgumentException("添加元素失败");
        }
       return data[index]=e;
    }
    //重写Object的toString方法，其实就是规定数据输出的格式
    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append(String.format("Array: size=%d, Capacity=%d\n",size,data.length));
        res.append("[");
        for (int i=0;i<size;i++){
            res.append(data[i]);
            if(i!=size-1){
                res.append(", ");
            }
        }
        res.append("]");

        return res.toString();
    }
}
