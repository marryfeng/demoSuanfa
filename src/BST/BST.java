package BST;



/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/9/21
 * @Version: 1.0
 */
//二分搜索树的相关实现:二分搜索树是二叉树的的进化，规则是：节点的左孩子都小于该节点，节点的右孩子都大于该节点，所以创建的时候这棵树的节点之间需要有可对比性
public class BST<E extends Comparable<E>> {

    //其实树的结构与链表类似，定义节点的结构
    public class Node{
        //节点值
        public E e;
        //节点的左右孩子
        public Node left,right;
        public Node(E e){
            this.e=e;
            left=null;
            right=null;
        }
    }
    //定义BST的成员变量
    //根节点
    private Node root;
    //共有多少给节点
    private int size;
    public BST(){
        root=null;
        size=0;
    }

    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    //向树中添加元素
    public void addEle(E e){
        //判断根节点是否存在，如果存在则进行比较，如果不存在在为根节点
        if (root==null){
           root=new Node(e);
           size++;
        }else{
           //如果根节点存在，则比较传入的值与节点的大小：大则放入右子树中，小则放入左子树中
            add(root,e);
        }
    }
    //二分搜索树的递归调用;这里的二分搜索树是没有重复元素的
    private void add(Node node,E e){
        //递归里面终止条件的编码：即最简单的一种情况的编码
        //1、该节点与根几点值一样，返回
        if(node.equals(e)){
            return;
            //比较节点与根节点的大小，如果小则位于左子树，如果刚好左子树为空，则直接插入即可
        }else if (e.compareTo(node.e)<0 && node.left==null){
            node.left=new Node(e);
            size++;
            return;
            //比较节点与根节点的大小，如果大则位于右子树，如果刚好右子树为空，则直接插入即可
        }else if (e.compareTo(node.e)>0 && node.left==null){
            node.right=new Node(e);
            size++;
            return;
        }
        //上面这些是我们考虑递归的终止条件,下面是就是递归的调用了:即复杂情况下左右子树都有的情况
        //首先位于左边的情况
        if (e.compareTo(node.e)<0){
            add(node.left,e);
        }else{
            //位于右边的情况
            add(node.right,e);
        }
    }


}
