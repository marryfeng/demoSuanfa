package linkListDemo;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/9/20
 * @Version: 1.0
 */
//双向链表实现
public class ShuangXiangLink<E> {
    private Node dummyHead;
    private int size;
    //定义双向链表的节点:节点值，前驱和后驱节点
    public class Node{
      public  E e;
      public Node prev,next;
      //构造方法就是在new的时候使用
      public Node(E e,Node prev,Node next){
          this.e=e;
          this.prev=prev;
          this.next=next;
      }
      public Node(){
          this(null,null,null);
      }
    }
    //利用虚拟头节点（实现更方便些）
    public ShuangXiangLink(){
        dummyHead=new Node(null,null,null);
        size=0;
    }
    //双向链表无非也是增删该查

}
