package practice.AdvancedDSA.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CheckTwoBracketExpression {
    public static void main(String[] args) {
        System.out.println(solve("-(-(-(-a+b)-d+c)-q)", "a-b-d+c+q"));
    }

    public static int solve(String A, String B) {
        A = evaluateExpression(A);
        System.out.println(A);
        B = evaluateExpression(B);
        if(A.equals(B))
            return 1;
        else
            return 0;
    }

    public static String evaluateExpression(String A){
        Stack<String> stack= new Stack<>();
        Map<String, String> map = new HashMap<>();
        map.put("+", "-");
        map.put("-", "+");
        boolean flag = false;
        for (int i=0; i<A.length(); i++){
            Character charData = A.charAt(i);
            String data = charData.toString();
            if (data.equals("(")){
                if (!stack.isEmpty() && stack.peek().equals("-"))
                    flag = !flag;
            }
            else if (data.equals(")")){
                if (flag==true){
                    flag=false;
                }
            }
            else if (data.equals("+") || data.equals("-") ){
                if (flag) {
                    if (!stack.isEmpty() && (stack.peek().equals("+") || stack.peek().equals("-")) ) {
                        stack.pop();
                        stack.push(map.get(data));
                    }
                    else
                        stack.push(map.get(data));
                }
                else {
                    if (!stack.isEmpty() && (stack.peek().equals("+") || stack.peek().equals("-")) ) {
                        stack.pop();
                        stack.push(data);
                    }
                    stack.push(data);
                }
            }
            else {
                stack.push(data);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            String value = stack.pop();
            if (stack.isEmpty() && value.equals("+"))
                continue;
            stringBuilder.append(value);
        }
        return stringBuilder.reverse().toString();
    }
}
