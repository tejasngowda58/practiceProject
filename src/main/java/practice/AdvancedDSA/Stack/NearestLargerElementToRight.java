package practice.AdvancedDSA.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NearestLargerElementToRight {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(4, 7,3,8));
        System.out.println(nearestLargerElementToRight(A));
    }

    public static ArrayList<Integer> nearestLargerElementToRight(ArrayList<Integer> A) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i=A.size()-1; i>=0; i--){
            while (!stack.isEmpty() && stack.peek()<=A.get(i))
                stack.pop();

            if (!stack.isEmpty())
                res.add(stack.peek());
            else
                res.add(-1);

            stack.push(A.get(i));
        }

        ArrayList<Integer> reverse = new ArrayList<>();
        for (int i= res.size()-1; i>=0; i--)
            reverse.add(res.get(i));
        return reverse;
    }
}
