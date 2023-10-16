package practice.AdvancedDSA.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class matchBrackets {
    public static void main(String[] args) {
        String A = "{([])}";
        System.out.println(solution(A));
    }

    public static boolean solution(String A) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('}', '{');
        brackets.put(']', '[');
        brackets.put(')', '(');
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<A.length(); i++){
            char data = A.charAt(i);
            if (data == '{' || data == '(' || data == '[' )
                stack.push(data);
            else {
                if (brackets.containsKey(data)){
                    if (!stack.isEmpty() && brackets.get(data) == stack.peek()){
                        stack.pop();
                        continue;
                    }
                    else {
                        return false;
                    }
                }
            }
        }

        if (stack.isEmpty())
            return true;
        return false;
    }
}
