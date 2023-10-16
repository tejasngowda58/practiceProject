package practice.AdvancedDSA.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayWithConsecutiveElements {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList( 1, 1, 1, 5 ,5));
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<A.size(); i++){
            set.add(A.get(i));
            if(A.get(i) < min)
                min = A.get(i);
            if(A.get(i) > max)
                max = A.get(i);
        }

        if ((set.size() == A.size()) && ((max-min+1) == A.size()) )
            return 1;
        else return 0;
    }
}
