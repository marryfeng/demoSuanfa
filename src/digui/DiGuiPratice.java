package digui;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/9/21
 * @Version: 1.0
 */
//递归求5！
public class DiGuiPratice {
    public int getJieCheng(int s){
        if (s==1){
            return 1;
        }
       return s* getJieCheng((s-1));
    }


    public static void main(String[] args){
        System.out.println(new DiGuiPratice().getJieCheng(5));

    }
}
