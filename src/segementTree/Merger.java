package segementTree;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/10
 * @Version: 1.0
 */

public interface Merger<E> {
    E merge(E a,E b);
}
