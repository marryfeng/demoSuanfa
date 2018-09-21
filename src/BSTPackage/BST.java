package BSTPackage;


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
    //二分搜索树的中序遍历： 左 根 右;递归实现
    //二分搜索树的中序遍历就是这些节点的升序排列
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
