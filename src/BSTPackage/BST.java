package BSTPackage;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/9/21
 * @Version: 1.0
 */
//二分搜索树也叫排序树；对二分搜索树添加元素的递归的起点优化
public class BST<E extends Comparable<E>> {
    public class Node{
        public E e;
        public Node left,right;
        public Node(E e){
            this.e=e;
            left=null;
            right=null;
        }
    }
    private Node root;
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
    public void addEle(E e){
        /*if (root==null){
            root=new Node(e);
        }*/
       root=add(root,e);
    }
    private Node add(Node node,E e){
        /*if (node.e.equals(e)){
            return;
        }else if(e.compareTo(node.e)<0 && node.left==null){
            node.left=new Node(e);
            size++;
            return;
        }else if(e.compareTo(node.e)>0 && node.right==null){
            node.right=new Node(e);
            size++;
            return;
        }*/
        if (node==null){
            size++;
           return new Node(e);
        }
        if (e.compareTo(node.e)<0){
            node.left=add(node.left,e);
        }else if(e.compareTo(node.e)>0){
            node.right=add(node.right,e);
        }
        return node;
    }
    //在二叉搜索树中查询某个元素是否存在
    public boolean contains(E e){
        return  isContains(root,e);
    }

    private boolean isContains(Node node, E e) {
        if (node==null){
            return false;
        }
        //如果该值与头结点相同则返回true
        if (node.e.compareTo(e) == 0) {
            return true;
        } else if (node.e.compareTo(e) < 0) {
            //判断子树左边的节点
            return isContains(node.left, e);
        } else if (node.e.compareTo(e) > 0) {
            //判断子树右边的节点
           return isContains(node.right, e);
        }
        return false;

    }
    //二分搜索树的前序遍历：根 左 右;递归实现
    public void  preOrder(){
        traversal(root);
    }

    private void traversal(Node root) {
        /*if (root==null){
            return;
        }*/
        if (root!=null) {
            System.out.println(root.e);
            traversal(root.left);
            traversal(root.right);
        }
    }
    //二分搜索树的前序遍历：非递归实现：主要是将节点，接着节点的右节点，左节点依次压入栈，再读取栈顶元素
    public void  preOrderNR(){
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur=stack.pop();
            System.out.println(cur.e);
            if (cur.right!=null){
                    stack.push(cur.right);
                if (cur.left!=null){
                    stack.push(cur.left);
                }
            }

        }
    }
    //二分搜索树的中序遍历：非递归实现：这里有点小技巧，也是利用栈：先将左子树压入栈，然后在利用出栈访问到右子树，然后再将右子树压入栈，循环出栈
    public void inOrderNR(){
        Stack<Node> stack=new Stack<>();
        Node p=root;
        while(p!=null ||!stack.isEmpty()){
            if (p!=null){
                stack.push(p);
                p=p.left;
            }else{
                p=stack.pop();
                System.out.println(p.e);
                p=p.right;
            }
        }
    }
    //二分搜索树的后遍历：非递归实现：根节点先入栈，再出栈，再根据判断条件入栈
    /*后序遍历递归定义：先左子树，后右子树，再根节点。
    后序遍历的难点在于：需要判断上次访问的节点是位于左子树，还是右子树。
    若是位于左子树，则需跳过根节点，先进入右子树，再回头访问根节点；
    若是位于右子树，则直接访问根节点*/
    public void postOrderNR(){
        if(root==null){
        return;}
        Stack<Node> s = new Stack<Node>();
        //当前访问的结点
        Node p =root;
        //上次访问的结点
        Node lastVisitNode=null;
        //把当前节点移到左子树的最下边：这个操作类似于中序遍历的第一步
        while(p!=null){
            s.push(p);
            p = p.left;
        }
        while(!s.empty()) {
            //弹出栈顶元素
            p = s.pop();
            //判断根节点是否需要访问：根据后序遍历的规则，如果右子树为空或右子树已经访问过，则下一步就是访问根节点
           //其实这一步是判断这个节点是否是根节点且是否访问过该节点的右子树，如果是根节点则再次入栈，访问右子树
            if (p.right != null && p.right != lastVisitNode) {
                //根节点再次入栈
                s.push(p);
                //进入右子树，且可肯定右子树一定不为空
                p = p.right;
                while (p != null) {
                    //再走到右子树的最左边
                    s.push(p);
                    p = p.left;
                }
            } else {
                //访问
                System.out.println(p.e);
                //修改最近被访问的节点
                lastVisitNode = p;
            }
        }
    }

    //二分搜索树的中序遍历： 左 根 右;递归实现
    //二分搜索树的中序遍历就是这些节点的升序排列
    public void inOrder(){
        inOrder(root);

    }
    private void inOrder(Node root){
        if (root!=null) {
            inOrder(root.left);
            System.out.println(root.e);
            inOrder(root.right);
        }
    }
    //二分搜索树的后序遍历： 左  右 根;递归实现
    public void postOrder(){
        postOrder(root);

    }
    private void postOrder(Node root){
        if (root!=null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.e);
        }
    }
    //二分搜索树的层次遍历（广度优先搜索）:利用队列来实现层次遍历：初始化：front为root；出：当前的根节点，入：节点的左右孩子
    public void levelOrder(){
        Queue<Node> q=new LinkedList<>();
        if (root!=null){
            q.add(root);
        }
        while(!q.isEmpty()){
            Node cur=q.remove();
            System.out.println(cur.e);
            if (cur.left!=null){
                q.add(cur.left);
            }
            if (cur.right!=null){
                q.add(cur.right);
            }
        }
    }
    //删除二分搜索树中的最大元素和最小元素
    //二分搜索树的定义就是节点的左孩子值比节点的值小，右孩子值比节点值大：则一直找该树的左侧节点指导左侧节点的左孩子为空，则找到最小的，一直找树的右孩子节点，直到右孩子的找到头，即右孩子的右孩子为空
   //删除二分搜索树中最小的元素：如果当前节点没有左节点，有右节点；这个时候将该节点的右孩子给节点的前一个节点
    public E deleMaxNode(){
        //返回要删除的最大节点的值
        E res=getMax();
        //递归处理删除节点后的树的情况
        root=deleMaxNode(root);
        return res;
    }
    private Node deleMaxNode(Node node){
        //递归的终止条件:最简单的一种情况，即没有右孩子了，则该节点就是要删除的节点
        if (node.right==null){
            //如果该节点还有左孩子，需要将左孩子修改位置
            Node leftNode=node.left;
            node.left=null;
            size--;
            return leftNode;
        }
        //递归逻辑:如果不是最终节点
        node.right=deleMaxNode(node.right);
        return node;
    }
    //删除最小元素所在的节点
    public E deleMinNode(){
        //返回要删除的最大节点的值
        E res=getMax();
        //递归处理删除节点后的树的情况
        root=deleMinNode(root);
        return res;
    }
    private Node deleMinNode(Node node){
        //递归的终止条件
        if (node.left==null){
            Node rightNode=node.right;
            node.right=null;
            size--;
            return rightNode;
        }
        //递归逻辑
        node.left=deleMinNode(node.left);
        return node;
    }

    //查找二分搜索树中的最大/最小值节点：递归实现
    public E getMax(){
        return getMax(root).e;

    }
    private Node getMax(Node node){
        if (node==null){
            throw new IllegalArgumentException("节点为空");
        }
        if (node.right==null){
            return node;
        }
      return getMax(node.right);
    }
    public E getMin(){
        return getMin(root).e;

    }
    private Node getMin(Node node){
        if (node.left==null){
            return node;
        }
        return getMin(node.left);
    }


    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        generateBstString(root,0,res);
        return res.toString();
    }
    private void generateBstString(Node node, int depth, StringBuilder res) {
        if (node==null){
            res.append(generateDepthString(depth)+"null\n");
            return;
        }
        res.append(generateDepthString(depth)+node.e+"null\n");
        generateBstString(node.left,depth+1,res);
        generateBstString(node.right,depth+1,res);
    }
    private String generateDepthString(int depth) {
        StringBuilder res=new StringBuilder();
        for (int i=0;i<depth;i++){
            res.append("--");
        }
        return res.toString();
    }


}
