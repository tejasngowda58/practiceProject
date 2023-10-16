package practice.AdvancedDSA.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class MinAbsDifference {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 4, 5, 8, 10));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(6, 9, 15));
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(2, 3, 6, 6));
        System.out.println(solve(A,B,C));
    }

    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int ans = Integer.MAX_VALUE;
        int p1=0, p2=0, p3=0;
        while (p1<A.size() && p2< B.size() && p3<C.size()){
            int min = Integer.min(A.get(p1), B.get(p2));
            min = Integer.min(C.get(p3), min);
            int max = Integer.max(A.get(p1), B.get(p2));
            max = Integer.max(C.get(p3), max);
            int val = max-min;
            ans = Integer.min(ans, val);

            if (A.get(p1) == min)
                p1++;
            else if (B.get(p2) == min)
                p2++;
            else
                p3++;
        }
        return ans;
    }
}
