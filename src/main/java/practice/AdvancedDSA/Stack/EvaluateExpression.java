package practice.AdvancedDSA.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class EvaluateExpression {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("2");
        list.add("1");
        list.add("+");
        list.add("3");
        list.add("*");
        System.out.println(evalRPN(list));
    }

    public static int evalRPN(ArrayList<String> A) {
        Stack<String> stack = new Stack<>();
        for (String data: A){
            if (data.equals("+") || data.equals("-") || data.equals("*") || data.equals("/")){
                int op2 = Integer.parseInt(stack.pop());
                int op1 = Integer.parseInt(stack.pop());
                int val;
                if (data.equals("+")){
                    val = op1+op2;
                }
                else if (data.equals("-")){
                    val = op1-op2;
                }
                else if (data.equals("*")){
                    val = op1*op2;
                }
                else {
                    val = op1/op2;
                }
                stack.push(Integer.toString(val));
            }
            else {
                stack.push(data);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
