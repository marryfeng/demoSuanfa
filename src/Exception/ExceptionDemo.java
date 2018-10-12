package Exception;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/12
 * @Version: 1.0
 */
//异常处理：try，catch，finally，throw，throws
class MathCalculate {
    public static int dividend(int a, int b) throws Exception {
        int temp = 0;
        System.out.println("执行除法开始。。。。。。。。。。。。。。");
        //可以将商品catch与throw简化，直接使用上面的throws来抛出异常
         /*try {
            temp = a / b;
        } catch (Exception e){
            throw e;
        }finally {
            //代码向上移动 一行的快捷键：alt+PgUp
            System.out.println("执行除法结束。。。。。。。。。。。。。。");
        }*/
        try {
            temp = a / b;
        } finally {
            //代码向上移动 一行的快捷键：alt+PgUp
            System.out.println("执行除法结束。。。。。。。。。。。。。。");
        }
        return temp;
    }
}

public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            System.out.println(MathCalculate.dividend(10, 2));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
