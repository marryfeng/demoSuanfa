package BSTPackage;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/9/21
 * @Version: 1.0
 */

public class Main {
    public static void main(String[] args){
        BST<Integer> bst=new BST<>();
        int[] nums={3,2,1,4,5};
        for (int i=0;i<nums.length;i++){
            bst.addEle(nums[i]);
        }
        bst.preOrder();
        System.out.println(bst);
        bst.inOrder();
        System.out.println(bst);
        bst.postOrder();
        System.out.println(bst);
    }
}
