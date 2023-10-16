package practice.AdvancedDSA.GCD;

import java.util.ArrayList;
import java.util.Arrays;

/**
Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor)
 of the remaining array is maximum.
Find the maximum value of GCD.
 */
public class DropOne {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(12, 15, 19));
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        int prefixGCD[] = new int[A.size()];
        int suffixGCD[] = new int[A.size()];

        prefixGCD[0] = A.get(0);
//        System.out.println("prefix array:");
        for(int i=1; i<A.size(); i++)
            prefixGCD[i] = gcd(prefixGCD[i-1], A.get(i));

//        System.out.println("prefix array:");
//        for(int i=0; i<A.size(); i++)
//            System.out.println(prefixGCD[i]);

        suffixGCD[A.size()-1] = A.get(A.size()-1);
        for (int i=A.size()-2; i>=0; i--)
            suffixGCD[i] = gcd(suffixGCD[i+1], A.get(i));

        int ans = Integer.max(suffixGCD[1], prefixGCD[A.size()-2]);
//        System.out.println(ans);
        for (int i=1; i<A.size()-1; i++){
            int firstGCD = prefixGCD[i-1];
            int secondGCD = suffixGCD[i+1];

            ans = Integer.max(ans, gcd(firstGCD, secondGCD));
        }

//        System.out.println("suffix array:");
//        for(int i=0; i<A.size(); i++)
//            System.out.println(suffixGCD[i]);

        return ans;
    }

    public static int gcd(int A, int B) {
        if (B==0)
            return A;
        return gcd(B, A%B);
    }
}
