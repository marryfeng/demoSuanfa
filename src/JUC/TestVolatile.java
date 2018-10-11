package JUC;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/10
 * @Version: 1.0
 */

public class TestVolatile {

    public static void main(String[] args){
        ThreadDemo td=new ThreadDemo();
        new Thread(td).start();
        while(true) {
//            synchronized (td) {
                if (td.isFlag()) {
                    System.out.println("####################");
                    break;
                }
            }

    }

}
