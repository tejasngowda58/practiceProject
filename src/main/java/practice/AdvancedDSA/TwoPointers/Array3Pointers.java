package practice.AdvancedDSA.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 You are given 3 sorted arrays A, B and C.
 Find i, j, k such that : max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
 Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).
 */

public class Array3Pointers {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3, 5, 6));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(2));
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(3, 4));
        System.out.println(minimize(A,B,C));
    }

    public static int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
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
