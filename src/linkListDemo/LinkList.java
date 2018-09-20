package linkListDemo;

/**
 * @Author: li.feng
 * @Email: li.feng@rograndec.com
 * @CreateDate: 2018/9/20
 * @Version: 3.0
 */

public class LinkList<E> {
    //链表通常使用虚拟头节点，即创建一个空的头结点指向第一个具有值的元素，这样做是为了方便添加的时候操作
    //这个结点是0这个位置的元素的前一个节点，即头结点是另外声明的，节点的位置继续从0开始
    private Node dumpyHead;
    //链表中的元素个数
    private int size;
    public LinkList(){
        //初始化链表的时候有个空的头节点的，程序报错的原因是刚开始初始化的时候没有创建这个头节点
        dumpyHead=new Node(null,null);
        size=0;
    }
    private class Node{
       public E e;
       public  Node next;
       public Node(E e,Node next){
           this.e=e;
           this.next=next;
       }
       public Node(){
           this(null,null);
       }
    }
    //链表的操作无非增删该查
    //在链表头部插入元素
    public void addFirst(E e){
        addEle(0,e);

    }
    //在链表尾部插入元素
    public void addLast(E e){
        addEle(size,e);
    }
    //在链表头部删除元素
    public E delFirst(){
       return delEle(0);
    }
    //在链表尾部删除元素
    public E delLast(E e){
       return delEle(size-1);
    }
    //在链表中（中间插入，头部尾部插入可以直接调用此方法）插入元素
    public void addEle(int index,E e){

        Node prev=dumpyHead;
        //这里注意链表的头结点后面的真正节点还是从0开始，链表头不算0位置
        for(int i=0;i<index;i++){
            prev=prev.next;
        }
        //创建一个节点
//        Node node=new Node(e,null);
//        node.next=prev.next;
//        prev.next=node;
        prev.next=new Node(e,prev.next);
        size++;
    }
    //查找索引处的元素
    public E getEle(int index){
        //首先找到索引处
        Node currentNode=dumpyHead.next;
        for(int i=0;i<index;i++){
            currentNode=currentNode.next;
        }
        E ele=currentNode.e;
        return ele;
    }
    //删除指定结点处的元素
    public E delEle(int index){
        Node pre=dumpyHead;
        for(int i=0;i<index;i++){
            pre=pre.next;
        }
        E ele=pre.next.e;
        pre.next=pre.next.next;
        size--;
        return ele;
    }
    //修改指定结点处的元素
    public void updateEle(int index,E e){
        Node currentNode=dumpyHead.next;
        for(int i=0;i<index;i++){
            currentNode=currentNode.next;
        }
        currentNode.e=e;
    }
    //获取链表中具有元素的大小
    public int getCapacity(){
     return size;
    }
    //判断链表是否为空
    public boolean isEmpty(){
        return size==0;
    }
    @Override
    public String toString(){
        //链表的遍历
        StringBuilder res=new StringBuilder();
        res.append("head[");
        Node cur=dumpyHead.next;
        for(int i=0;i<size;i++){
            res.append(cur.e);
            cur=cur.next;
            if (cur!=null){
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}

//额外知识点补充：
// java的内部类，结点的值和指向的下一个结点
//成员内部类可以无条件访问外部类的所有成员属性和成员方法（包括private成员和静态成员）
  /*  内部类的主要作用如下：
    1. 内部类提供了更好的封装，可以把内部类隐藏在外部类之内，不允许同一个包中的其他类访问该类
    2. 内部类的方法可以直接访问外部类的所有数据，包括私有的数据
    3. 内部类所实现的功能使用外部类同样可以实现，只是有时使用内部类更方便
    */
