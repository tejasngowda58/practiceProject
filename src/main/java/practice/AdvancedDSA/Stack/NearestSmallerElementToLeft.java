package practice.AdvancedDSA.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElementToLeft {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(4, 5, 2, 10, 8));
        System.out.println(prevSmaller(A));
    }

    public static ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
     ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
     for (int i=0; i<A.size(); i++){
         while (!stack.isEmpty() && stack.peek()>=(A.get(i))){
             stack.pop();
         }

         if (!stack.isEmpty())
             res.add(stack.peek());
         else
             res.add(-1);

         stack.push(A.get(i));
     }
     return res;
    }
}
