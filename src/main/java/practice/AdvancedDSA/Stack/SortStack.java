package practice.AdvancedDSA.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(66, 96, 43, 28, 14, 1, 41, 76, 70, 81, 22, 11, 42, 78, 4, 88, 70, 43, 90, 6, 12));
        System.out.println(solve(A));
    }

    public static  ArrayList<Integer> solve(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i=0; i<A.size(); i++){
            stack.push(A.get(i));
        }
        while (!stack.isEmpty()) {
            int temp = stack.pop();

            while (!stack2.isEmpty() && temp>stack2.peek())
                stack.push(stack2.pop());

            stack2.push(temp);
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!stack2.isEmpty()){
            res.add(stack2.pop());
        }
        return res;
    }
}
