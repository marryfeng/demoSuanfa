package stackDemo;
import java.util.Stack;
/**
 * @Author: li.feng
 * @Email: li.feng@rograndec.com
 * @CreateDate: 2018/9/18
 * @Version: 3.0
 */
//括号匹配问题：利用栈来解决问题：左括号依次压入栈，然后判断后面的右括号与栈顶元素是否匹配，如果匹配，则栈顶元素出栈。依次这样栈顶判断然后出栈
public class KuoHaoQuestion {
     boolean isMatch(String s) {
       /* Character 类用于对单个字符进行操作。
        Character 类在对象中包装一个基本类型 char 的值
        */
        Stack<Character> stack=new Stack<Character>();
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (c == ')' && top != '(') {
                    return false;
                }
                if (c == '}' && top != '{') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args){
        System.out.println(new KuoHaoQuestion().isMatch("{[]}"));
    }

}


