package practice.AdvancedDSA.Stack;

import java.util.Stack;

public class RedundantBraces {
    public static void main(String[] args) {
        System.out.println(solution("((a+a)+a)"));
    }

    public static int solution(String A){
        Stack<String> dataStack = new Stack<>();
//        Stack<String> bracesStack = new Stack<>();
        int count =0;
        for (int i=0; i<A.length(); i++) {
            Character dataChar = A.charAt(i);
            String data = dataChar.toString();
            if (data.equals("(") || data.equals(")") || data.equals("+") || data.equals("-") || data.equals("*") || data.equals("/")) {
                if (data.equals(")")){
                    if (dataStack.peek().equals("(")){
                        dataStack.pop();
                        return 1;
                    }
                    else {
                        while (!dataStack.peek().equals("("))
                            dataStack.pop();
                        dataStack.pop();
                    }
                }
                else
                    dataStack.push(data);
            }
        }
        return 0;
    }
}
