package leetcode;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/9/20
 * @Version: 1.0
 */

public class ListNode {
    int val;
    ListNode next;
    public ListNode(int x){
        val=x;
    }
    //将一个数组传入，利用数组中的元素构建一个链表
    public ListNode(int[] arr){
        //这里涉及到this的用法
     /*   一、指自己所在的对象。
        比如在一个方法中，调用其他对象的变量或方法时，可以使用那个对象的对象名，比如aa.abc();
        而调用自己所在对象的方法或变量时，不知道别人给起了什么名，所以直接用this.abc()就可以了*/
        this.val=arr[0];
        //不用new一个新的对象，当前对象即可，这是在构造函数中
        ListNode cur=this;
        for (int i=1;i<arr.length;i++){
             cur.next=new ListNode(arr[i]);
             cur=cur.next;
        }
    }
    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("Node[");
        //这里还是当前这个类即这个节点
        ListNode cur=this;
       while (cur!=null){
           res.append(cur.val+"-> ");
           cur=cur.next;
       }
       res.append("]");
       return res.toString();
    }
}
