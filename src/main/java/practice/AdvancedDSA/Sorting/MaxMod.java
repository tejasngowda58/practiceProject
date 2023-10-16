package practice.AdvancedDSA.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxMod {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(937, 927, 878, 799, 707, 431, 394, 374, 279, 112));
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        for (int i=0; i< A.size(); i++){
            int max = A.get(i);
            int maxPos = i;
            for (int j=i; j<A.size(); j++){
                if (max < A.get(j)) {
                    max = A.get(j);
                    maxPos = j;
                }
            }
            swap(A, i, maxPos);
        }
        System.out.println(A);
        for (int i=1; i<A.size(); i++){
            if (!A.get(0).equals(A.get(i)))
//            if (A.get(0) != A.get(i))
                return A.get(i);
        }
        return 0;
    }

    public static void swap(final List<Integer> A, int p1, int p2) {
        int temp = A.get(p1);
        A.set(p1, A.get(p2));
        A.set(p2, temp);
    }
}
