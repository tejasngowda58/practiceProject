package practice.AdvancedDSA.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PassingGame {
    public static void main(String[] args) {
        int A = 1;
        int B = 23;
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(86, 63, 60, 0, 47, 0, 99, 9, 0, 0));
        System.out.println(solve(A, B, C));
    }

    public static int solve(int A, int B, ArrayList<Integer> C) {
        Stack<Integer> stack = new Stack<>();
        stack.push(B);
        for (int data: C) {
            if (data == 0)
                stack.pop();
            else
                stack.push(data);
        }
        return stack.peek();
    }
}
