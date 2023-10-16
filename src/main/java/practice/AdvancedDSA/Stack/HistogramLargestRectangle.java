package practice.AdvancedDSA.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class HistogramLargestRectangle {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 1, 5, 6, 2, 3));
        System.out.println(smallerElementToLeft(A));

        System.out.println(smallerElementToRight(A));

        int i = largestRectangleArea(A);
        System.out.println(i);
    }

    public static  int largestRectangleArea(ArrayList<Integer> A) {
        int ans = 0;
        ArrayList<Integer> smallerLeft = smallerElementToLeft(A);
        ArrayList<Integer> smallerRight = smallerElementToRight(A);
        for (int i=0; i<A.size(); i++){
            int l = smallerLeft.get(i);
            int r = smallerRight.get(i);
//            System.out.println("l="+l +" " + "r="+r);
            ans = Math.max(ans, (r-l-1)*A.get(i));
        }
        return ans;
    }

    private static ArrayList<Integer> smallerElementToLeft(ArrayList<Integer> A){
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i=0; i<A.size(); i++){
            while (!stack.isEmpty() && A.get(stack.peek())>=A.get(i))
                stack.pop();

            if (!stack.isEmpty())
                res.add(stack.peek());
            else
                res.add(-1);

            stack.push(i);
        }
        return res;
    }

    private static ArrayList<Integer> smallerElementToRight(ArrayList<Integer> A){
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i=A.size()-1; i>=0; i--){
            while (!stack.isEmpty() && A.get(stack.peek())>=A.get(i))
                stack.pop();

            if (!stack.isEmpty())
                res.add(stack.peek());
            else
                res.add(A.size());

            stack.push(i);
        }

        ArrayList<Integer> reverse = new ArrayList<>();
        for (int i= res.size()-1; i>=0; i--)
            reverse.add(res.get(i));
        return reverse;
    }
}
