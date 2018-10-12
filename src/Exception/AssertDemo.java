package Exception;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/12
 * @Version: 1.0
 */
//断言assert：确定代码执行到某行之后一定是所期待的结果，但是结果不一定是准确的，也可能出现偏差，这种偏差不影响程序的正常执行
public class AssertDemo {
    public static void main(String[] args) {
        int m=10;
        assert m==100;
        System.out.println(m);

    }
}
