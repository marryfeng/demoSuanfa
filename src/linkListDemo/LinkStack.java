package linkListDemo;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/9/20
 * @Version: 1.0
 */
//利用链表来实现栈：栈的规则是先入的在栈底，新入的在栈顶。刚好是链表中的在链表的头部插入数据的操作：每次新插入的元素在最前面
public class LinkStack<E> implements Stack<E> {
    LinkList<E> linkList=new LinkList<>();

    @Override
    public int getSize() {
        return linkList.getCapacity();
    }

    @Override
    public void push(E e) {
        linkList.addFirst(e);

    }

    @Override
    public E pop() {
        return linkList.delFirst();
    }

    @Override
    public E peek() {
        return linkList.getEle(0);
    }

    @Override
    public Boolean isEmpty() {
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
        LinkStack<Integer> linkStack=new LinkStack<>();
        for(int i=0;i<5;i++){
            linkStack.push(i);
        }
        System.out.println(linkStack);
        linkStack.pop();
        System.out.println(linkStack);
        System.out.println(linkStack.peek());

    }
}
