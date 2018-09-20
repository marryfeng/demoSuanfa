package leetcode;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/9/20
 * @Version: 1.0
 */
//删除链表中值为val的节点:使用虚拟节点
    //比如：val=4;   23445 删除后是：235
public class Solution2 {
    public ListNode removeElements(ListNode head,int val){
        /*//判断头结点是不是要删除的元素，因为删除涉及到节点的前驱节点:这里使用while是因为如果接着下一个头节点也是要删除的元素的值
        while (head!=null && head.val==val){
            head=head.next;
        }
        if (head==null) {
            return null;
        }*/
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        //否则就是中间节点的删除
        ListNode prev=dummyHead;
        while(prev.next!=null){
            if (prev.next.val==val){
                prev.next=prev.next.next;
            }else{
                prev=prev.next;
            }
        }
        return dummyHead.next;
    }
    //总结：如果不适用虚拟头结点，删除的时候需要注意head的前驱，因为不用虚拟头结点，前驱不存在。
}
