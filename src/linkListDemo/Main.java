package linkListDemo;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/9/20
 * @Version: 1.0
 */

public class Main {
    public static void main(String[] args){
        LinkList<Integer> linkList=new LinkList<>();
        for(int i=0;i<5;i++){
            linkList.addFirst(i);
        }
        System.out.println(linkList);
        linkList.addLast(8888);
        System.out.println(linkList);
        linkList.delEle(0);
        System.out.println(linkList);
        linkList.updateEle(0,100);
        System.out.println(linkList);
        System.out.println(linkList.getEle(0));
        linkList.addLast(99999);
        System.out.println(linkList);
        linkList.addEle(3,100000);
        System.out.println(linkList);

    }
}
