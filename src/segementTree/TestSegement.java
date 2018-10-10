package segementTree;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/10
 * @Version: 1.0
 */

public class TestSegement {
    public static void main(String[] args){
        Integer[] arr={1,2,3,4};
        /*SegementTree<Integer> tree=new SegementTree<Integer>(arr, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a+b;
            }
        });*/
        SegementTree<Integer> tree=new SegementTree<Integer>(arr,(a,b)->a+b);
        System.out.println(tree);
        System.out.println(tree.query(0,2));
    }
}
