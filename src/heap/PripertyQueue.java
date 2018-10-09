package heap;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/9
 * @Version: 1.0
 */

public class PripertyQueue<E extends Comparable<E>> implements Queue<E> {
    private MaxHeap<E> maxHeap;
    public PripertyQueue(){
        maxHeap=new MaxHeap<>();
    }
    @Override
    public void enQueue(E e) {
        maxHeap.insertHeapEle(e);
    }

    @Override
    public void deQueue() {
        maxHeap.delMax();

    }

    @Override
    public int getSize() {
        return maxHeap.getSize();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}
