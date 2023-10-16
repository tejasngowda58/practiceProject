package practice.AdvancedDSA.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class UniqueElements {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2,3, 4, 5, 4, 3));
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A){
        int count = 0;
        Collections.sort(A);

        for (int i=0; i<A.size()-1; i++){
            if (A.get(i) < A.get(i+1))
                continue;
            else {
                count += A.get(i) - A.get(i+1) + 1;
                A.set(i+1, A.get(i)+1);
            }
        }
        return count;
    }
}
