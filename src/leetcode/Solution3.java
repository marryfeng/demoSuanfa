package leetcode;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/9/20
 * @Version: 1.0
 */
//使用递归来解决leetcode删除链表中值为val的节点
public class Solution3 {
    public ListNode removeElements(ListNode head,int val) {
        //递归的第一步就是首先写出问题规模最小的时候的一种情况：即最简单的一种模式是什么
        if (head==null){
            return  null;
        }
        //第二步：如何将大规模问题缩小为小规模问题
        /*ListNode listNode=removeElements(head.next,val);
        if (head.val==val){
            return listNode;
        }else{
            head.next=listNode;
            return head;
        }*/
        //也可以这样简写
        head.next=removeElements(head.next,val);
        return head.val==val? head.next:head;

    }
}
