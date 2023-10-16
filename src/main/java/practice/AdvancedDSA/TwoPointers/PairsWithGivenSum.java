package practice.AdvancedDSA.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class PairsWithGivenSum {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5, 10, 20, 100, 105));
        System.out.println(solve(A, 110));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int p1=0;
        int p2= A.size()-1;
        int count=0;
        while (p1<p2){
            int sum =A.get(p1) + A.get(p2);
            if (B==sum){
                count++;
                p1++;
                p2--;
            }
            else if (sum>B){
                p2--;
            }
            else {
                p1++;
            }
        }
        return count;
    }
}
