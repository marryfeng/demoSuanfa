package BST;


/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/9/21
 * @Version: 1.0
 */
//对二分搜索树添加元素的递归的起点优化
public class BSTGaiJin<E extends Comparable<E>> {
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
    public BSTGaiJin(){
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


}
