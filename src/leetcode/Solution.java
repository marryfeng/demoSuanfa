package leetcode;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/9/20
 * @Version: 1.0
 */
//删除链表中值为val的节点:此处没使用虚拟头节点
    //比如：val=4;   23445 删除后是：235
public class Solution {
    public ListNode removeElements(ListNode head,int val){
        //判断头结点是不是要删除的元素:这里使用while是因为如果接着下一个头节点也是要删除的元素的值
        while (head!=null && head.val==val){
            head=head.next;
        }
        if (head==null) {
            return null;
        }
        //否则就是中间节点的删除
        ListNode prev=head;
        while(prev.next!=null){
            if (prev.next.val==val){
                prev.next=prev.next.next;
            }else{
                prev=prev.next;
            }
        }
        return head;
    }
    public static void main(String[] args){
        int[] num={1,2,3,6,4,5,6};
        ListNode listNode=new ListNode(num);
        System.out.println(listNode);
        new Solution().removeElements(listNode,6);
        System.out.println(listNode);
    }
}
