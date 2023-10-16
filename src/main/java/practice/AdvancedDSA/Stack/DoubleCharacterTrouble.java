package practice.AdvancedDSA.Stack;

import java.util.Stack;

public class DoubleCharacterTrouble {
    public static void main(String[] args) {
        System.out.println(solve("ab"));
    }

    public static String solve(String A) {
        Stack<String> stack = new Stack<>();
        for (int i=0; i<A.length(); i++){
            Character datachar = A.charAt(i);
            String data = datachar.toString();
            if (stack.isEmpty()){
                stack.push(data);
            } else {
                if (stack.peek().equals(data)){
                    stack.pop();
                }
                else {
                    stack.push(data);
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
}
