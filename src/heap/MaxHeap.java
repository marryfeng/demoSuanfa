package heap;


import java.util.Random;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/9/30
 * @Version: 1.0
 */
//大顶堆的创建：这里使用动态数组来创建堆，比较方便，比使用树的node结构方便
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> array;

    public MaxHeap(int capaticy){
        array=new Array<>(capaticy);
    }
    public MaxHeap(){
        array=new Array<>();
    }
    //获取堆的大小
    public int getSize(){
        return array.getSize();
    }
    //判断堆是否为空
    public boolean isEmpty(){
        return array.isEmpty();
    }
    //这里的堆是根节点的索引是0开始
    //获取堆中某节点的父节点的索引:parent(i)=(i-1)/2
    public int getParentIndex(int index){
        return (index-1)/2;
    }
    //获取某节点的左孩子的索引
    public int getLeftChildIndex(int index){
        return 2*index+1;
    }
    //获取某节点的右孩子的索引
    public int getRightChildIndex(int index){
        return 2*index+2;
    }
    //向堆中添加元素：这也是一个建立大顶堆的过程。因为堆是完全二叉树，用数组顺序存储的，所以相当于在数组的末尾添加元素；然后比较元素与它的父节点的关系，如果小于则上浮结束，如果大于则上浮
    public void insertHeapEle(E e){
        array.addLastElemplt(e);
        siftUp(array.getSize()-1);
        //如果插入的元素比它的父节点的值大，则进行交换

    }
    public void bianliHeap(){
        for (int i=0;i<array.getSize();i++){
            System.out.println(array.getEle(i));
        }

    }
    //元素上浮的过程
    private void siftUp(int k){
        while(k>0 && array.getEle(k).compareTo(array.getEle(getParentIndex(k)))>0){
            array.swap(k,getParentIndex(k));
            k=getParentIndex(k);
        }

    }

  public E findMax(){
      if (array.getSize()==0){
          //堆中无最大元素
          throw new IllegalArgumentException("堆中无最大元素");
      }
      return array.getEle(0);

  }
    //向堆中删除最大节点的元素：因为我们建立的是大顶堆，所以堆的顶部就是最大的那个元素，将末尾元素放到堆顶，删除末尾元素，然后执行下沉操作：比较左右孩子节点的大小,取左右节点中最大的那个节点与堆顶元素替换。依次循环
    public E delMax(){
      E res=findMax();
      //将堆顶元素与末尾元素交换位置
      array.swap(0,array.getSize()-1);
      //删除末尾元素
      array.deleteEle(array.getSize()-1);
      //调整堆，进行下沉操作
      siftDown(0);
      return res;
  }
  private void siftDown(int k){
        //k这个位置都已经没有孩子了，即k为叶子节点，那就下沉结束。即k的左孩子的索引都越界了则这个k肯定没有孩子了
        while(getLeftChildIndex(k)<array.getSize()){
            //找出k的左右孩子中最大的那一个，然后交换k与最大的那个位置,首先假设最大的那个索引是left孩子
            int j=getLeftChildIndex(k);
            //判断是否存在右孩子且是否比左孩子节点的值要大:j+1<array.getSize()即存在右孩子
            if (j+1<array.getSize() && array.getEle(j).compareTo(array.getEle(j+1))<0){
                j=getRightChildIndex(k);
            }
            //此时array[j]就是最大的那个节点,再比较该节点与k节点值的大小
            if (array.getEle(j).compareTo(array.getEle(k))>0){
                array.swap(j,k);
            }else{
                break;
            }
            k=j;
        }
  }
  //replace操作取出最大元素，再放入一个新的元素
    //思路：直接将新元素替换掉堆中最大的元素，然后再执行下沉操作
  public E heapReplace(E e){
      //堆中最大的元素就是堆顶的元素
     E res=findMax();
      array.setEle(0,e);
      siftDown(0);
      return res;
  }
  //将任意数组建成一个大顶堆：思路：从最后一个非叶子节点开始执行下沉操作，直到堆顶
  public void heapify(E[] arr){
      array=new Array<>(arr);
      //最后一个非叶子节点的索引是：最后一个节点的父亲节点的索引
      for(int i=getParentIndex(arr.length-1);i>=0;i--){
          siftDown(i);
      }

  }
    public static void main(String[] args){
        MaxHeap<Integer> maxHeap=new MaxHeap<>();
        int n=100;
        Random random=new Random();
        for (int i=0;i<n;i++){
            maxHeap.insertHeapEle(random.nextInt(1000));
        }
        Integer[] arr=new Integer[n];
        for (int i=0;i<n;i++){
            arr[i]=maxHeap.delMax();
        }
        for (int i=1;i<n;i++){
            if (arr[i-1]<arr[i]){
                throw new IllegalArgumentException("DDD");
            }else{
                System.out.println("success");
            }
        }
    }

}
