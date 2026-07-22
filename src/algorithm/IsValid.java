package algorithm;

import java.util.Stack;

public class IsValid {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray()){
            //左括号入栈
            if(c=='('||c=='{'||c=='['){
                stack.push(c);
            }else{
                //右括号：栈为空或不匹配就false
                if(stack.isEmpty()) return false;
                char top=stack.pop();
                if(c==')'&& top!='(') return false;
                if(c==']'&& top!='[') return false;
                if(c=='}'&& top!='{') return false;
            }
        }
        return stack.isEmpty(); //栈空了才算完全匹配
    }
}
