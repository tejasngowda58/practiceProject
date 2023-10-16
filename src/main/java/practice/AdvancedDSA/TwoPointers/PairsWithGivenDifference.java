package practice.AdvancedDSA.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PairsWithGivenDifference {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2));
        int B = 0;
        System.out.println(solve(A, B));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int p1=0, p2=1;
        int diff = 0;
        int count = 0;
        int distinct1 = 0;
        int distinct2 = 0;
        Collections.sort(A);
        while (p1<A.size() && p2< A.size()){
            diff = A.get(p2) - A.get(p1);
            if (diff==B && (distinct1!=A.get(p1) && distinct2!=A.get(p2))) {
                count++;
                distinct1 = A.get(p1);
                distinct2 = A.get(p2);
                p2++;
            }
            else if (diff<B)
                p2++;
            else {
                p1++;
                if (p1==p2)
                    p2++;
            }
        }
        return count;
    }
}
