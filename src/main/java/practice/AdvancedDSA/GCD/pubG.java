package practice.AdvancedDSA.GCD;

import java.util.ArrayList;
import java.util.Arrays;

public class pubG {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2,3,4));
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        int ans = 0;
        for (int i=0; i<A.size(); i++){
            ans = gcd(ans, A.get(i));
        }
        return ans;
    }

    public static int gcd(int A, int B) {
        if (B==0)
            return A;
        return gcd(B, A%B);
    }
}
