package task_4;

import java.util.EmptyStackException;
import java.util.Stack;

public class BracketString {
    public boolean isBalanced(String input){
        Stack<Character>stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char sign = input.charAt(i);
            if (sign == '('){
                stack.push('(');
            }else if(sign == ')'){
                try {
                    stack.pop();
                }catch (EmptyStackException e){
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
