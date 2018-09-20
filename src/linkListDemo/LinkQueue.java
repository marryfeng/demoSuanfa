package linkListDemo;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/9/20
 * @Version: 1.0
 */
//利用链表来实现队列：使用带有虚拟头结点的底层实现
public class LinkQueue<E> implements Queue<E> {
    LinkList<E> linkList=new LinkList<>();
    @Override
    public void enQueue(E e) {
        linkList.addLast(e);

    }

    @Override
    public void deQueue() {
        linkList.delFirst();

    }

    @Override
    public int getSize() {
        return linkList.getCapacity();
    }

    @Override
    public E getFront() {
        return linkList.getEle(0);
    }

    @Override
    public boolean isEmpty() {
        return linkList.isEmpty();
    }
    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("stack[");
        for(int i=0;i<linkList.getCapacity();i++){
            res.append(linkList.getEle(i));
            if (i!=linkList.getCapacity()-1){
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
    public static void main(String[] args){
        LinkQueue<Integer> linkQueue=new LinkQueue<>();
        for(int i=0;i<5;i++){
            linkQueue.enQueue(i);
        }
        System.out.println(linkQueue);
        linkQueue.deQueue();
        System.out.println(linkQueue);
        System.out.println(linkQueue.getFront());

    }
}
