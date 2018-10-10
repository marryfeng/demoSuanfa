package segementTree;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/10
 * @Version: 1.0
 */
//线段树的
public class SegementTree<E> {
    //线段树的存储也是用数组存储的
    private E[] tree;
    private E[] data;
    private Merger<E> merger;
    public SegementTree(E[] arr,Merger<E> merger){
        this.merger=merger;
        data=(E[])new Object[arr.length];
        for (int i=0;i<arr.length;i++){
            data[i]=arr[i];
        }
        //线段树需要4倍的n给元素来存储
        tree=(E[])new Object[4*arr.length];
        //创建线段树：传入树的根节点和元素的区间范围，利用树的左右孩子来构建线段树的根
        buildSegementTree(0,0,data.length-1);
    }

    private void buildSegementTree(int treeIndex, int l, int r) {
        //递归到底的情况是，只有一个节点
        if (l==r){
            tree[treeIndex]=data[r];
            return;
        }
        //如果数组中不止一个元素就要采用分治的思想进行划分:类似于归并排序，每个节点的值由该节点的两个孩子决定
        //左右节点的索引
        int leftTreeIndex=leftChild(treeIndex);
        int rightTreeIndex=rightChild(treeIndex);
        int mid=l+(r-l)/2;
        buildSegementTree(leftTreeIndex,l,mid);
        buildSegementTree(rightTreeIndex,mid+1,r);
        //这一步才是处理根节点的值是多少：这个节点的值则根据业务来做，有的是求和有的是求积，等等
        E d=tree[leftTreeIndex];
        E m=tree[rightTreeIndex];
        tree[treeIndex]=merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);

    }
    //线段树的查询操作:查询某个区间内的结果值
    public E query(int queryL,int queryR){
        //这个也是递归操作
      return   query(0,0,data.length-1,queryL,queryR);
    }
    public E query(int treeIndex,int l,int r,int queryL,int queryR){
        //递归的终止条件是l==query L，r=queryR
        if (l==queryL && r==queryR){
            return tree[treeIndex];
        }
        //判断查询的区间是在那个区间段内
        int mid=l+(r-l)/2;
        int leftTreeIndex=leftChild(treeIndex);
        int rightTreeIndex=rightChild(treeIndex);
        if (queryR<=mid){
            //则在左区间[l,mid]
          return query(leftTreeIndex,l,mid,queryL,queryR);
        }else if(queryL>=mid+1){
           return query(rightTreeIndex,mid+1,r,queryL,queryR);
        }
        //否则是一段在左区间，一段在右区间
        E leftQuery=query(leftTreeIndex,l,mid,queryL,mid);
        E  rightQuery=query(rightTreeIndex,mid+1,r,mid+1,queryR);
       return merger.merge(leftQuery,rightQuery);
    }

    public int getSize(){
        return data.length;
    }
    public E getIndex(int index){
        return data[index];
    }
    private int leftChild(int index){
        return 2*index+1;
    }
    private int rightChild(int index){
        return 2*index+2;
    }
    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("[");
        for (int i=0;i<tree.length;i++){
            if (tree[i]!=null){
            res.append(tree[i]);
            }else{
                res.append("null");
            }
            if (i!=tree.length-1){
                res.append(" ,");
            }
        }
        return res.toString();
    }
}
