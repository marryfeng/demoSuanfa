package linkListDemo;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/9/20
 * @Version: 1.0
 */
//优化链表结构来实现队列：队列的特点是先进先出，头部删除，尾部添加；如果使用虚拟头节点的，尾部添加的复杂度是O(N);
    //优化是在尾部添加一个尾指针指向最后一个元素，则尾部添加的复杂度为O(1)
    //这里的主要操作是维护头尾指针的指向元素
public class LinkQueueNoDummyHead<E> implements Queue<E> {
    //定义头指针尾指针
    //当链表为空的时候：head==tail
    private Node head,tail;
    private int size;
    public LinkQueueNoDummyHead(){
        head=null;
        tail=null;
        size=0;
    }
    //定义节点
    public class Node{
        public E e;
        public Node next;
        public Node(E e,Node next){
            this.e=e;
            this.next=next;
        }
        public Node(){
            this(null,null);
        }
    }
    @Override
    public void enQueue(E e) {
        //队列的入队：尾部入队
        if (tail==null){
            //如果tail为空，则链表的头也是空的，因为tail指向的是链表的最后一个结点
            //当插入一个元素的时候，链表要创建一个新节点
            tail=new Node(e,null);
            head=tail;
            size++;
        }

    }

    @Override
    public void deQueue() {
        //队列删除一个节点，是从队头删除
        if(isEmpty()){
            throw new IllegalArgumentException("链表为空");
        }
        head=head.next;
        size--;
        if (head==null){
            tail=null;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
             throw new IllegalArgumentException("链表为空");
        }
        return head.e;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
}
