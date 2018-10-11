package JUC;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/10
 * @Version: 1.0
 */

public class TestAutomaticDemo {
    public static void main(String[] args){
        AutomaticDemo at=new AutomaticDemo();
        for (int i=0;i<10;i++){
            new Thread(at).start();
        }
    }
}
