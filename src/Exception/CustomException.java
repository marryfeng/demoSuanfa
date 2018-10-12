package Exception;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/12
 * @Version: 1.0
 */
//自定义异常的两种方式：
// 继承Exception或者继承RunntimeException

class BombExcetption extends Exception{
    public BombExcetption(String msg){
        super(msg);
    }
}
class Food{
    public static void eat(int num) throws BombExcetption {
        if (num>10){
            throw new BombExcetption("吃爆了，肚子撑死了");
        }else{
            System.out.println("继续吃，不怕胖");
        }
    }
}

public class CustomException {
    public static void main(String[] args) throws BombExcetption {
        Food.eat(11);
    }
}
